package cn.hlxd.fallback;/**
 * @Author Administrator
 * @Date 2018/7/20 11:26
 */

import cn.hlxd.feign.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @Program：ouyaaa-microcloud
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-20  11:26
 * @Description：
 **/

@Service
@Slf4j
public class UserServiceFallback implements IUserService{

    @Override
    public List<String> getPermissionByUsername(String username) {
        log.error("GateWay服务调用 getPermissionByUsername----%s 异常" ,username);
        return null;
    }

    @Override
    public List<String> getAllPermissionInfo() {
        log.error("GateWay服务调用 getAllPermissionInfo 异常");
        return null;
    }
}
