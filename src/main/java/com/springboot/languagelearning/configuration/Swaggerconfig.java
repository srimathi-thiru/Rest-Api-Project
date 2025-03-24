package com.springboot.languagelearning.configuration;

    import io.swagger.v3.oas.models.OpenAPI;
    import io.swagger.v3.oas.models.info.Info;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    
    @Configuration
    public class Swaggerconfig {
        @Bean
        public OpenAPI customOpenAPI() {
            return new OpenAPI()
                    .info(new Info()
                            .title("LearningApp API")
                            .version("1.0")
                            .description("API documentation for Farmer Management System"));
                        }
    }





