package edu.dhu.mooc.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

/**
 * @author Xie yiming
 * @version 1.0
 * @date 2021/4/14 14:08
 * @describe
 */

public class FileOperationTest {

    @Test
    public void testFileDelete(){

    }

    //测试通过文件名查找文件
    @Test
    public void testFileExist(){
        String path = FileSystemUtil.PDF_CONTEXT_PATH
                +"aaa004_1"+".pdf";
        File test_file = new File(path);
        if(test_file.exists()){
            System.out.println("已上传");
        }
        else{
            System.out.println("未上传");
        }
    }
}
