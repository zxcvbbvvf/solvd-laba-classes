package com.solvd.student.charles_borabon.solid_principles.design_patterns;

import org.apache.ibatis.session.SqlSessionFactory;

import com.solvd.student.charles_borabon.solid_principles.dao.HotelDAO;
import com.solvd.student.charles_borabon.solid_principles.util.MyBatisUtil;

public class HotelDAOFactory implements AbstractDAOFactory {
    
    @Override
    public HotelDAO create() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        return new HotelDAO(sqlSessionFactory);
    }
}