package org.nix.home.web.controller;

import org.nix.home.pojo.dto.ResponseDto;
import org.nix.home.pojo.dto.UserFromRegisterDto;
import org.nix.home.service.UserService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;

    /**
     * from表单注册接口
     *
     * @param user 注册信息
     * @return 处理结果
     */
    @PostMapping(value = "/from/register")
    public ResponseDto registerFromUser(@ModelAttribute UserFromRegisterDto user) {
        userService.register(user);
        return ResponseDto.success();
    }

}
