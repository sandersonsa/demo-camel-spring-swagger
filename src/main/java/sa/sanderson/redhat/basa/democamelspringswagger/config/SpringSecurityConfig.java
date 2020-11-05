package sa.sanderson.redhat.basa.democamelspringswagger.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.JwtDecoders;
//import org.springframework.security.oauth2.jwt.JwtDecoders;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(final HttpSecurity http) throws Exception {

		/* @formatter:off */
		
		// http.oauth2ResourceServer().jwt().decoder(JwtDecoders.fromOidcIssuerLocation(jwtIssuer));
		
		http
			.authorizeRequests()
			.antMatchers("/monitoring/health").permitAll()
			.antMatchers("/swagger-ui/**").permitAll()
			.antMatchers("/webjars/swagger-ui**").permitAll()
			.antMatchers("/api/api-doc/**").permitAll()
			.antMatchers("/api/**")
			// .antMatchers(String.format("/%s/%s/**", apiContextRoot, apiDocContextRoot)).permitAll()
			// .antMatchers(String.format("/%s/**", apiContextRoot))			
			.authenticated();

		/* @formatter:on */
	}
}
