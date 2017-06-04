package kr.or.connect.todo;

import org.h2.server.web.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.web.servlet.*;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootApplication
public class TodoApplication extends WebMvcConfigurerAdapter {
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}
	
	@Bean
	public ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
		registration.addUrlMappings("/console/*");
		return registration;
	}
}
