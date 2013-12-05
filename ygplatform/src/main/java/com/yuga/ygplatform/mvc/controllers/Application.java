package com.yuga.ygplatform.mvc.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.yuga.ygplatform.mvc.controllers.impl.hello.MessagePrinter;
import com.yuga.ygplatform.mvc.controllers.inf.hello.MessageService;

/**
 * 
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2013
 * </p>
 * <p>
 * Company: Oplink Communications
 * </p>
 * 
 * @author
 ** @serialData 2013-11-29 下午4:26:16
 * @version 1.0
 */
@Configuration
@ComponentScan
public class Application {
	@Bean
	MessageService mockMessageService() {
		return new MessageService() {
			@Override
			public String getMessage() {
				return "Hello World!";
			}
		};
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();
	}
}
