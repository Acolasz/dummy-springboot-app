package hu.kukutyin.dummy.service.app.config;

import java.util.ArrayList;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Fixed org.springframework.context.ApplicationContextException: Failed to start bean 'documentationPluginsBootstrapper'; nested exception is java.lang.NullPointerException
 *
 * @see "https://github.com/springfox/springfox/issues/3462#issuecomment-978707909"
 * @see "https://github.com/springfox/springfox/issues/3462#issuecomment-1076552144"
 */
@Configuration
public class SwaggerConfig {
    private static final String BASE_PACKAGE_CONTROLLER = "hu.kukutyin.dummy.service";

    private final BuildProperties buildProperties;

    public SwaggerConfig(
            BuildProperties buildProperties
    ) {
        this.buildProperties = buildProperties;
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE_CONTROLLER))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                buildProperties.getArtifact(),
                String.format("%s %s", buildProperties.getArtifact(), "some custom description of API."),
                buildProperties.getVersion(),
                "Terms of service",
                ApiInfo.DEFAULT_CONTACT,
                "app.swaggerhub.com",
                "https://app.swaggerhub.com/apis/Coinfirm-swagger/API/3.0.5#/",
                new ArrayList()
        );
    }
}
