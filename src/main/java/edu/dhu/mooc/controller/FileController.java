package edu.dhu.mooc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/4/7 14:26
 * @describe 在线浏览的文件系统
 */

@Api(value = "文件系统控制器")
@RestController
@RequestMapping("/file")
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
}
