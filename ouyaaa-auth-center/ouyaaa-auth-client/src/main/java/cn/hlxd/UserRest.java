package cn.hlxd;/**
 * @Author Administrator
 * @Date 2018/7/23 10:14
 */


import cn.hlxd.auth.dto.R;
import cn.hlxd.auth.dto.SysUser;
import cn.hlxd.auth.dto.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static javafx.scene.input.KeyCode.R;

/**
 * Created with IntelliJ IDEA.
 * @Program：ouyaaa-microcloud
 * @Author：Zachary
 * @Version：UserRest
 * @Date： 2018-07-23  10:14
 * @Description：
 **/
@Slf4j
@RestController
public class UserRest {

    @GetMapping("/userinfo")
    public String getInfo(){
        return "11111";
    }


    @GetMapping("/user/{username}")
    public R<UserInfo> getUser(@PathVariable("username") String username){

//        if(StringUtils.isBlank(username)){
//
//        }
        log.info("获取用户信息");
        return new R<>(findUserInfo(username));
    }

    private UserInfo findUserInfo(String username) {
        UserInfo userInfo = new UserInfo();
        userInfo.setRoles(new String[]{"ROLE_USER","ROLE_ADMIN"});
        userInfo.setPermissions(new String[]{"ROLE_ADD","ROLE_UPDATE"});
        SysUser sysUser = new SysUser();
        sysUser.setUserId(1);
        sysUser.setUsername("admin");
        sysUser.setPassword("123456");
        userInfo.setSysUser(sysUser);
        return userInfo;
    }
}
