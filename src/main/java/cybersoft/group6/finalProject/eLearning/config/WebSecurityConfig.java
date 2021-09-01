package cybersoft.group6.finalProject.eLearning.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.ArrayList;
import java.util.List;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

	protected List<String> setUpAllowOrigins() {
		
		List<String> allowOrigins = new ArrayList<String>();
		
		allowOrigins.add("*");
		
		return allowOrigins;
	}
	 
	protected List<String> setUpAllowMethods() {
		
		List<String> allowMethods = new ArrayList<String>();
		
		allowMethods.add("GET");
		allowMethods.add("POST");
		allowMethods.add("PUT");
		allowMethods.add("DELETE");
		allowMethods.add("PUT");
		allowMethods.add("OPTIONS");
		allowMethods.add("PATCH");
		allowMethods.add("DELETE");
		
		return allowMethods;
	}
	
	protected List<String> setUpAllowHeaders() {
		
		List<String> allowHeader = new ArrayList<String>();
		
		allowHeader.add("Authorization");
		allowHeader.add("Cache-control");
		allowHeader.add("Content-Type");
		
		return allowHeader;
	}
	

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(setUpAllowHeaders());
        corsConfiguration.setAllowedOrigins(setUpAllowOrigins());
        corsConfiguration.setAllowedMethods(setUpAllowMethods());
        corsConfiguration.setAllowCredentials(false);
        corsConfiguration.setExposedHeaders(setUpAllowHeaders());
        // You can customize the following part based on your project, it's only a sample
        http.authorizeRequests().antMatchers("/**").permitAll().anyRequest()
                .authenticated().and().csrf().disable().cors().configurationSource(request -> corsConfiguration);

    }
}

