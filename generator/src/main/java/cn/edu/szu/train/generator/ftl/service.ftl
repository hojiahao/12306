package cn.edu.szu.train.${module}.service;

import cn.edu.szu.train.common.aspect.LogAspect;
import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.edu.szu.train.${module}.domain.${Domain};
import cn.edu.szu.train.${module}.domain.${Domain}Example;
import cn.edu.szu.train.${module}.mapper.${Domain}Mapper;
import cn.edu.szu.train.${module}.request.${Domain}QueryRequest;
import cn.edu.szu.train.${module}.request.${Domain}SaveRequest;
import cn.edu.szu.train.${module}.response.${Domain}QueryResponse;
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
private static final Logger LOG = LoggerFactory.getLogger(${Domain}Service.class);

@Resource
private ${Domain}Mapper ${domain}Mapper;

public void save(${Domain}SaveRequest req) {
DateTime now = DateTime.now();
${Domain} ${domain} = BeanUtil.copyProperties(req, ${Domain}.class);
if (ObjectUtil.isNull(${domain}.getId())) {
${domain}.setId(SnowUtil.getSnowflakeNextId());
${domain}.setCreateTime(now);
${domain}.setUpdateTime(now);
${domain}Mapper.insert(${domain});
} else {
${domain}.setUpdateTime(now);
${domain}Mapper.updateByPrimaryKey(${domain});
}
}

public PageResponse<${Domain}QueryResponse> queryList(${Domain}QueryRequest req) {
    ${Domain}Example ${domain}Example = new ${Domain}Example();
    ${domain}Example.setOrderByClause("id desc");
    ${Domain}Example.Criteria criteria = ${domain}Example.createCriteria();

    LOG.info("查询页码：{}", req.getPage());
    LOG.info("每页条数：{}", req.getPageSize());
    PageHelper.startPage(req.getPage(), req.getPageSize());
    List<${Domain}> ${domain}List = ${domain}Mapper.selectByExample(${domain}Example);

    PageInfo<${Domain}> pageInfo = new PageInfo<>(${domain}List);
    LOG.info("总行数：{}", pageInfo.getTotal());
    LOG.info("总页数：{}", pageInfo.getPages());

    List<${Domain}QueryResponse> list = BeanUtil.copyToList(${domain}List, ${Domain}QueryResponse.class);

        PageResponse<${Domain}QueryResponse> pageResponse = new PageResponse<>();
            pageResponse.setTotal(pageInfo.getTotal());
            pageResponse.setRows(list);
            return pageResponse;
            }

            public void delete(Long id) {
            ${domain}Mapper.deleteByPrimaryKey(id);
            }
}
