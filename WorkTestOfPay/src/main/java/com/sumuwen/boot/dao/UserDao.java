package com.sumuwen.boot.dao;

import com.sumuwen.boot.pojo.Detail;
import com.sumuwen.boot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {
    public Double getBalance(@Param("uid") Integer uid);

    public Integer updateBalance(@Param("user") User user);

    public Integer registration(@Param("detail") Detail detail);
}
