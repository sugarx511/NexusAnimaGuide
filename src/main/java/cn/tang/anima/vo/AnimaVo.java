package cn.tang.anima.vo;

import cn.tang.anima.AnimaEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 精灵
 *
 * @author tz
 * @date 2025-09-02
 */
@Getter
@Setter
@NoArgsConstructor
public class AnimaVo {

    /**
     * 主键
     */
    private Long id;

    /**
     * 精灵名称
     */
    private String animaName;

    /**
     * 精灵序号
     */
    private Integer animaNo;

    /**
     * 精灵头像URL
     */
    private String animaAvatarUrl;

    public AnimaVo(AnimaEntity animaEntity) {
        this.id = animaEntity.getId();
        this.animaName = animaEntity.getAnimaName();
        this.animaNo = animaEntity.getAnimaNo();
        this.animaAvatarUrl = animaEntity.getAnimaAvatarUrl();
    }
}
