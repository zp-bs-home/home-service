package org.nix.home.pojo.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@DynamicInsert
@Table(name = "authority")
@EntityListeners(AuditingEntityListener.class)
public class Authority implements GrantedAuthority {

    public Authority() {
    }

    public Authority(String name, String description, Date createTime, Date updateTime) {
        this.name = name;
        this.description = description;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @CreatedDate
    @Column(name = "createTime")
    private Date createTime;

    @LastModifiedDate
    @Column(name = "updateTime")
    private Date updateTime;

//    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "authorities")
//    private List<User> users;

    @Override
    public String getAuthority() {
        return getName();
    }
}
