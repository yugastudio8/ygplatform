package com.yuga.ygplatform.mvc.controllers.impl.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
 ** @serialData 2013-11-29 下午4:24:55
 * @version 1.0
 */
@Component
public class MessagePrinter {

	@Autowired
	private MessageService service;

	public void printMessage() {
		System.out.println(this.service.getMessage());
	}
}
