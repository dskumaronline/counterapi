package com.wordcounter.api.config;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.client.RestOperations;

@Configuration
public class WordCounterConfig {

	@Autowired
	private ResourceLoader lResourceLoader;

	@Autowired
	private ResourceLoader resourceLoader;

	@Value("${security.user.name}")
	private String userName;

	@Value("${security.user.password}")
	private String password;

	@Bean
	public RestOperations rest(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.basicAuthorization(userName,password).build();

	}

	@Bean(value = "strFromParagraph")
	public String readTextFile() { //1* chnange the code to read the file differenty
		Resource lResource = lResourceLoader.getResource("classpath:para-text.txt");
		StringBuffer textContentStrBuffer = new StringBuffer();
		try (InputStream in = new FileInputStream(lResource.getFile())) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line = null;
			while ((line = reader.readLine()) != null) {
				textContentStrBuffer.append(line);
			}
			return textContentStrBuffer.toString();
		} catch (IOException x) {
			System.err.println(x);
		}
		return null;
	}
}
