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
	
	protected List<String> setUpAllowOrigins() {
		
		List<String> allowOrigin = new ArrayList<String>();
		
		allowOrigin.add("*");
		
		return allowOrigin;
		
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        corsConfiguration.setAllowedOrigins(setUpAllowOrigins());
        corsConfiguration.setAllowedMethods(setUpAllowMethods());
        corsConfiguration.setAllowCredentials(false);
//        corsConfiguration.setExposedHeaders(List.of("Authorization"));
        // You can customize the following part based on your project, it's only a sample
        http.authorizeRequests().antMatchers("/**").permitAll().anyRequest()
                .authenticated().and().csrf().disable().cors().configurationSource(request -> corsConfiguration);

    }
}
