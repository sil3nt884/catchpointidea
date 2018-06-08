package com.mailonline.catchpoint.Schedulers;

import java.util.Set;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.openqa.selenium.Cookie;

import com.mailonline.catchpoint.RunTest;

@Configuration
@EnableScheduling
public class Scheduler {

	private RunTest tests = new RunTest();
	private String html;
	private Set<Cookie> cookies;
	
	@Scheduled(fixedDelay = 600000000)
	public void scheduleFixedDelayTask() {
		tests.setup();
		setHtml(tests.goToPageAndConsent());
		setCookies(tests.getCookies());
		try {
			Thread.sleep(1000);
			tests.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public Set<Cookie> getCookies() {
		return cookies;
	}

	public void setCookies(Set<Cookie> cookies) {
		this.cookies = cookies;
	}	
}
