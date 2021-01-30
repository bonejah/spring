package academy.devdojo.springboot2.springsecurity.security;

/**
*
* brunolima on Jan 29, 2021
* 
*/

public class SecurityConstants {
	
	public static final String SECRET = "secret";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final long EXPIRATION_TIME = 864_000_000l;  // One day 
	
}	

