package ru.shtyrev.searchservice.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Elasticsearch API documentation",
                description = "Documentation for all endpoints",
                termsOfService = "Terms of service",
                contact = @Contact(
                        name = "Oleg",
                        url = "https://vk.com/o1egs",
                        email = "tankistonline21@gamil.com"
                ),
                license = @License(
                        name = "ООО 'Очень Оригинально Олег'",
                        url = ""
                ),
                version = "0.0.1"
        ),
        servers = {
                @Server(
                        description = "Search",
                        url = "http://localhost:8080"
                ),
        }

)
public class SwaggerConfig {
//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPIV3Parser().read("searchserviceswagger.yaml");
//    }
}
