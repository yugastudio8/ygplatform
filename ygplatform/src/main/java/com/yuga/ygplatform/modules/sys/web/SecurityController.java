/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.yuga.ygplatform.modules.sys.web;

import java.security.Security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuga.ygplatform.modules.sys.service.SecurityService;

/**
 * 授权Controller
 * 
 * @author Kant
 * @version 2013-08-16
 */
@Controller
public class SecurityController {

	@Autowired
	private SecurityService securityService;

	@ModelAttribute
	public Security get(@RequestParam(required = false) Long id) {
		return null;
	}

	@RequestMapping(value = { "list", "" })
	public String list(Security security, HttpServletRequest request, HttpServletResponse response, Model model) {

		return "index";
	}
}
