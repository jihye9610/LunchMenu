package com.widetns.lunchProject.lunchProject.userController;

import javax.servlet.http.HttpSession;

import com.widetns.lunchProject.lunchProject.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.widetns.lunchProject.lunchProject.userDomain.TestUserDomain;

@Controller
public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/login")
	public String mainView() {
		return "loginForm";
	}

	@GetMapping("/loginMove")
	@ResponseBody
	public String loginMove(TestUserDomain user, HttpSession session) {

//		System.out.println(user.getUserId());
//		System.out.println(user.getUserPassword());


		TestUserDomain result = service.checkUser(user);
		String message = "";
		if (result == null) {
			System.out.println("로그인 실패");
			message = "N";
			return message;
		} else {
			System.out.println("*******로그인 성공********");
			session.setAttribute("userId", result.getUserId());
			session.setAttribute("userName", result.getUserName());
			session.setMaxInactiveInterval(60 * 60 * 24);
			System.out.println(session.getAttribute("userId"));
			return message;
		}//end of if

	}//end of loginCheck()

	@GetMapping("/userLogOut")
	public String userLogOut(HttpSession session) {
		System.out.println(session.getAttribute("userId"));
		session.invalidate();
		return "/loginForm";
	}


}
	

