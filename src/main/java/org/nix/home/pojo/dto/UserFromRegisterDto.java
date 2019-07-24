package org.nix.home.pojo.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * 用户表单注册据传输对象
 */
@Data
public class UserFromRegisterDto{
    private String name;
    @NotEmpty(message = "用户账号不能为空")
    private String username;
    private String email;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).*$", message = "密码必须包含有大小字母和数字")
    @Length(min = 8, max = 20, message = "密码长度为：8-20")
    private String password;
    private String avatar;
}
