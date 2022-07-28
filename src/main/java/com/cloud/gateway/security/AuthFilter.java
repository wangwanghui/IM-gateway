package com.cloud.gateway.security;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URLEncoder;

@Slf4j
@Component
public class AuthFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("user come to gateway -------->");
        ServerHttpRequest request = exchange.getRequest();
        return chain.filter(exchange.mutate().request(request).build());
    }

    @Override
    public int getOrder() {
        return 0;
    }

    private ServerHttpRequest addPara(ServerWebExchange exchange, String paraName, String paraValue) {
        URI uri = exchange.getRequest().getURI();
        try {
            StringBuilder query = new StringBuilder();
            String originalQuery = uri.getRawQuery();
            query.append(paraName);
            query.append('=');
            query.append(URLEncoder.encode(paraValue, "UTF-8"));
            if (!StringUtils.isEmpty(originalQuery)) {
                query.append('&');
                query.append(originalQuery);
            }
            URI newUri = UriComponentsBuilder.fromUri(uri).replaceQuery(query.toString()).build(true).toUri();
            return exchange.getRequest().mutate().uri(new URI("ws://127.0.0.1:7980")).build();
        } catch (Exception e) {
            // do nothing
        }
        return exchange.getRequest();
    }
}
