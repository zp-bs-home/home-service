package org.nix.home.dao;

import org.nix.home.pojo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * 通过用户名找到用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    User findByUsername(String username);

    /**
     * 通过用户的用户名或者邮箱查询用户信息
     *
     * @param username 用户名
     * @param email    用户邮箱
     * @return 查询结果
     */
    User findByUsernameOrEmail(String username, String email);

}
