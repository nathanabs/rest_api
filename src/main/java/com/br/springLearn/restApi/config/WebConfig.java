package com.br.springLearn.restApi.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.br.springLearn.restApi.serialization.converter.YamlJackson2HttpMessageConverter;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	
	private static final MediaType MEDIA_TYPE_YAML = MediaType.valueOf("application/x-yaml");

	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJackson2HttpMessageConverter());
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		
		
//		Via extension localhost:8080/person.json
		
		  configurer.favorParameter(false) .ignoreAcceptHeader(false)
		  .defaultContentType(MediaType.APPLICATION_JSON) 
		  .mediaType("json", MediaType.APPLICATION_JSON) 
		  .mediaType("xml", MediaType.APPLICATION_XML)
		  .mediaType("x-yaml", MEDIA_TYPE_YAML);
		 

//		via QUERY_PARAM localhost:8080/person?mediaType=json
		/*
		 * configurer.favorPathExtension(false) .favorParameter(true)
		 * .parameterName("mediaType") .ignoreAcceptHeader(true)
		 * .useRegisteredExtensionsOnly(false)
		 * .defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json",
		 * MediaType.APPLICATION_JSON) .mediaType("xml", MediaType.APPLICATION_XML)
		 * .mediaType("x-yaml", MEDIA_TYPE_YAML);
		 */
		
//		via HEADER
		/*
		 * configurer.favorPathExtension(false) .favorParameter(false)
		 * .ignoreAcceptHeader(false) .useRegisteredExtensionsOnly(false)
		 * .defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json",
		 * MediaType.APPLICATION_JSON) .mediaType("xml", MediaType.APPLICATION_XML)
		 * .mediaType("x-yaml", MEDIA_TYPE_YAML);
		 */
	}
	
}
