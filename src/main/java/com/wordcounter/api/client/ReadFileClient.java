package com.wordcounter.api.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;


/*
 * This reads file contents via rest endpoint
 */
@Component
public class ReadFileClient {

	// read the URL location that retuns the file contents
	@Value("${text.file.url}")
	private String textFileURL;

	@Autowired
	private RestOperations restOperations;

	public String getTextFileContent() {

		ResponseEntity<String> textResponse = restOperations.getForEntity(textFileURL,
				String.class);

		return textResponse.getBody();
	}

}
