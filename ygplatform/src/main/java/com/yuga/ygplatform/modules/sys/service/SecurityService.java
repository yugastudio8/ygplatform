/**
 * There are <a href="https://github.com/thinkgem/jeesite">JeeSite</a> code generation
 */
package com.yuga.ygplatform.modules.sys.service;

import java.security.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 授权Service
 * 
 * @author Kant
 * @version 2013-08-16
 */
@Component
public class SecurityService {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(SecurityService.class);

	// @Autowired
	// private UserAccessAddrDao userAccessAddrDao;

	public Security get(Long id) {
		return null;
	}

	public void saveUserAccess(String value) {
		// userAccessAddrDao.save(entity);
		System.out.println("保存成功!!!!");
	}
}
