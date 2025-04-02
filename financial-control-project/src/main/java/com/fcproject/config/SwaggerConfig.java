package com.fcproject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    OpenAPI ConfigOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Financial control project API")
                        .version("v1.0")
                        .description("Financial control project API"));
    }
}
