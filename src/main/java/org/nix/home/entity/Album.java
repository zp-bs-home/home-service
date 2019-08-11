package org.nix.home.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.nix.home.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 相册
 */
@Data
@Entity(name = "album")
@EqualsAndHashCode(callSuper = true)
public class Album extends BaseEntity {
    /**
     * 相册名字
     */
    @Column(name = "name",length = 50)
    private String name;
    /**
     * 封面
     */
    @Column(name = "cover",length = 300)
    private String cover;
    /**
     * 相册里面的照片数量
     */
    @Column(name = "photoNumber")
    private Integer photoNumber;

}
