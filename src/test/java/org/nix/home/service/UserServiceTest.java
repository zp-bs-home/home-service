package org.nix.home.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.home.HomeApplication;
import org.nix.home.dao.UserRepository;
import org.nix.home.pojo.entity.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HomeApplication.class)
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Resource
    private UserRepository userRepository;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Test
    @Transactional
    public void findUserByName() {
        User user = new User();
        String username = "zhangpei";
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode("bisha520"));
        userRepository.save(user);
        User userByName = userService.findUserByName(username);
        assertNotNull(userByName);
    }
}
