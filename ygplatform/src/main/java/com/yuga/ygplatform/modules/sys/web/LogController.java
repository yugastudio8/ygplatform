/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yuga.ygplatform.modules.sys.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuga.ygplatform.common.persistence.Page;
import com.yuga.ygplatform.common.web.BaseController;
import com.yuga.ygplatform.modules.sys.entity.Log;
import com.yuga.ygplatform.modules.sys.service.LogService;

/**
 * 日志Controller
 * 
 * @author ThinkGem
 * @version 2013-6-2
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/log")
public class LogController extends BaseController {

	@Autowired
	private LogService logService;

	@RequestMapping(value = { "list", "" })
	public String list(@RequestParam Map<String, Object> paramMap, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		Page<Log> page = logService.find(new Page<Log>(request, response), paramMap);
		model.addAttribute("page", page);
		model.addAllAttributes(paramMap);
		return "modules/sys/logList";
	}

}
