package cn.tang.anima;

import cn.tang.anima.vo.AnimaVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 精灵 - 移动端访问业务
 *
 * @author tz
 * @date 2025-09-02
 */
@Service
public class AnimaFrontService {

    private final AnimaRepository animaRepository;

    public AnimaFrontService(AnimaRepository animaRepository) {
        this.animaRepository = animaRepository;
    }

    /**
     * 查询精灵列表
     *
     * @return {@link List }<{@link AnimaEntity }>
     */
    public List<AnimaVo> queryAnimaList() {
        return animaRepository.findAll().stream().map(AnimaVo::new).collect(Collectors.toList());
    }
}
