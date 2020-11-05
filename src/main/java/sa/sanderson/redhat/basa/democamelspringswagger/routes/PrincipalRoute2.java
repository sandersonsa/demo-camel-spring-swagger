package sa.sanderson.redhat.basa.democamelspringswagger.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

@Component
public class PrincipalRoute2 extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        
        rest("/rest2")
            .tag("Demo API 2")
            .consumes("application/text").produces("application/text")
            
            .get("ping")
                .route()
                    .routeId("ping")
                    .transform(constant("PONG\n"))
                .endRest();
        ;
    }
    
}
