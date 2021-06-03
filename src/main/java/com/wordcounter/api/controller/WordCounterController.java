package com.wordcounter.api.controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.wordcounter.api.service.WordCounterService;
import com.wordcounter.api.vo.WordCountVO;


@RestController
@RequestMapping("/counter-api")
public class WordCounterController {


	@Autowired
	private WordCounterService counterService;

    
    
    @RequestMapping(value = "/search", method = RequestMethod.POST)
	public @ResponseBody Map<String, List<WordCountVO>> getWordwithCount(
			@RequestBody Map<String, List<String>> requestBody) {
		List<WordCountVO> wordCount = counterService.queryWordOccurence(requestBody.get("searchText"));
		Map<String, List<WordCountVO>> response = new HashMap<>();
		response.put("counts", wordCount);
		return response;
	}
    
    @RequestMapping(value = "/top/{number}", method = RequestMethod.GET)
	public void listTopWordsAsCSV(@PathVariable("number") Integer number, HttpServletResponse response) {
		Map<String, Integer> topWords = counterService.getTopWordsInText(number);
		StringBuffer csvStrBufer = new StringBuffer();

		for (Entry<String, Integer> e : topWords.entrySet()) {
			csvStrBufer.append(e.getKey() + "," + e.getValue() + "\n");
		}

		response.setContentType("application/csv");
		response.setHeader("Content-Disposition", "attachment; filename=" + "top" + number + "words");
		response.setContentType("text/plain; charset=utf-8");

		try {
			response.getWriter().print(csvStrBufer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
   
    
   
}
