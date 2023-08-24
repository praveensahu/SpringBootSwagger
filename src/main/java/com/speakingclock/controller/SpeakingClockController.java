package com.speakingclock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.speakingclock.service.SpeakingClockService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
public class SpeakingClockController {

	@Autowired
	private SpeakingClockService speakingClockService;

	@GetMapping("/clock/words/{time}")
	@ResponseBody
	private ResponseEntity<String> convertTimeToWords(@PathVariable String time) throws Exception {
		return ResponseEntity.ok(speakingClockService.convertTimeToWords(time));
	}

	@GetMapping("/clock/validate/{time}")
	@ResponseBody
	private ResponseEntity<String> returnIfTimeIsMiddayOrMidnight(@PathVariable String time) throws Exception {
		return ResponseEntity.ok(speakingClockService.returnIfTimeIsMiddayOrMidnight(time));
	}

}
