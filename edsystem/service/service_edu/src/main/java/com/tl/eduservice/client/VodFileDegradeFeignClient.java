package com.tl.eduservice.client;
/**
 * @Author tl
 * @Date 2020/9/19
 */

import com.tl.commonutils.R;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VodFileDegradeFeignClient implements VodClient {

    @Override
    public R remove(String id) {
        return R.error().message("删除视频失败");
    }

    @Override
    public R deleteBatch(List<String> videoIdList) {
        return R.error().message("删除多个视频失败");
    }
}
