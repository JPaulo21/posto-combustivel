package com.jp.posto_combustivel.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Posto Combustível API",
                description = "API para gerenciamento de abastecimentos em postos de combustível",
                version = "1.0.0",
                contact = @Contact(name = "João Paulo", email = "jp.sport17@gmail.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                ),
                termsOfService = "https://example.com/terms"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080/posto-combustivel",
                        description = "Servidor de Desenvolvimento"
                ),
        }
)
public class DocsApiConfig {
}
