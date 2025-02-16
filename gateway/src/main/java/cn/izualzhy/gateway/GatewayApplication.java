package cn.izualzhy.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }


    /**
     * 创建路由规则
     * @param builder -- 路由构造器
     * @return 路由规则
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes() //开启路由配置
                // 匹配路径
                .route(f -> f.path("/user/lilei") // route方法逻辑是一个断言，后续会论述
                        // 转发到具体的URI
                        .uri("http://localhost:6001"))
                // 创建
                .build();
    }

}
