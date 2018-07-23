package cn.hlxd.security.auth;/**
 * @Author Administrator
 * @Date 2018/7/20 13:13
 */

import cn.hlxd.security.auth.properties.SecurityProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
//import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created with IntelliJ IDEA.
 * @Program：ouyaaa-microcloud
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-20  13:13
 * @Description：
 **/



@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableConfigurationProperties(SecurityProperties.class)
@EnableFeignClients
public class AuthenticationServer_Application {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(AuthenticationServer_Application.class,args);
    }
}
