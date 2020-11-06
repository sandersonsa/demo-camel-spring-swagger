package sa.sanderson.redhat.basa.democamelspringswagger.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

@Component
public class PrincipalRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        rest("/say").description("Boa noite")
            .get("/hello").to("direct:hello")
            .get("/bye").consumes("application/json").to("direct:bye");

        from("direct:hello")
            .transform().constant("Hello World");
        from("direct:bye")
            .transform().constant("Bye World");
    }
    
}
