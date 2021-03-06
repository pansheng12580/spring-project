package org.spring.boot.api.business.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

//@Component
public class ScheduledTasks {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	 @Scheduled(fixedRate = 5000)
	    public void reportCurrentTime() {
	        System.out.println("The time is now " + dateFormat.format(new Date()));
	    }

}
