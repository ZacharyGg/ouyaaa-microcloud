package cn.hlxd;/**
 * @Author Administrator
 * @Date 2018/7/20 10:16
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created with IntelliJ IDEA.
 * @Program：ouyaaa-microcloud
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-20  10:16
 * @Description：
 **/

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ZuulGateway_Application {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(ZuulGateway_Application.class,args);
    }
}
