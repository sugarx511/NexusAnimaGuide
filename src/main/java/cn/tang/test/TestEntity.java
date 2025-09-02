package cn.tang.test;

import cn.tang.common.database.IdObject;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 测试 - 实体类
 *
 * @author tz
 * @date 2025-09-02
 */
@Getter
@Setter
@Entity
@Table(name = "test")
public class TestEntity extends IdObject {

    /**
     * 测试数据
     */
    @Comment("测试数据")
    @Column(name = "test_data", length = 100)
    private String testData;
}
