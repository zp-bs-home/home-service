package org.nix.home.web.pojo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String avatar;
    private Date createTime;
    private Date updateTime;
}
