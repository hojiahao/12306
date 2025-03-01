package cn.edu.szu.train.business.service;

import cn.edu.szu.train.common.response.PageResponse;
import cn.edu.szu.train.common.util.SnowUtil;
import cn.edu.szu.train.business.domain.SKToken;
import cn.edu.szu.train.business.domain.SKTokenExample;
import cn.edu.szu.train.business.mapper.SKTokenMapper;
import cn.edu.szu.train.business.request.SKTokenQueryRequest;
import cn.edu.szu.train.business.request.SKTokenSaveRequest;
import cn.edu.szu.train.business.response.SKTokenQueryResponse;
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
public class SKTokenService {
private static final Logger LOG = LoggerFactory.getLogger(SKTokenService.class);

@Resource
private SKTokenMapper skTokenMapper;

public void save(SKTokenSaveRequest req) {
DateTime now = DateTime.now();
SKToken skToken = BeanUtil.copyProperties(req, SKToken.class);
if (ObjectUtil.isNull(skToken.getId())) {
skToken.setId(SnowUtil.getSnowflakeNextId());
skToken.setCreateTime(now);
skToken.setUpdateTime(now);
skTokenMapper.insert(skToken);
} else {
skToken.setUpdateTime(now);
skTokenMapper.updateByPrimaryKey(skToken);
}
}

public PageResponse<SKTokenQueryResponse> queryList(SKTokenQueryRequest req) {
    SKTokenExample skTokenExample = new SKTokenExample();
    skTokenExample.setOrderByClause("id desc");
    SKTokenExample.Criteria criteria = skTokenExample.createCriteria();

    LOG.info("查询页码：{}", req.getPage());
    LOG.info("每页条数：{}", req.getPageSize());
    PageHelper.startPage(req.getPage(), req.getPageSize());
    List<SKToken> SKTokenList = skTokenMapper.selectByExample(skTokenExample);

    PageInfo<SKToken> pageInfo = new PageInfo<>(SKTokenList);
    LOG.info("总行数：{}", pageInfo.getTotal());
    LOG.info("总页数：{}", pageInfo.getPages());

    List<SKTokenQueryResponse> list = BeanUtil.copyToList(SKTokenList, SKTokenQueryResponse.class);

        PageResponse<SKTokenQueryResponse> pageResponse = new PageResponse<>();
            pageResponse.setTotal(pageInfo.getTotal());
            pageResponse.setRows(list);
            return pageResponse;
            }

            public void delete(Long id) {
            skTokenMapper.deleteByPrimaryKey(id);
            }
}
