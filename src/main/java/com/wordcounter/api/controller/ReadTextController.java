package com.wordcounter.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/counter-api")
public class ReadTextController {

	@Autowired
	private String strFromParagraph;

	@RequestMapping(value = "viewTextFileContents", method = RequestMethod.GET)
	public @ResponseBody String strFileContents() {
		return strFromParagraph;
	}
}
