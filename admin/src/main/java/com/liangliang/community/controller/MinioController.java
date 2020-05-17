package com.liangliang.community.controller;

import com.liangliang.community.api.CommonResult;
import com.liangliang.community.dto.MinioUploadDto;
import io.minio.MinioClient;
import io.minio.policy.PolicyType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created by Liangliang on 2020/5/17
 */
@Api(tags = "MinioController", description = "MinIO对象存储管理")
@Controller
@RequestMapping("/api/minio")
public class MinioController {

    private final Logger logger = LoggerFactory.getLogger(MinioController.class);
    @Value("${minio.endPoint}")
    private String endPoint;
    @Value("${minio.accessKey}")
    private String accessKey;
    @Value("${minio.secretKey}")
    private String secretKey;
    @Value("${minio.bucketName}")
    private String bucketName;

    @ApiOperation("文件上传")
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult upload(@RequestParam("file") MultipartFile file) {
        try {
            // 使用MinIO服务的URL，端口，Access key和Secret key创建一个MinioClient对象
            MinioClient minioClient = new MinioClient(endPoint, accessKey, secretKey);

            // 检查存储桶是否已经存在
            boolean isExist = minioClient.bucketExists(bucketName);
            if (isExist) {
                logger.info("存储桶已经存在！");
            } else {
                // 创建一个存储桶bucketName
                minioClient.makeBucket(bucketName);
                // 设置只读权限
                minioClient.setBucketPolicy(bucketName, "*.*", PolicyType.READ_ONLY);
            }
            String filename = file.getOriginalFilename();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            // 设置存储对象名称
            String objectName = sdf.format(new Date()) + "/" + filename;
            minioClient.putObject(bucketName, objectName, file.getInputStream(), file.getContentType());
            logger.info("文件上传成功！");
            MinioUploadDto minioUploadDto = new MinioUploadDto();
            minioUploadDto.setUrl(endPoint + "/" + bucketName + "/" + objectName);
            minioUploadDto.setName(filename);
            return CommonResult.success(minioUploadDto);
        } catch (Exception e) {
            logger.info("上传发生错误：{}", e.getMessage());
        }
        return CommonResult.failed();
    }
}
