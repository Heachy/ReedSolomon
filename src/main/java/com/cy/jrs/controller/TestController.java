package com.cy.jrs.controller;

import com.cy.jrs.config.JrsManager;
import com.cy.jrs.utils.CodingUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Haechi
 */

@RestController
@RequestMapping("/test")
public class TestController {


    @RequestMapping("/hello")
    public String hello(){

        System.out.println(JrsManager.config.getDataShards());

        return "hello";
    }

    @RequestMapping("/encode")
    public String encode(MultipartFile file) {
        long sTime = System.currentTimeMillis();


        byte[][] shards = CodingUtil.encodeFile(file);

        String outputFilePathPrefix = "repository/shard";

        // 写文件
        for (int i = 0; i < CodingUtil.TOTAL_SHARDS; i++) {
            String outputFilePath = outputFilePathPrefix + i+".txt";

            try (FileOutputStream outputStream = new FileOutputStream(outputFilePath)) {
                outputStream.write(shards[i]);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 结束时间
        long etime = System.currentTimeMillis();
        // 计算执行时间
        System.out.printf("执行时长：%d 毫秒.", (etime - sTime));

        return "ok";
    }

    @RequestMapping("/fileCov")
    public String covFile(MultipartFile [] files){

        long sTime = System.currentTimeMillis();

        byte[] fileByteArr = CodingUtil.getFileByFiles(files);

        try (FileOutputStream outputStream = new FileOutputStream("repository/JavaReedSolomon – TestController.java 2024-03-25 22-49-44.mp4")) {
            outputStream.write(fileByteArr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 结束时间
        long etime = System.currentTimeMillis();
        // 计算执行时间
        System.out.printf("执行时长：%d 毫秒.", (etime - sTime));

        return "ok";
    }
}
