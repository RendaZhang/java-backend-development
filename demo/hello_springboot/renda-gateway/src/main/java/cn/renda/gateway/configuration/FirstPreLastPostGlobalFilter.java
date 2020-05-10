package cn.renda.gateway.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author Renda Zhang
 * @create 2020-05-06 19:07
 */
@Component
public class FirstPreLastPostGlobalFilter
        implements GlobalFilter, Ordered { // around-log 环绕日志

    final Logger logger =
            LoggerFactory.getLogger(FirstPreLastPostGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {
        // 一个过滤器先后执行logger
        logger.info("First Pre Global Filter"); // 执行pre logger
        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {
                    logger.info("Last Post Global Filter"); // 执行post logger
                }));
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
