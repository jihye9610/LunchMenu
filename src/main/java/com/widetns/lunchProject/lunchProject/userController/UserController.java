package com.widetns.lunchProject.lunchProject.userController;

import javax.servlet.http.HttpSession;

import com.widetns.lunchProject.lunchProject.entity.Member;
import com.widetns.lunchProject.lunchProject.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
	public String loginMove(Member user, HttpSession session) {


		Member result = service.checkUser(user);
		String message = "";
		if (result == null) {
			System.out.println("로그인 실패");
			message = "N";
			return message;
		} else {
			System.out.println("*******로그인 성공********");
			session.setAttribute("id", result.getId());
			session.setAttribute("userName", result.getUserName());
			session.setMaxInactiveInterval(60 * 60 * 24);
			System.out.println(session.getAttribute("id"));
			return message;
		}//end of if

	}//end of loginCheck()

	@GetMapping("/userLogOut")
	public String userLogOut(HttpSession session) {
		System.out.println(session.getAttribute("id"));
		session.invalidate();
		return "redirect:/login";
	}

	@GetMapping("/userMain")
	public String userMain(){
		// url 감출려고 하는거
		return "redirect:/main";
	}
}
	

