package cn.renda.gateway.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @author Renda Zhang
 * @create 2020-05-06 18:55
 */
@Configuration
public class LoggingGlobalFiltersConfigurations { // post-log 后置日志

    final Logger logger =
            LoggerFactory.getLogger(
                    LoggingGlobalFiltersConfigurations.class);


    @Bean
    public GlobalFilter postGlobalFilter() {
        return (exchange, chain) -> {
            return chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                        logger.info("Global Post Filter executed"); // 后执行logger
                    }));
        };
    }
}
