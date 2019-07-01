package com.yk.listener;


import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
@Component
public class KaiListener implements ApplicationContextAware{

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		System.out.println("k--------------------------------k");
		System.out.println(dataSource.getClass().getName());
		System.out.println("k--------------------------------k");
	}

}
