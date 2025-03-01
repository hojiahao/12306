package cn.edu.szu.train.business.mapper;

import cn.edu.szu.train.business.domain.SKToken;
import cn.edu.szu.train.business.domain.SKTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SKTokenMapper {
    long countByExample(SKTokenExample example);

    int deleteByExample(SKTokenExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SKToken record);

    int insertSelective(SKToken record);

    List<SKToken> selectByExample(SKTokenExample example);

    SKToken selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SKToken record, @Param("example") SKTokenExample example);

    int updateByExample(@Param("record") SKToken record, @Param("example") SKTokenExample example);

    int updateByPrimaryKeySelective(SKToken record);

    int updateByPrimaryKey(SKToken record);
}