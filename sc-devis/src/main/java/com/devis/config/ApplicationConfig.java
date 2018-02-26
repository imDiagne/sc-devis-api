package com.devis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;


@Configuration
@EnableAspectJAutoProxy
@Import({ SwaggerConfig.class })
@ComponentScan(basePackages = "com.devis.controller")
public class ApplicationConfig {

	@Bean
	public SimpleJaxWsServiceExporter getJWS() {
		SimpleJaxWsServiceExporter exporter = new SimpleJaxWsServiceExporter();
		exporter.setBaseAddress("http://localhost:8080/devis-Application");
		return exporter;
	}
	
}
