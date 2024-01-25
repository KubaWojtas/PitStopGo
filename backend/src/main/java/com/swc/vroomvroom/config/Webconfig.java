package main.java.com.swc.vroomvroom.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Webconfig {

    @Value("${cors.allowedMethods}")
    private String allowedMethods;
    @Value("${cors.allowedHeaders}")
    private String allowedHeaders;
    @Value("${cors.corsConfiguration}")
    private String corsConfiguration;


    @Bean
    public WebMvcConfigurer corsConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
              registry.addMapping(corsConfiguration).allowedMethods(allowedMethods).allowedMethods(allowedHeaders);
            }
        };
    }

}
