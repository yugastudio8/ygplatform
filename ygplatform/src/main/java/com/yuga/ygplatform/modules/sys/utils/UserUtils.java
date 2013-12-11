/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yuga.ygplatform.modules.sys.utils;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.google.common.collect.Maps;
import com.yuga.ygplatform.common.service.BaseService;
import com.yuga.ygplatform.common.utils.SpringContextHolder;
import com.yuga.ygplatform.modules.sys.dao.AreaDao;
import com.yuga.ygplatform.modules.sys.dao.MenuDao;
import com.yuga.ygplatform.modules.sys.dao.OfficeDao;
import com.yuga.ygplatform.modules.sys.dao.UserDao;
import com.yuga.ygplatform.modules.sys.entity.Area;
import com.yuga.ygplatform.modules.sys.entity.Menu;
import com.yuga.ygplatform.modules.sys.entity.Office;
import com.yuga.ygplatform.modules.sys.entity.User;

/**
 * 用户工具类
 * 
 * @author ThinkGem
 * @version 2013-5-29
 */
public class UserUtils extends BaseService {

	private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);
	private static MenuDao menuDao = SpringContextHolder.getBean(MenuDao.class);
	private static AreaDao areaDao = SpringContextHolder.getBean(AreaDao.class);
	private static OfficeDao officeDao = SpringContextHolder.getBean(OfficeDao.class);

	public static final String CACHE_USER = "user";
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_AREA_LIST = "areaList";
	public static final String CACHE_OFFICE_LIST = "officeList";

	public static User getUser() {
		User user = new User();
		user.setId(1L);
		user.setLoginName("Jack");
		return user;
	}

	public static User getUser(boolean isRefresh) {
		if (isRefresh) {
			removeCache(CACHE_USER);
		}
		return getUser();
	}

	public static List<Menu> getMenuList() {
		@SuppressWarnings("unchecked")
		List<Menu> menuList = (List<Menu>) getCache(CACHE_MENU_LIST);
		if (menuList == null) {
			User user = getUser();
			if (user.isAdmin()) {
				menuList = menuDao.findAllList();
			} else {
				menuList = menuDao.findByUserId(user.getId());
			}
			putCache(CACHE_MENU_LIST, menuList);
		}
		return menuList;
	}

	public static List<Area> getAreaList() {
		@SuppressWarnings("unchecked")
		List<Area> areaList = (List<Area>) getCache(CACHE_AREA_LIST);
		if (areaList == null) {
			// User user = getUser();
			// if (user.isAdmin()){
			areaList = areaDao.findAllList();
			// }else{
			// areaList = areaDao.findAllChild(user.getArea().getId(), "%,"+user.getArea().getId()+",%");
			// }
			putCache(CACHE_AREA_LIST, areaList);
		}
		return areaList;
	}

	public static List<Office> getOfficeList() {
		@SuppressWarnings("unchecked")
		List<Office> officeList = (List<Office>) getCache(CACHE_OFFICE_LIST);
		if (officeList == null) {
			User user = getUser();
			// if (user.isAdmin()){
			// officeList = officeDao.findAllList();
			// }else{
			// officeList = officeDao.findAllChild(user.getOffice().getId(), "%,"+user.getOffice().getId()+",%");
			// }
			DetachedCriteria dc = officeDao.createDetachedCriteria();
			dc.add(dataScopeFilter(user, dc.getAlias(), ""));
			dc.add(Restrictions.eq("delFlag", Office.DEL_FLAG_NORMAL));
			dc.addOrder(Order.asc("code"));
			officeList = officeDao.find(dc);
			putCache(CACHE_OFFICE_LIST, officeList);
		}
		return officeList;
	}

	// ============== User Cache ==============

	public static Object getCache(String key) {
		return getCache(key, null);
	}

	public static Object getCache(String key, Object defaultValue) {
		Object obj = getCacheMap().get(key);
		return obj == null ? defaultValue : obj;
	}

	public static void putCache(String key, Object value) {
		getCacheMap().put(key, value);
	}

	public static void removeCache(String key) {
		getCacheMap().remove(key);
	}

	public static Map<String, Object> getCacheMap() {
		Map<String, Object> map = Maps.newHashMap();
		return map;
	}
}
