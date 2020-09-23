package com.tl.statistics.service;

import com.tl.statistics.entity.Daily;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 服务类
 * </p>
 *
 * @author tl
 * @since 2020-09-22
 */
public interface DailyService extends IService<Daily> {

    void registerCount(String day);

    Map<String, Object> showData(String type, String begin, String end);

}
