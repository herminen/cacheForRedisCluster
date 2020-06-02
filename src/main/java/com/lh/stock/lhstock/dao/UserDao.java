package com.lh.stock.lhstock.dao;

import com.lh.stock.lhstock.po.UserPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: liuhai
 * @Date: 2020/6/2 10:36
 */
public interface UserDao {
    List<UserPO> listUserInfo(@Param("begin") int begin, @Param("end") int end);
}
