package org.spring.boot.api.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * 初始化启动Listener
 * @author pantheon
 * @since 2016/7/25
 */
public class InitListener implements ApplicationListener<ApplicationReadyEvent>{

	@Override
	public void onApplicationEvent(ApplicationReadyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("初始化启动Listener--->onApplicationEvent");
	}


}
