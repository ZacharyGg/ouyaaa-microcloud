package cn.hlxd.security.auth.service;/**
 * @Author Administrator
 * @Date 2018/7/20 14:17
 */


import cn.hlxd.auth.dto.R;
import cn.hlxd.auth.dto.UserInfo;
import cn.hlxd.security.auth.fallback.RemoteUserServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * @Program：ouyaaa-microcloud
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-20  14:17
 * @Description：
 * @FeignClient(name = "auth",url = "http://127.0.0.1:9002")
 **/


@FeignClient(name = "AUTH-CLIENT",fallback = RemoteUserServiceFallbackImpl.class)
public interface RemoteUserService {
    @RequestMapping(value = "/user/{username}",method = RequestMethod.GET)
    R<UserInfo> getUser(@PathVariable("username") String username);
}
