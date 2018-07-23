package cn.hlxd.security.auth.fallback;/**
 * @Author Administrator
 * @Date 2018/7/23 0:23
 */

import cn.hlxd.auth.dto.R;
import cn.hlxd.auth.dto.UserInfo;
import cn.hlxd.security.auth.service.RemoteUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * @Program：ouyaaa-microcloud
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-23  00:23
 * @Description：
 **/

@Slf4j
@Component
public class RemoteUserServiceFallbackImpl implements RemoteUserService{

    @Override
    public R<UserInfo> getUser(String username) {
        log.error("feign 查询用户信息失败:{}", username);
        return null;
    }
}
