package postgisdemo.postgisdemo.commons;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Setter
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    private static final String VERSION = "1.1";
    private static final String TITLE = "Person API";
    private static final String DESCRIPTION = "Person super rest API. Advanced tool for managing an extensive database in postgres.";
    private static final String CONTACT_NAME = "Dawid";
    private static final String CONTACT_URL = "https://cos.com";
    private static final String CONTACT_ADDRESS = "dks@cos.com";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .version(VERSION)
                .contact(new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_ADDRESS))
                .build();
    }
}
