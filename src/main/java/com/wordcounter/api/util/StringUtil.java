package com.wordcounter.api.util;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.wordcounter.api.vo.WordCountVO;

public class StringUtil {


	/*
	* This method reads the file content and store the words and the count to Stream map for
	* further processing
	 */
	private static Stream<Map.Entry<String, Integer>> getWordMapCountStreamFromStr(String textContent) {

		String[] cleanedStr = textContent.replaceAll("\\p{P}", " ").toLowerCase().split("\\s+");

		Stream<Map.Entry<String, Integer>> frequencyMap = Arrays.asList(cleanedStr).stream()
				.filter(e -> e.length() > 0)
				.map(String::toLowerCase)
				.map(String::trim)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)))
				.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed());
		return frequencyMap;
	}


	public static Map<String, Integer> getWordOccurences(String str) {
		Stream<Map.Entry<String, Integer>> frequencyMapStreem = getWordMapCountStreamFromStr(str);
		Map<String, Integer> frequencyMap = frequencyMapStreem.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(e1, e2) -> e1 + e2, HashMap::new));
		
		return frequencyMap;
	}
	
	public static List<WordCountVO> queryWordFrequency(String str, List<String> wordsList){
		Map<String, Integer> wordMap = getWordOccurences(str);
		
		List<WordCountVO> wordCountList = new ArrayList<>();
		for(String word : wordsList){
			if(wordMap.containsKey(word.toLowerCase())){
				wordCountList.add(new WordCountVO(word, wordMap.get(word.toLowerCase())));
			} else {
				wordCountList.add(new WordCountVO(word, 0));
			}
		}

		return wordCountList;
	}
	

	
	public static Map<String, Integer> getWordCountByLimit(String str, Integer number) {

		Stream<Map.Entry<String, Integer>> wordMapStreem = getWordMapCountStreamFromStr(str);

		Map<String, Integer> frequencyMap = wordMapStreem.limit(number)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(e1, e2) -> e1 + e2, LinkedHashMap::new));
		
		return frequencyMap;
		
	}
	
	


}
