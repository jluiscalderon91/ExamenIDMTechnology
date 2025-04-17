package com.bci.apicliente.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title= "Api de gestion de requerimientos",
                version= "1.0.0",
                description= "Apis creadas para realizar la gestion de requerimientos"
        )
)
public class OpenApiConfig {

}
