package cn.edu.szu.train.member.service;

import cn.edu.szu.train.member.domain.Member;
import cn.edu.szu.train.member.domain.MemberExample;
import cn.edu.szu.train.member.mapper.MemberMapper;
import cn.edu.szu.train.member.req.MemberRegisterReq;
import cn.hutool.core.collection.CollUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Resource
    private MemberMapper memberMapper;

    public int count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    public long register(MemberRegisterReq req) {
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> memberList = memberMapper.selectByExample(memberExample);

        if (CollUtil.isNotEmpty(memberList)) {
            throw new RuntimeException("Mobile Phone Number Registered.");
        }

        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }
}
