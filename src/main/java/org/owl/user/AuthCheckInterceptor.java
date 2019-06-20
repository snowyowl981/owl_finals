package org.owl.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthCheckInterceptor implements HandlerInterceptor {
	static final Logger logger = LogManager.getLogger();

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();
		Object user = session.getAttribute("USER");
		if (user != null)
			
			return true;
		
		String requestURL = request.getRequestURL().toString();
		String queryString = request.getQueryString();
		String returnUrl = queryString == null ? requestURL
				: requestURL + "?" + queryString;
		logger.debug("returnUrl = {}", returnUrl);
		response.sendRedirect(request.getContextPath()
				+ "/app/loginForm?returnUrl=" + returnUrl);
		return false;
	}
}