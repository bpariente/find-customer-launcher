package com.stratio.bawag.findcustomerlauncher.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Find Customer Launcher API")
        .description("This API manage the interaction with FindCustomer Conductor Workflow")
        .version("0.1.0-SNAPSHOT")
        .contact(new Contact("Bawag & Stratio", "", ""))
        .build();
  }

  @Bean
  public Docket customImplementation() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.stratio.bawag.findcustomerlauncher"))
        .build()
        .apiInfo(apiInfo());
  }

  @Bean
  UiConfiguration uiConfig() {
    return new UiConfiguration(
        false,
        false,
        0,
        0,
        ModelRendering.MODEL,
        true,
        DocExpansion.FULL,
        "",
        3,
        OperationsSorter.METHOD,
        false,
        TagsSorter.ALPHA,
        "validationUrl"
    );
  }
}
