package org.nix.home.dao.complex;

import cn.hutool.core.collection.CollUtil;
import org.nix.home.dao.AuthorityRepository;
import org.nix.home.dao.UserRepository;
import org.nix.home.pojo.entity.Authority;
import org.nix.home.pojo.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * dao层复合操作需要使用事务管理
 */
@Component
@Transactional
public class UserComplexRepository {

    @Resource
    private AuthorityRepository authorityRepository;

    @Resource
    private UserRepository userRepository;

    /**
     * 用户自己通过前端页面注册
     *
     * @param user 用户注册信息、不能包含有权限信息
     * @return 注册后的用户信息
     */
    public User fromRegisterUser(User user) {
        String generalUser = "generalUser";
        Authority authority = authorityRepository.findByName(generalUser);
        if (authority == null) {
            Date createTime = new Date();
            authority = new Authority(generalUser, "普通用户", createTime, createTime);
        }
        user.setAuthorities(CollUtil.newArrayList(authority));
        userRepository.save(user);
        return user;
    }

    /**
     * 管理员通过后台注册的用户
     *
     * @param user 用户注册信息、可以包含有权限信息，也可以没有
     * @return 注册后的用户信息
     */
    public User adminRegisterUser(User user) {
        userRepository.save(user);
        return user;
    }

}
