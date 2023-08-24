package com.baeldung.mockito.exceptions;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.speakingclock.service.SpeakingClockService;

class MockitoExceptionUnitTest {

	@Autowired
	private SpeakingClockService speakingClockService;

	@Test
	void testExceptionIfNullIsPassed() {
		assertThrows(Exception.class, () -> speakingClockService.convertTimeToWords(null));
	}
}
