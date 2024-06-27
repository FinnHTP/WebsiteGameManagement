package com.project.backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name="Phat",
                        email="phat@gmail.com",
                        url="https://www.facebook.com/profile.php?id=100025937886950"
                ),
                description = "Open API document for Spring Security",
                title = "OpenApi sepecfication - Phat",
                version = "1.0",
                license = @License(
                        name = "license name",
                        url = "https:/some-url.com"
                ),
                termsOfService = "terms of sevice "
        ),
        servers = {
                @Server(
                        description = "BeeGaming",
                        url = "http://localhost:8080"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }

)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenAPIConfig {
}
