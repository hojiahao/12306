package cn.edu.szu.train.member.service;

import cn.edu.szu.train.common.exception.BusinessException;
import cn.edu.szu.train.common.exception.BusinessExceptionEnum;
import cn.edu.szu.train.common.util.SMSUtil;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.edu.szu.train.common.util.ValidateCodeUtil;
import cn.edu.szu.train.member.domain.Member;
import cn.edu.szu.train.member.domain.MemberExample;
import cn.edu.szu.train.member.mapper.MemberMapper;
import cn.edu.szu.train.member.req.MemberRegisterReq;
import cn.edu.szu.train.member.req.MemberSendCodeReq;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private static final Logger LOG = LoggerFactory.getLogger(MemberService.class);

    @Resource
    private MemberMapper memberMapper;

    public int count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    public long register(MemberRegisterReq req) {
        String phoneNumber = req.getPhoneNumber();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(phoneNumber);
        List<Member> memberList = memberMapper.selectByExample(memberExample);

        if (CollUtil.isNotEmpty(memberList)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }

        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(phoneNumber);
        memberMapper.insert(member);
        return member.getId();
    }

    public void sendCode(MemberSendCodeReq req) {
        String phoneNumber = req.getPhoneNumber();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(phoneNumber);
        List<Member> memberList = memberMapper.selectByExample(memberExample);

        // 如果手机号不存在，则插入一条记录
        if (CollUtil.isEmpty(memberList)) {
            LOG.info("手机号不存在，插入一条记录");
            Member member = new Member();
            member.setId(SnowUtil.getSnowflakeNextId());
            member.setMobile(phoneNumber);
            memberMapper.insert(member);
        }
        else {
            LOG.info("手机号存在，不插入记录");
        }

        // 生成验证码
        Integer code = ValidateCodeUtil.generateValidateCode(6);
        LOG.info("您的短信验证码为：{}", code);
        // 将手机号、短信验证码、有效期、是否已使用、业务类型、发送时间和使用时间保存至短信记录表
        SMSUtil.sendMessage("12306铁路购票服务", "您的验证码为：${code}，请勿泄露于他人", phoneNumber, code.toString());
        // 对接短信通道，发送短信

    }
}
