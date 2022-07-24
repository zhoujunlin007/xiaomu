package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository("alphaDaoHibernate")  // 设置Bean的名字，默认是类的名称（首字母小写）
public class AlphaDaoHibernatelmpl implements AlphaDao {

    @Override
    public String select() {
        return "Hibernate";
    }
}
