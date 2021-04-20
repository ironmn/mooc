package edu.dhu.mooc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/4/7 14:26
 * @describe 在线浏览的文件系统
 */

@Api(value = "文件系统控制器")
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {

    //物理文件系统的地址
    private String rootPath = "D:\\file center";

    @ApiOperation(value = "在线预览PDF文件",notes = "从前端接受一个参数，用于控制文件的名字")
    @GetMapping("/pdf/{filename}")
    public void pdfStreamHandler(@PathVariable("filename") String filename, HttpServletResponse response) {
        //PDF文件地址
        File file = new File(rootPath+"\\pdf\\"+filename+".pdf");

        if (file.exists()) {
            byte[] data = null;
            FileInputStream input=null;
            try {
                input= new FileInputStream(file);
                data = new byte[input.available()];
                input.read(data);
                response.getOutputStream().write(data);
            } catch (Exception e) {
                System.out.println("pdf文件处理异常：" + e);
            }finally{
                try {
                    if(input!=null){
                        input.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @PostMapping("/upload")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "上传的文件实体"),
            @ApiImplicitParam(name = "f_name", value = "上传的文件名")
    })
    public Map<String,Object> fileUpload(MultipartFile file,@RequestParam("f_name") String f_name){
        Map<String,Object> result = new HashMap<>();
        //先获取文件的原始名称
        String originName = file.getOriginalFilename();
        if(!originName.endsWith(".pdf")){
            result.put("status","error");
            result.put("msg","文件类型不对!");
            return result;
        }
        //在服务器端要保存的文件名
        String newName = f_name+".pdf";
        try{
            //把web接收到的数据格式转为pdf
            File newFile = new File(rootPath+"\\pdf\\"+newName);
            //如果文件已经存在了，就删除文件
            newFile.delete();
            //把request中的文件写入到服务器本地文件
            file.transferTo(newFile);
            result.put("status","success");
            result.put("msg","文件上传成功！");
        }
        catch (Exception e){
            //捕获异常信息
            result.put("status","error");
            result.put("msg",e.getMessage());
            log.error(e.getMessage());
        }
        return result;
    }
}
