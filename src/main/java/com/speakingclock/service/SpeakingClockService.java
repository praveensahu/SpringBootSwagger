package com.speakingclock.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.speakingclock.constant.SpeakingClockConstant;
import com.speakingclock.util.NumberToWordsConverter;

/**
 * Having only one service without interface as purpose is minimal
 * 
 * @author praveen
 *
 */
@Service
public class SpeakingClockService {

	public String convertTimeToWords(String time) throws Exception {
		StringBuilder output = new StringBuilder();
		for (String s : time.split("\\:")) {
			output.append(NumberToWordsConverter.numberToWords(Long.valueOf(s))).append(" ");
		}
		return SpeakingClockConstant.SPEAKING_CLOCK_PREFIX + output.toString();
	}

	public String returnIfTimeIsMiddayOrMidnight(String time) throws Exception {
		String arr[] = time.split("\\:");
		String output = "";
		LocalTime specificTime = LocalTime.of(Integer.valueOf(arr[0]), Integer.valueOf(arr[1])); // Example: 3:30 PM
		// Define 12 PM
		LocalTime twelvePM = LocalTime.of(12, 0);
		if (specificTime.isBefore(twelvePM) || specificTime.equals(twelvePM)) {
			output = "Midday";
		} else {
			output = "Midnight";
		}
		return SpeakingClockConstant.SPEAKING_CLOCK_PREFIX + output;
	}

}
