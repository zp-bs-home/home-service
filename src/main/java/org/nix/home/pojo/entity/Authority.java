package org.nix.home.pojo.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@DynamicInsert
@Table(name = "authority")
@EntityListeners(AuditingEntityListener.class)
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @CreatedDate
    @Column(name = "createTime")
    private Date createTime;

    @LastModifiedDate
    @Column(name = "updateTime")
    private Date updateTime;

    @Override
    public String getAuthority() {
        return getName();
    }
}
