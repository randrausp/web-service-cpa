package br.com.asert.cpa.webservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ApiConfig extends WebMvcConfigurerAdapter {

	private final JwtConfig jwtConfig;

	public ApiConfig(JwtConfig jwtConf) {
		this.jwtConfig = jwtConf;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestFilter(jwtConfig)).addPathPatterns("/api/**/*");
	}
}
