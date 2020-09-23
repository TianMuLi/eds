package com.tl.eduorder.service;

import com.tl.eduorder.entity.TOrder;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author tl
 * @since 2020-09-22
 */
public interface TOrderService extends IService<TOrder> {

    String createOrder(String courseId, String memberIdByJwtToken);

}
