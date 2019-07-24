package org.nix.home.service;

import org.nix.home.dao.UserRepository;
import org.nix.home.pojo.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findUserByName(username);
    }

    public User findUserByName(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * 用户注册信息
     *
     * @param register 用户注册
     * @return 注册完成的用户信息
     */
    public User register(Register register) {
        User user = register.register();
        userRepository.saveAndFlush(user);
        return user;
    }


}
