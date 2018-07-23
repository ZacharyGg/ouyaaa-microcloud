package cn.hlxd;/**
 * @Author Administrator
 * @Date 2018/7/20 9:40
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created with IntelliJ IDEA.
 * @Program：ouyaaa-microcloud
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-20  09:40
 * @Description：
 **/

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer_Application {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(EurekaServer_Application.class,args);
    }
}
