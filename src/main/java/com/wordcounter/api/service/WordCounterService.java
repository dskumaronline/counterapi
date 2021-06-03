package com.wordcounter.api.service;

import java.util.List;
import java.util.Map;

import com.wordcounter.api.vo.WordCountVO;

public interface WordCounterService {

	List<WordCountVO> queryWordOccurence(List<String> queryWords);
	
	Map<String, Integer> getTopWordsInText(Integer number);
	
}


