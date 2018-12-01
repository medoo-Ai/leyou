package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @auther SyntacticSugar
 * @data 2018/12/1 0001下午 12:13
 */

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient  //@EnableDiscoveryClient基于spring-cloud-commons, @EnableEurekaClient基于spring-cloud-netflix。
public class LyApiGateway {
    public static void main(String[] args) {

    SpringApplication.run(LyApiGateway.class,args);
    }
}
