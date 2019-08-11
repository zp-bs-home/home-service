package org.nix.home.entity.base;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 基类
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    @CreatedDate
    @Column(name = "createTime")
    protected Date createTime;

    @LastModifiedDate
    @Column(name = "updateTime")
    protected Date updateTime;

}
