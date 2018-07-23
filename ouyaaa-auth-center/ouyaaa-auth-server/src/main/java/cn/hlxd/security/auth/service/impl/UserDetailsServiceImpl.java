package cn.hlxd.security.auth.service.impl;/**
 * @Author Administrator
 * @Date 2018/7/20 14:17
 */

import cn.hlxd.auth.dto.R;
import cn.hlxd.auth.dto.SysUser;
import cn.hlxd.auth.dto.UserInfo;

import cn.hlxd.security.auth.service.RemoteUserService;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * @Program：ouyaaa-microcloud
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-20  14:17
 * @Description：
 **/

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private RemoteUserService remoteUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        R<UserInfo> result = remoteUserService.getUser(username);
        if (result == null || result.getData() ==null ){
            throw  new UsernameNotFoundException("用户不存在");
        }
        UserInfo user = result.getData();
        Set<String> dbOauthSet = new HashSet<>();

        if (ArrayUtils.isNotEmpty(user.getRoles())){
            // 获取角色
            Arrays.stream(user.getRoles()).forEach(role -> dbOauthSet.add(role));
            //获取资源
            dbOauthSet.addAll(Arrays.asList(user.getPermissions()));
        }

        Collection<? extends GrantedAuthority> authorities
                = AuthorityUtils.createAuthorityList(dbOauthSet.toArray(new String[0]));

        SysUser sysUser = user.getSysUser();


        boolean enabled = StringUtils.equals(sysUser.getDelFlag(),"0");

        /*
        * 构造security用户
        * */
        return new User(username,"{noop}"+sysUser.getPassword(),true,true,true,true,authorities);
    }
}
