package com.tl.vod.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.tl.servicebase.exceptionhandler.edsException;
import com.tl.vod.service.VodService;
import com.tl.vod.utils.ConstantVodUtils;
import com.tl.vod.utils.InitObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class VodServiceImpl implements VodService {

    @Override
    public String uploadVideo(MultipartFile file) {



        String fileName=file.getOriginalFilename();
        String title=fileName.substring(0,fileName.lastIndexOf("."));
        InputStream inputStream= null;
        try {
            inputStream = file.getInputStream();


            UploadStreamRequest request = new UploadStreamRequest(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET, title, fileName, inputStream);

            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);
            System.out.print("RequestId=" + response.getRequestId() + "\n");  //请求视频点播服务的请求ID
            String VideoId=null;
            if (response.isSuccess()) {
//            System.out.print("VideoId=" + response.getVideoId() + "\n");
                VideoId= response.getVideoId();
            } else { //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
                System.out.print("VideoId=" + response.getVideoId() + "\n");
                System.out.print("ErrorCode=" + response.getCode() + "\n");
                System.out.print("ErrorMessage=" + response.getMessage() + "\n");
            }
            return VideoId;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void removeMoreVideo(List videoIdList) {
        try{
            DefaultAcsClient client = InitObject.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
            DeleteVideoRequest request = new DeleteVideoRequest();
            String join = StringUtils.join(videoIdList.toArray(), ",");

            request.setVideoIds(join);

            client.getAcsResponse(request);

        }catch (Exception e){
            e.printStackTrace();
            throw  new edsException(2001,"删除视频失败");
        }
    }
}

