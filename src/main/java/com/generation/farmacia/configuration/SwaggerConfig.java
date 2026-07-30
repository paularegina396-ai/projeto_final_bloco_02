package com.generation.farmacia.configuration;


import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {
	 
	@Bean
    OpenAPI springBlogPessoalOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Projeto Farmacia - Performance Goal 2")
                .description("Projeto Farmacia - Paula Leão")
                .version("v0.0.1")
                .license(new License()
                    .name("Paula Regina Leão Michel")
                    .url("https://github.com/paularegina396-ai/projeto_final_bloco_02/"))
                .contact(new Contact()
                    .name("Paula Leão")
                    .url("https://github.com/paularegina396-ai")
                    .email("paularegina396@gmail.com")))
            .externalDocs(new ExternalDocumentation()
                .description("Github")
                .url("https://github.com/paularegina396-ai"))
            /*.components(new Components()
                    .addSecuritySchemes("jwt_auth", createSecurityScheme()))
                .addSecurityItem(new SecurityRequirement().addList("jwt_auth"))*/;
    }

	@Bean
	OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {

	    return openApi -> {
	        if (openApi.getPaths() != null) {
	            openApi.getPaths().values().forEach(pathItem -> {
	                if (pathItem.readOperations() != null) {
	                    pathItem.readOperations().forEach(operation -> {

	                        ApiResponses apiResponses = operation.getResponses();

	                        apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
	                        apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
	                        apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
	                        apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
	                        apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
	                        apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));

	                    });
	                }
	            });
	        }
	    };
	}//Alterado pois por enquanto não teremos spring security nesse projeto

	private ApiResponse createApiResponse(String message) {

		return new ApiResponse().description(message);

	}
	
	/*private SecurityScheme createSecurityScheme() {
	    return new SecurityScheme()
	        .name("jwt_auth")
	        .type(SecurityScheme.Type.HTTP)
	        .scheme("bearer")
	        .bearerFormat("JWT")
	        .description("Insira apenas o token JWT (a palavra 'Bearer' será adicionada automaticamente)");
	}*/
}