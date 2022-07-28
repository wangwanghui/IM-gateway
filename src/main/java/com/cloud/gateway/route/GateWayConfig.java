/*
package com.cloud.gateway.route;


import com.cloud.gateway.zk.ZkClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    @Autowired
    private ZkClient zkClient;

    //走nacos可以注释 这里选择不走nacos 走zookeeper
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        String url = randomSelectServer();
        routes.route("websocket-test",
                r -> r.path("/websocket")
                        .uri("lb://netty-websocket")).build();
        return routes.build();
    }

     // 127.0.0.1:9021
    private String randomSelectServer() {
        String serverUrl = zkClient.discover();
        System.out.println(serverUrl +"--------------");
        return serverUrl;
    }


}
*/
