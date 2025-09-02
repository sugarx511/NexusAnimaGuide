package cn.tang.test;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 测试 - 数据访问层
 *
 * @author tz
 * @date 2025-09-02
 */
public interface TestRepository extends JpaRepository<TestEntity, Long> {

}
