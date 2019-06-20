package org.owl.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	
	/**
	 * 로그인 화면
	 */
	@GetMapping("/loginForm")
	public String form() {
		return "login/loginForm";
	}
	
	/**
	 * 로그인을 실행
	 */
	@PostMapping("/login")
	public String submit(@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("returnUrl") String returnUrl, HttpSession session) {
		try {
			User user = userDao.selectByLogin(email, password);
			session.setAttribute("USER", user);
			return "redirect:" + returnUrl;
		} catch (EmptyResultDataAccessException e) {
			return "redirect:/app/loginForm?mode=FAILURE&email=" + email
					+ "&returnUrl=" + returnUrl;
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}