package academy.devdojo.springboot2.springsecurity.security;

import static academy.devdojo.springboot2.springsecurity.security.SecurityConstants.HEADER_STRING;
import static academy.devdojo.springboot2.springsecurity.security.SecurityConstants.SECRET;
import static academy.devdojo.springboot2.springsecurity.security.SecurityConstants.TOKEN_PREFIX;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import academy.devdojo.springboot2.springsecurity.service.CustomerUserDetailsService;
import io.jsonwebtoken.Jwts;

/**
*
* brunolima on Jan 29, 2021
* 
*/

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
	
	private final CustomerUserDetailsService customerUserDetailsService;

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager,
			CustomerUserDetailsService customerUserDetailsService) {
		super(authenticationManager);
		this.customerUserDetailsService = customerUserDetailsService;
	}
	
	@Override
	protected void doFilterInternal(
			HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain chain) throws IOException, ServletException {
	
		String header = request.getHeader(HEADER_STRING);
		
		if (header == null || !header.startsWith(TOKEN_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}
		
		UsernamePasswordAuthenticationToken usernamePasswordAuth = getAuthenticationToken(request);
		
		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuth);
		
		chain.doFilter(request, response);
	}
	
	private UsernamePasswordAuthenticationToken getAuthenticationToken(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);
		
		if (token == null) return null;
		
		String username = Jwts
							.parser()
							.setSigningKey(SECRET)
							.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
							.getBody()
							.getSubject();
		
		UserDetails userDetails = customerUserDetailsService.loadUserByUsername(username);
//		ApplicationUser applicationUser = customerUserDetailsService.loadApplicationUserByUsername(username);
		
		return username != null ? new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities()) : null;
							
	}
}

