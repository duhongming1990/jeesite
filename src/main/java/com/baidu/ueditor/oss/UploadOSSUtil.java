package com.baidu.ueditor.oss;

import com.aliyun.oss.OSSClient;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/6/12 15:34
 */
public class UploadOSSUtil {
    public UploadOSSUtil(){}

    public static void uploadImgAliyun(InputStream inputStream , String fileName)
            throws FileNotFoundException {
        String accesskeyId = "LTAIRh2bYF4tXUwa" ;
        String accessKeySecret = "740ui17o8M7sa6xpOJ9wORGayyRZvZ" ;
        String endpoint = "http://oss-cn-beijing.aliyuncs.com/" ;
        String bucketName = "ueditor-jeestie-test" ;
        OSSClient client = new OSSClient(endpoint,accesskeyId,accessKeySecret);
        //此处"xxxx/yyyy/"+fileName,表示上传至阿里云中xxxx文件夹下的yyyy文件夹中，请修改为自己的路径即可
        client.putObject(bucketName, "ueditor/"+fileName, inputStream);
        client.shutdown();
    }
}