package org.nix.home.dao.complex;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.home.HomeApplication;
import org.nix.home.pojo.entity.User;
import org.nix.home.service.UserService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HomeApplication.class)
public class UserComplexRepositoryTest {

    @Resource
    private UserComplexRepository userComplexRepository;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private UserService userService;

    @Test
    @Transactional
    public void fromRegisterUser() {

        User user = new User();
        String username = "zhangpei";
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode("bisha520"));
        userComplexRepository.fromRegisterUser(user);
        User userByName = userService.findUserByName(username);
        assertNotNull(userByName);

    }
}
