/**
 * Copyright &copy; 2012-2013 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.yuga.ygplatform.modules.sys.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.yuga.ygplatform.common.config.Global;
import com.yuga.ygplatform.common.utils.DateUtils;
import com.yuga.ygplatform.common.utils.StringUtils;
import com.yuga.ygplatform.common.web.BaseController;
import com.yuga.ygplatform.modules.sys.entity.User;
import com.yuga.ygplatform.modules.sys.utils.UserUtils;

/**
 * 用户Controller
 * 
 * @author ThinkGem
 * @version 2013-5-31
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/user")
public class UserController extends BaseController {

	@RequestMapping(value = { "list", "" })
	public String list(User user, HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/sys/userList";
	}

	@RequestMapping(value = "form")
	public String form(User user, Model model) {
		if ((user.getCompany() == null) || (user.getCompany().getId() == null)) {
			user.setCompany(UserUtils.getUser().getCompany());
		}
		if ((user.getOffice() == null) || (user.getOffice().getId() == null)) {
			user.setOffice(UserUtils.getUser().getOffice());
		}
		model.addAttribute("user", user);
		return "modules/sys/userForm";
	}

	@RequestMapping(value = "delete")
	public String delete(Long id, RedirectAttributes redirectAttributes) {
		if (UserUtils.getUser().getId().equals(id)) {
			addMessage(redirectAttributes, "删除用户失败, 不允许删除当前用户");
		} else if (User.isAdmin(id)) {
			addMessage(redirectAttributes, "删除用户失败, 不允许删除超级管理员用户");
		} else {
			addMessage(redirectAttributes, "删除用户成功");
		}
		return "redirect:" + Global.getAdminPath() + "/sys/user/?repage";
	}

	@RequestMapping(value = "export", method = RequestMethod.POST)
	public String exportFile(User user, HttpServletRequest request, HttpServletResponse response,
			RedirectAttributes redirectAttributes) {
		try {
			String fileName = "用户数据" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
			return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导出用户失败！失败信息：" + e.getMessage());
		}
		return "redirect:" + Global.getAdminPath() + "/sys/user/?repage";
	}

	@RequestMapping(value = "import", method = RequestMethod.POST)
	public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
		return "redirect:" + Global.getAdminPath() + "/sys/user/?repage";
	}

	@RequestMapping(value = "import/template")
	public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
		try {
			String fileName = "用户数据导入模板.xlsx";
			List<User> list = Lists.newArrayList();
			list.add(UserUtils.getUser());
			return null;
		} catch (Exception e) {
			addMessage(redirectAttributes, "导入模板下载失败！失败信息：" + e.getMessage());
		}
		return "redirect:" + Global.getAdminPath() + "/sys/user/?repage";
	}

	@ResponseBody
	@RequestMapping(value = "checkLoginName")
	public String checkLoginName(String oldLoginName, String loginName) {
		return "false";
	}

	@RequestMapping(value = "info")
	public String info(User user, Model model) {
		User currentUser = UserUtils.getUser();
		if (StringUtils.isNotBlank(user.getName())) {
			currentUser = UserUtils.getUser(true);
			currentUser.setEmail(user.getEmail());
			currentUser.setPhone(user.getPhone());
			currentUser.setMobile(user.getMobile());
			currentUser.setRemarks(user.getRemarks());
			model.addAttribute("message", "保存用户信息成功");
		}
		model.addAttribute("user", currentUser);
		return "modules/sys/userInfo";
	}

	@RequestMapping(value = "modifyPwd")
	public String modifyPwd(String oldPassword, String newPassword, Model model) {
		User user = UserUtils.getUser();
		if (StringUtils.isNotBlank(oldPassword) && StringUtils.isNotBlank(newPassword)) {
		}
		model.addAttribute("user", user);
		return "modules/sys/userModifyPwd";
	}

	// @InitBinder
	// public void initBinder(WebDataBinder b) {
	// b.registerCustomEditor(List.class, "roleList", new PropertyEditorSupport(){
	// @Autowired
	// private SystemService systemService;
	// @Override
	// public void setAsText(String text) throws IllegalArgumentException {
	// String[] ids = StringUtils.split(text, ",");
	// List<Role> roles = new ArrayList<Role>();
	// for (String id : ids) {
	// Role role = systemService.getRole(Long.valueOf(id));
	// roles.add(role);
	// }
	// setValue(roles);
	// }
	// @Override
	// public String getAsText() {
	// return Collections3.extractToString((List) getValue(), "id", ",");
	// }
	// });
	// }
}
