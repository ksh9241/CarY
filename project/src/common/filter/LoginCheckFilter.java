package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.base.CommonUtil;
import common.domain.UserVO;

/**
 * /user/* 로 시작하는 요청이 올 경우 로그인체크 필터가 해당 요청을 필터링한다.
 */
@WebFilter(urlPatterns = {"/user/*","/admin/*"})
public class LoginCheckFilter implements Filter {


	public void destroy() { //추상메소드
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("LoginCheckFilter...");
		// 세션에 저장되어 있는 loginUser 를 꺼낸다.
		// 만약 저장되어 있는 loginUser 가 없다면 "로그인 해야 이용 할 수 있어요"를 보여주고 return
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession ses = req.getSession();
		UserVO loginUser = (UserVO)ses.getAttribute("loginUser");
		if(loginUser == null) {
			String msg = "로그인 해야 이용 할 수 있습니다.";
			String loc = req.getContextPath()+"/login.do";
			String viewPage = CommonUtil.addMsgLoc(req, msg, loc);
			RequestDispatcher disp = req.getRequestDispatcher(viewPage);
			disp.forward(req, response);
			return;
		}
		// 그렇지 않으면 다음 필터로 넘긴다.
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
