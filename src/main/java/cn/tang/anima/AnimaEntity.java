package cn.tang.anima;

import cn.tang.common.database.IdObject;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 精灵 - 实体类
 *
 * @author tz
 * @date 2025-09-02
 */
@Getter
@Setter
@Entity
@Table(name = "anima")
public class AnimaEntity extends IdObject {

    /**
     * 精灵名称
     */
    @Comment("精灵名称")
    @Column(name = "anima_name", length = 50)
    private String animaName;

    /**
     * 精灵序号
     */
    @Comment("精灵序号")
    @Column(name = "anima_no")
    private Integer animaNo;

    /**
     * 精灵头像URL
     */
    @Comment("精灵头像URL")
    @Column(name = "anima_avatar_url", length = 100)
    private String animaAvatarUrl;
}
