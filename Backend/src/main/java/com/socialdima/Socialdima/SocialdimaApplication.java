package com.socialdima.Socialdima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

@EnableJpaRepositories(basePackages = "com.socialdima.Socialdima.repository")
@SpringBootApplication
public class SocialdimaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SocialdimaApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("*").allowedOrigins("http://localhost:4200");
				registry.addMapping("/image").allowedOrigins("http://localhost:4200");
            }
        };
    }

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("39MB");
        factory.setMaxRequestSize("39MB");
        return factory.createMultipartConfig();
    }
}
