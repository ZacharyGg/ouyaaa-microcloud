package cn.hlxd.security.auth.controller;/**
 * @Author Administrator
 * @Date 2018/7/23 16:49
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * @Program：ouyaaa-microcloud
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-23  16:49
 * @Description：
 **/

@RestController
public class TestController {

    @GetMapping("/user")
    public String getUser(){
        return "服务器端的用户信息";
    }
}
