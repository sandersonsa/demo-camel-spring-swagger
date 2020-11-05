package sa.sanderson.redhat.basa.democamelspringswagger.config;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
public class CamelRouteConfig extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        
        // configure rest-dsl
        restConfiguration()
           // to use undertow component and run on port 8080
            .component("servlet").contextPath("/api")
            // and enable json/xml binding mode
            .bindingMode(RestBindingMode.auto)
            // lets enable pretty printing json responses
            .dataFormatProperty("prettyPrint", "true")
            // lets enable swagger api
            .apiContextPath("api-doc")
            .apiContextRouteId("docs")
            // and setup api properties
            .apiProperty("api.version", "1.0.0")
            .apiProperty("api.title", "Apache Camel - Swagger")
            .apiProperty("api.description", "Teste de Swagger com camel e fuse e spring boot")
            .apiProperty("api.contact.name", "Sanderson Sa");
    }

    @Controller
    public class SwaggerConfig {
        @RequestMapping("/swagger-ui")
        public String redirectToUi() {
            return "redirect:/webjars/swagger-ui/index.html?url=/api/api-doc&validatorUrl=";
        }
    }
}