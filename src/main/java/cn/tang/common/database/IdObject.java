package cn.tang.common.database;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 基础主键
 *
 * @author tz
 * @date 2023-05-06
 */
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class IdObject implements Serializable {

    private static final long serialVersionUID = 42L;

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("主键")
    @Column(name = "id")
    private Long id;

    /**
     * 创建时间 - 时间戳
     */
    @Comment("创建时间-时间戳")
    @Column(name = "create_timestamp")
    private Long createTimestamp;

    /**
     * 修改时间 - 时间戳
     */
    @Comment("修改时间-时间戳")
    @Column(name = "update_timestamp")
    private Long updateTimestamp;
}
