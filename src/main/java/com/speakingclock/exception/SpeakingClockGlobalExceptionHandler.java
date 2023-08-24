package com.speakingclock.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class SpeakingClockGlobalExceptionHandler {
	
	 //...
    @ExceptionHandler({Exception.class })
    public void handleException() {
       System.out.println("ExceptionOccurred");
    }

}
