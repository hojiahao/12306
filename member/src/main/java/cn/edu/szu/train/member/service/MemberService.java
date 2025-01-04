package cn.edu.szu.train.member.service;

import cn.edu.szu.train.common.exception.BusinessException;
import cn.edu.szu.train.common.exception.BusinessExceptionEnum;
import cn.edu.szu.train.common.util.SMSUtil;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.edu.szu.train.common.util.ValidateCodeUtil;
import cn.edu.szu.train.member.domain.Member;
import cn.edu.szu.train.member.domain.MemberExample;
import cn.edu.szu.train.member.mapper.MemberMapper;
import cn.edu.szu.train.member.req.MemberLoginReq;
import cn.edu.szu.train.member.req.MemberRegisterReq;
import cn.edu.szu.train.member.req.MemberSendCodeReq;
import cn.edu.szu.train.member.response.MemberLoginResponse;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
        String mobile = req.getMobile();
        Member memberDB = selectByMobile(mobile);

        if (ObjectUtil.isNull(memberDB)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }

        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }

    public void sendCode(MemberSendCodeReq req) throws Exception {
        String mobile = req.getMobile();
        Member memberDB = selectByMobile(mobile);

        // 如果手机号不存在，则插入一条记录
        if (ObjectUtil.isNull(memberDB)) {
            LOG.info("手机号不存在，插入一条记录");
            Member member = new Member();
            member.setId(SnowUtil.getSnowflakeNextId());
            member.setMobile(mobile);
            memberMapper.insert(member);
        }
        else {
            LOG.info("手机号存在，不插入记录,");
            Integer code = ValidateCodeUtil.generateValidateCode(6);
            LOG.info("您的短信验证码为：{}", code);
            // 将手机号、短信验证码、有效期、是否已使用、业务类型、发送时间和使用时间保存至短信记录表
            SMSUtil.sendMessage("train12306", "SMS_477685011", mobile, code.toString());
        }

        // 生成验证码
//        int code = RandomUtil.randomInt(6);
//        LOG.info("您的短信验证码为：{}", code);
        // 对接短信通道，发送短信
    }

    public MemberLoginResponse login(MemberLoginReq req) {
        String mobile = req.getMobile();
        String code = req.getCode();
        Member memberDB = selectByMobile(mobile);

        // 如果手机号不存在，则插入一条记录
        if (ObjectUtil.isNull(memberDB)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_NOT_EXIST);
        }
        // 校验短信验证码
        if (!"123456".equals(code)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_CODE_ERROR);
        }

        return BeanUtil.copyProperties(memberDB, MemberLoginResponse.class);
    }

    private Member selectByMobile(String mobile) {
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> memberList = memberMapper.selectByExample(memberExample);
        if (CollUtil.isNotEmpty(memberList)) {
            return memberList.get(0);
        }
        else {
            return null;
        }
    }
}
