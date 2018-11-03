package com.ciandt.teste.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ClasspathFileSource;

@Profile("sandbox")
@Configuration
public class GatewayMockConfiguration {
	//diretório onde estão os mocks .json
	private static final String MOCKS_API_1_FOLDER = "api1/";
	private static final String MOCKS_API_2_FOLDER = "api2/";
	
	/**
	 * Bean para configurar o server para a uma api.
	 */
	@Bean
	public void configureStubsForApi1() {
		//criando o filesource para o diretório informado
		//obs: o wiremock recupera os arquivos do DIRETORIO_INFORMADO/mappings
		ClasspathFileSource fileSource = new ClasspathFileSource(MOCKS_API_1_FOLDER);
		WireMockServer wiremock = new WireMockServer(9999,fileSource, false);
		wiremock.start();
	}
	
	@Bean
	public void configureStubsForApi2() {
		ClasspathFileSource fileSource = new ClasspathFileSource(MOCKS_API_2_FOLDER);
		WireMockServer wiremock = new WireMockServer(8888,fileSource, false);
		wiremock.start();
	}
	

}
