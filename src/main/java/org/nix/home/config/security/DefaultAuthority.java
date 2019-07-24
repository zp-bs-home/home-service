package org.nix.home.config.security;

import lombok.Data;
import org.nix.home.dao.AuthorityRepository;
import org.nix.home.pojo.entity.Authority;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 系统默认角色信息
 */
@Configuration
public class DefaultAuthority {

    @Resource
    private AuthorityRepository authorityRepository;

    @Bean
    public Authority generalUser() {
        String generalUser = "generalUser";
        Authority general = new Authority(generalUser, "表单注册用户", new Date(), new Date());
        Authority dbGeneralAuthority = authorityRepository.findByName(generalUser);
        if (dbGeneralAuthority == null){
            authorityRepository.saveAndFlush(general);
        }
        return general;
    }


}
