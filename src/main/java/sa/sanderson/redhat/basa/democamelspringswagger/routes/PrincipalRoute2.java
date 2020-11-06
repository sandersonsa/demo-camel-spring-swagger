package sa.sanderson.redhat.basa.democamelspringswagger.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.stereotype.Component;

@Component
public class PrincipalRoute2 extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        rest("/say2").description("Say hello 2")
            .get("/hello2").to("direct:hello")
            .get("/bye2").consumes("application/json").to("direct:bye");

        from("direct:hello2")
            .transform().constant("Hello World");
        from("direct:bye2")
            .transform().constant("Bye World");
    }

    // @Override
    // public void configure() throws Exception {
    //     restConfiguration()
    //     .component("servlet")
    //     .bindingMode(RestBindingMode.json);

    //     rest().get("/hello")
    //     .to("direct:hello");
    
    //     from("direct:hello")
    //     .log(LoggingLevel.INFO, "Hello World")
    //     .transform().simple("Hello World");
    // }

    // https://github.com/Java-Techie-jt/spring-camel-rest-dsl //

    // @Override
	// public void configure() throws Exception {
	// 	restConfiguration().component("servlet").port(9090).host("localhost").bindingMode(RestBindingMode.json);

	// 	rest().get("/hello-world").produces(MediaType.APPLICATION_JSON_VALUE).route()
	// 			.setBody(constant("Welcome to java techie")).endRest();

	// 	rest().get("/getOrders").produces(MediaType.APPLICATION_JSON_VALUE).route().setBody(() -> service.getOrders())
	// 			.endRest();

	// 	rest().post("/addOrder").consumes(MediaType.APPLICATION_JSON_VALUE).type(Order.class).outType(Order.class)
	// 			.route().process(processor).endRest();
	// }
    
}
