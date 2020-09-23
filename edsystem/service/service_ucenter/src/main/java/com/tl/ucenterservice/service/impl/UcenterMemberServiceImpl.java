package com.tl.ucenterservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tl.commonutils.JwtUtils;
import com.tl.commonutils.MD5;
import com.tl.servicebase.exceptionhandler.edsException;
import com.tl.ucenterservice.entity.UcenterMember;
import com.tl.ucenterservice.entity.vo.RegisterVo;
import com.tl.ucenterservice.mapper.UcenterMemberMapper;
import com.tl.ucenterservice.service.UcenterMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author tl
 * @since 2020-09-21
 */
@Service
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public String login(UcenterMember member) {
        String mobile = member.getMobile();
        String password = member.getPassword();
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)){
            throw new edsException(20001,"登录失败");
        }
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        UcenterMember mobileMember = baseMapper.selectOne(wrapper);
        if (mobileMember==null){
            throw new edsException(20001,"手机号未注册");
        }

        String encrypt = MD5.encrypt(password);
        if (!encrypt.equals(mobileMember.getPassword())){
            throw new edsException(20001,"密码错误");
        }
        if (mobileMember.getIsDisabled()){
            throw new edsException(20001,"该账号被禁用");
        }
        String jwtToken = JwtUtils.getJwtToken(mobileMember.getId(), mobileMember.getNickname());

        return jwtToken;
    }

    @Override
    public void register(RegisterVo registerVo) {
        String code = registerVo.getCode();
        String mobile = registerVo.getMobile();
        String nickname = registerVo.getNickname();
        String password = registerVo.getPassword();

        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password) || StringUtils.isEmpty(nickname)){
            throw new edsException(20001,"注册失败");
        }

        String redisCode = redisTemplate.opsForValue().get(mobile);
        if (!redisCode.equals(code)){
            throw new edsException(20001,"验证码错误");
        }
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        Integer count = baseMapper.selectCount(wrapper);
        if (count>0){
            throw new edsException(20001,"该手机号已注册！");
        }
        UcenterMember member = new UcenterMember();
        member.setMobile(mobile);
        member.setNickname(nickname);
        member.setPassword(MD5.encrypt(password));
        member.setIsDisabled(false);
        member.setAvatar("https://eduguli-0409.oss-cn-beijing.aliyuncs.com/2020/07/23/0038055ced1a49ef95f54aead68b685cfile.pnghttps://eduguli-0409.oss-cn-beijing.aliyuncs.com/2020/07/23/0038055ced1a49ef95f54aead68b685cfile.png");
        baseMapper.insert(member);

    }

    @Override
    public UcenterMember getOpenIdMember(String openid) {
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("openid",openid);
        UcenterMember member = baseMapper.selectOne(wrapper);
        return member;
    }

    @Override
    public Integer countRegisterDay(String day) {

        return baseMapper.countRegisterDay(day);
    }
}
