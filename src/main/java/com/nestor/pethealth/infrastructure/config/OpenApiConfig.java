package com.nestor.pethealth.infrastructure.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI petHealthAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("PetHealth API")
                        .version("1.0.0")
                        .description("API REST para gestión de personas, mascotas, veterinarios y consultas médicas"));
    }
}
