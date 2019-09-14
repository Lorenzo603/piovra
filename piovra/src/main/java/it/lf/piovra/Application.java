package it.lf.piovra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@SpringBootApplication
@EnableWebSecurity
@ImportResource({"classpath*:application-context.xml", "classpath*:spring-security.xml"})
public class Application
{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
