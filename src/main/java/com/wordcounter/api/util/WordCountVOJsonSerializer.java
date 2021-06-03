package com.wordcounter.api.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import com.wordcounter.api.vo.WordCountVO;

/*
 * This class use JsonComponent to customize the JSON response
 */

@JsonComponent
public class WordCountVOJsonSerializer extends JsonSerializer<WordCountVO> {

	@Override
	public void serialize(WordCountVO wordCountVO, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
			throws IOException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeNumberField(wordCountVO.getWord(), wordCountVO.getWordCount());
		jsonGenerator.writeEndObject();
	}

}