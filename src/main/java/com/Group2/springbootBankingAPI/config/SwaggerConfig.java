package com.Group2.springbootBankingAPI.config;



import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;



@OpenAPIDefinition(
        info =@Info(
                contact = @Contact(
                        name="com.Group2",
                        email="com.Group2@gmail.com",
                        url="https://com.Group2.com/Apis"
                ),
                description = "EBanking Application Project Backend",
                title = "EBanking Application",
                version = "1.0",
                license = @License(
                        name = "License name",
                        url = "https://some-url.com"
                ),
                termsOfService = "Terms Of Service"
        ),
        servers = {
                @Server(
                        description = "Local-Env",
                        url = "http://localhost:5050"
                )
        }
)
public class SwaggerConfig
{


}


