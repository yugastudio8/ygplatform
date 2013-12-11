/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yuga.ygplatform.modules.sys.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuga.ygplatform.common.persistence.Page;
import com.yuga.ygplatform.common.service.BaseService;
import com.yuga.ygplatform.modules.sys.dao.DictDao;
import com.yuga.ygplatform.modules.sys.entity.Dict;

/**
 * 字典Service
 * 
 * @author ThinkGem
 * @version 2013-5-29
 */
@Service
@Transactional(readOnly = true)
public class DictService extends BaseService {

	@Autowired
	private DictDao dictDao;

	public Dict get(Long id) {
		return dictDao.findOne(id);
	}

	public Page<Dict> find(Page<Dict> page, Dict dict) {
		DetachedCriteria dc = dictDao.createDetachedCriteria();
		if (StringUtils.isNotEmpty(dict.getType())) {
			dc.add(Restrictions.eq("type", dict.getType()));
		}
		if (StringUtils.isNotEmpty(dict.getDescription())) {
			dc.add(Restrictions.like("description", "%" + dict.getDescription() + "%"));
		}
		dc.add(Restrictions.eq(Dict.DEL_FLAG, Dict.DEL_FLAG_NORMAL));
		dc.addOrder(Order.asc("type")).addOrder(Order.asc("sort")).addOrder(Order.desc("id"));
		return dictDao.find(page, dc);
	}

	public List<String> findTypeList() {
		return dictDao.findTypeList();
	}

	@Transactional(readOnly = false)
	public void save(Dict dict) {
		dictDao.save(dict);
	}

	@Transactional(readOnly = false)
	public void delete(Long id) {
		dictDao.deleteById(id);
	}

}
