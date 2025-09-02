package cn.tang.test.api;

import cn.tang.common.exception.annotation.Res;
import cn.tang.test.TestRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 - 接口
 *
 * @author tz
 * @date 2025-09-02
 */
@RestController
@RequestMapping(value = "/api/test")
public class TestApi {

    private final TestRepository testRepository;

    public TestApi(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    /**
     * 测试
     *
     * @return {@link Object }
     */
    @Res
    @RequestMapping(value = "/test")
    public Object test() {
        return testRepository.findById(1L).orElse(null);
    }
}
