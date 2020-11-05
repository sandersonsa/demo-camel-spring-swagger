package sa.sanderson.redhat.basa.democamelspringswagger.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

@Component
public class PrincipalRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        
        rest("/rest")
            .tag("Demo API 1")
            .consumes("application/text").produces("application/text")
            
            .get("ping")
                .route()
                    .routeId("ping")
                    .transform(constant("PONG\n"))
                .endRest();
        ;
    }
    
}
