package com.tl.eduorder.service.impl;

import com.tl.commonutils.orderVo.CourseWebVoOrder;
import com.tl.commonutils.orderVo.UcenterMemberOrder;
import com.tl.eduorder.client.EduClient;
import com.tl.eduorder.client.UcenterClient;
import com.tl.eduorder.entity.TOrder;
import com.tl.eduorder.mapper.TOrderMapper;
import com.tl.eduorder.service.TOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tl.eduorder.utils.OrderNoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author tl
 * @since 2020-09-22
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements TOrderService {

    @Autowired
    private UcenterClient ucenterClient;
    @Autowired
    private EduClient eduClient;
    @Override
    public String createOrder(String courseId, String memberId) {

        UcenterMemberOrder userInfoOrder = ucenterClient.getUserInfoOrder(memberId);
        CourseWebVoOrder courseWebVoOrder = eduClient.GetCourseInfoOrder(courseId);

        TOrder order = new TOrder();
        order.setOrderNo(OrderNoUtil.getOrderNo());
        order.setCourseId(courseId);
        order.setCourseTitle(courseWebVoOrder.getTitle());
        order.setCourseCover(courseWebVoOrder.getCover());
        order.setTeacherName(courseWebVoOrder.getTeacherName());
        order.setTotalFee(courseWebVoOrder.getPrice());
        order.setMemberId(memberId);
        order.setMobile(userInfoOrder.getMobile());
        order.setNickname(userInfoOrder.getNickname());
        order.setStatus(0);
        order.setPayType(1);
        baseMapper.insert(order);

        return order.getOrderNo();
    }

}
