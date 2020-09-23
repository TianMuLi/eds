package com.tl.ucenterservice.mapper;

import com.tl.ucenterservice.entity.UcenterMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 会员表 Mapper 接口
 * </p>
 *
 * @author tl
 * @since 2020-09-21
 */
public interface UcenterMemberMapper extends BaseMapper<UcenterMember> {
    Integer countRegisterDay(String day);
}
