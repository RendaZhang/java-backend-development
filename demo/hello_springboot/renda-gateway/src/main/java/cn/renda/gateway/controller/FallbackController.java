package cn.renda.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Renda Zhang
 * @create 2020-05-06 19:22
 */
@RestController
public class FallbackController {

    @RequestMapping("/fallbackA")
    public Mono<String> fallbackA() {
        return Mono.just("服务暂时不可用。");
    }
}
