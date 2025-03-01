package cn.edu.szu.train.business.mapper.custom;

import java.util.Date;

public interface CustomizedSkTokenMapper {

    int decrease(Date date, String trainCode, int decreaseCount);
}
