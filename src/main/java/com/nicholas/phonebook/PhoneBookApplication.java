package com.nicholas.phonebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
@SpringBootApplication
@ComponentScan("com.nicholas")
public class PhoneBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneBookApplication.class, args);
    }

    // swagger configuration.
    @Bean
    public Docket configureSwagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().title("Phone book service")
                        .description("Demo phone book service").version("1.0")
                        .build()).select().paths(regex("/v.*")).build();

    }
}
