package cn.edu.szu.train.member.service;

import cn.edu.szu.train.common.aspect.LogAspect;
import cn.edu.szu.train.common.context.LoginMemberContext;
import cn.edu.szu.train.common.response.PageResp;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.edu.szu.train.member.domain.${Domain};
import cn.edu.szu.train.member.domain.${Domain}Example;
import cn.edu.szu.train.member.mapper.${Domain}Mapper;
import cn.edu.szu.train.member.req.${Domain}QueryReq;
import cn.edu.szu.train.member.req.${Domain}SaveReq;
import cn.edu.szu.train.member.response.${Domain}QueryResponse;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ${Domain}Service {
    private final static Logger LOG = LoggerFactory.getLogger(${Domain}Service.class);

    @Resource
    private ${Domain}Mapper ${domain}Mapper;

    public void save(${Domain}SaveReq req) {
        DateTime now = DateTime.now();
        ${Domain} ${domain} = BeanUtil.copyProperties(req, ${Domain}.class);
        if (ObjectUtil.isNull(${domain}.getId())) {
            ${domain}.setMemberId(LoginMemberContext.getId());
            ${domain}.setId(SnowUtil.getSnowflakeNextId());
            ${domain}.setCreateTime(now);
            ${domain}.setUpdateTime(now);
            ${domain}Mapper.insert(${domain});
        }
        else {
            ${domain}.setUpdateTime(now);
            ${domain}Mapper.updateByPrimaryKey(${domain});
        }
    }

    public PageResp<${Domain}QueryResponse> queryList(${Domain}QueryReq req) {
        ${Domain}Example ${domain}Example = new ${Domain}Example();
        ${Domain}Example.Criteria criteria = ${domain}Example.createCriteria();
        if (ObjectUtil.isNotNull(req.getMemberId())){
            criteria.andMemberIdEqualTo(req.getMemberId());
        }
        LOG.info("query page number: {}", req.getPage());
        LOG.info("items per page: {}", req.getPageSize());
        PageHelper.startPage(req.getPage(), req.getPageSize());
        List<${Domain}> ${domain}s = ${domain}Mapper.selectByExample(${domain}Example);
        PageInfo<${Domain}> pageInfo = new PageInfo<>(${domain}s);
        LOG.info("total rows: {}", pageInfo.getTotal());
        LOG.info("total pages: {}", pageInfo.getPages());
        List<${Domain}QueryResponse> list = BeanUtil.copyToList(${domain}s, ${Domain}QueryResponse.class);
        PageResp<${Domain}QueryResponse> pageResp = new PageResp<>();
        pageResp.setRows(list);
        pageResp.setTotal(pageInfo.getTotal());
        return pageResp;
    }

    public void delete(Long id) {
        ${domain}Mapper.deleteByPrimaryKey(id);
    }
}
