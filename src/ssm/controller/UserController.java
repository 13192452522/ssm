package ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.mybatis.po.User;
import ssm.service.UserService;

@Controller
public class UserController {
	@Resource(name = "userServiceImpl")
	private UserService userService;

	@RequestMapping(value = "login")
	@ResponseBody
	public User requestJson(@RequestBody User user, HttpServletRequest request) {
		User u = userService.login(user);
		if (u == null) {
			return null;
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", u);
		return u;
	}

	@RequestMapping(value = "register")
	@ResponseBody
	public String register(@RequestBody User user) {
		userService.save(user);
		return "{\"success\":true}";
	}

	@RequestMapping(value = "update")
	@ResponseBody
	public String update(@RequestBody User user) {
		userService.update(user);
		return "{\"success\":true}";
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
