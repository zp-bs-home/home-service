package org.nix.home.entity.base;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 基类
 */
@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    @Column(name = "createTime")
    protected Date createTime;

    @Column(name = "updateTime")
    protected Date updateTime;

}
