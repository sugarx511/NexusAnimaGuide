package cn.tang.anima;

import cn.tang.common.exception.annotation.Res;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 精灵 - 移动端访问接口
 *
 * @author tz
 * @date 2025-09-02
 */
@RestController
@RequestMapping(value = "/api/app/anima")
public class AnimaFrontApi {

    private final AnimaFrontService animaFrontService;

    public AnimaFrontApi(AnimaFrontService animaFrontService) {
        this.animaFrontService = animaFrontService;
    }

    /**
     * 查询精灵列表
     *
     * @return {@link Object }
     */
    @Res
    @RequestMapping(value = "/queryAnimaList")
    public Object queryAnimaList() {
        return animaFrontService.queryAnimaList();
    }
}
