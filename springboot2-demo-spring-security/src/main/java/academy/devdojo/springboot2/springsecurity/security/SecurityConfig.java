package academy.devdojo.springboot2.springsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import academy.devdojo.springboot2.springsecurity.service.CustomerUserDetailsService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final CustomerUserDetailsService customerUserDetailsService;
	
	@Autowired
	public SecurityConfig(CustomerUserDetailsService customerUserDetailsService) {
		this.customerUserDetailsService = customerUserDetailsService;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/*/floor1/**").hasRole("USER")
				.antMatchers(HttpMethod.GET, "/*/floor2/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST,"/sign_up").permitAll()
				.anyRequest().authenticated()
			.and()
				.addFilter(new JWTAuthenticationFilter(authenticationManager()))
				.addFilter(new JWTAuthorizationFilter(authenticationManager(), customerUserDetailsService));
		
	}

}
