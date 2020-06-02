package com.lh.stock.lhstock.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: liuhai
 * @Date: 2020/6/2 11:07
 */
@Getter
@Setter
@ToString
public class UserPO {

    /**
     * 用户id--主键
     */
    private Long userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 年龄
     */
    private Integer userAge;

    /**
     * 描述
     */
    private String userDesc;
}
