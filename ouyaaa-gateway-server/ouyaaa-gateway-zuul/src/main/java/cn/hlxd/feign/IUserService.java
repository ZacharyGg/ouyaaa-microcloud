package cn.hlxd.feign;

import cn.hlxd.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2018/7/20 11:23
 */


/*
* 可以调用的服务，这个value是需要调用RPC的服务地址，若注册微服务这可以用value,若没有直接用url参数
* */
@FeignClient(value = "zuul-getway" , fallback = UserServiceFallback.class)
public interface IUserService {

    @GetMapping("/api/user/{username}/permissions")
    public List<String> getPermissionByUsername(@PathVariable String username);


    @GetMapping("/api/permissions")
    List<String> getAllPermissionInfo();
}
