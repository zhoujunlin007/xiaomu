package com.nowcoder.community.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary   // 调用Bean时有更高的优先级
public class AlphaDaoMybatislmpl implements AlphaDao{
    @Override
    public String select() {
        return "Mybatis";
    }
}
