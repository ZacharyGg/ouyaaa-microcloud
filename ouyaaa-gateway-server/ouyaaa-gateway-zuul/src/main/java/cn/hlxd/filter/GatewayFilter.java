package cn.hlxd.filter;/**
 * @Author Administrator
 * @Date 2018/7/20 10:53
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Created with IntelliJ IDEA.
 * @Program：ouyaaa-microcloud
 * @Author：Zachary
 * @Version：1.0
 * @Date： 2018-07-20  10:53
 * @Description：
 **/
//@Configuration
@Slf4j
public class GatewayFilter implements GlobalFilter{




    private static final String GATE_WAY_PREFIX = "/api";
    private String startWith;


    /**
     * 对访问gateway进行拦截
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("check token and user permission....");
        LinkedHashSet requiredAttribute = exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
        ServerHttpRequest request = exchange.getRequest();

        /*
        * 获取访问地址是否匹配
        * */
        String requestUri = request.getPath().pathWithinApplication().value();
        if (requiredAttribute!=null){
            Iterator<URI> iterator = requiredAttribute.iterator();
            while (iterator.hasNext()){
                URI next = iterator.next();
                if (next.getPath().startsWith(GATE_WAY_PREFIX)){
                    requestUri = next.getPath().substring(GATE_WAY_PREFIX.length());
                }
            }
        }

        String method = request.getMethod().toString();


        ServerHttpRequest.Builder mutate = request.mutate();

        /*
        * 以定义好的开头的地址就不进行拦截，按照原方法继续
        * */
        if (isStartWith(requestUri)){
            ServerHttpRequest build = mutate.build();
            return chain.filter(exchange.mutate().request(build).build());
        }

        throw  new RuntimeException("地址错误");
        
    }


    /**
     * 判断字符串以什么开头,startWith是变量，是以为,分割的字符串
     * @param requestUri
     * @return
     */
    private boolean isStartWith(String requestUri) {
        boolean flag = false;
        for(String s: startWith.split(",")){
            if (requestUri.startsWith(s)){
                return  true;
            }
        }
        return flag;
    }
}
