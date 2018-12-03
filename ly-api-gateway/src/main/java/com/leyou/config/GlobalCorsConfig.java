package com.leyou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @auther SyntacticSugar
 * @data 2018/12/3 0003下午 7:16
 * 配置 跨域操作  cookie
 */
@Configuration
public class GlobalCorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        //添加配置
        CorsConfiguration conf = new CorsConfiguration();
        /**
         * 设置域 、 设置是否携带cookie  、设置方式
         */
        conf.addAllowedOrigin("http://manage.leyou.com");
        conf.setAllowCredentials(true);
        conf.addAllowedMethod("GET");
        conf.addAllowedMethod("PUT");
        conf.addAllowedMethod("DELETE");
        conf.addAllowedMethod("OPTIONS");
        conf.addAllowedMethod("POST");
        conf.addAllowedMethod("HEAD");
        conf.addAllowedMethod("PATCH");
        //允许的头信息
        conf.addAllowedMethod("*");
    // 添加映射路径
        UrlBasedCorsConfigurationSource urlSource = new UrlBasedCorsConfigurationSource();
        urlSource.registerCorsConfiguration("/**",conf);
        return new CorsFilter(urlSource);
    }
}
