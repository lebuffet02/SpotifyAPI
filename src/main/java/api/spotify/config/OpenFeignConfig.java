package api.spotify.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return reqTemplate -> reqTemplate.header("Content-Type", "application/x-www-form-urlencoded");
    }
}