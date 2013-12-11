/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yuga.ygplatform.modules.sys.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yuga.ygplatform.common.config.Global;
import com.yuga.ygplatform.common.persistence.Page;
import com.yuga.ygplatform.common.web.BaseController;
import com.yuga.ygplatform.modules.sys.entity.Dict;
import com.yuga.ygplatform.modules.sys.service.DictService;

/**
 * 字典Controller
 * 
 * @author ThinkGem
 * @version 2013-3-23
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/dict")
public class DictController extends BaseController {

	@Autowired
	private DictService dictService;

	@ModelAttribute
	public Dict get(@RequestParam(required = false) Long id) {
		if (id != null) {
			return dictService.get(id);
		} else {
			return new Dict();
		}
	}

	@RequestMapping(value = { "list", "" })
	public String list(Dict dict, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<String> typeList = dictService.findTypeList();
		model.addAttribute("typeList", typeList);
		Page<Dict> page = dictService.find(new Page<Dict>(request, response), dict);
		model.addAttribute("page", page);
		return "modules/sys/dictList";
	}

	@RequestMapping(value = "form")
	public String form(Dict dict, Model model) {
		model.addAttribute("dict", dict);
		return "modules/sys/dictForm";
	}

	@RequestMapping(value = "save")
	// @Valid
	public String save(Dict dict, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, dict)) {
			return form(dict, model);
		}
		dictService.save(dict);
		addMessage(redirectAttributes, "保存字典'" + dict.getLabel() + "'成功");
		return "redirect:" + Global.getAdminPath() + "/sys/dict/?repage&type=" + dict.getType();
	}

	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		dictService.delete(id);
		addMessage(redirectAttributes, "删除字典成功");
		return "redirect:" + Global.getAdminPath() + "/sys/dict/?repage";
	}

}
