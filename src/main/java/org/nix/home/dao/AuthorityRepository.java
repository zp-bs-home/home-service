package org.nix.home.dao;

import org.nix.home.pojo.entity.Authority;
import org.nix.home.pojo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    /**
     * 通过用户名找到用户信息
     *
     * @param name 用户名
     * @return 用户信息
     */
    Authority findByName(String name);

}
