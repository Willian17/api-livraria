package br.com.totemti.livraria.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ModelMappperConfiguration {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
