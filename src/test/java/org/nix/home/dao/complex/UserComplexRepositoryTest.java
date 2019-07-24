package org.nix.home.dao.complex;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nix.home.HomeApplication;
import org.nix.home.pojo.dto.UserFromRegisterDto;
import org.nix.home.pojo.entity.User;
import org.nix.home.service.Register;
import org.nix.home.service.UserService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HomeApplication.class)
public class UserComplexRepositoryTest {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private UserService userService;

    @Test
//    @Transactional
    public void fromRegisterUser() {
        Register user = initUser("zhangpei", "bisha");

        User register = userService.register(user);

        user = initUser("bisha", "zhangpei");

        User register1 = userService.register(user);

    }

    private Register initUser(String username, String password){
        UserFromRegisterDto userFromRegisterDto = new UserFromRegisterDto();
        userFromRegisterDto.setUsername(username);
        userFromRegisterDto.setPassword(password);
        return userFromRegisterDto;
    }
}
