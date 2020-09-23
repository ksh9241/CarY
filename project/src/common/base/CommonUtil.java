package common.base;

import javax.servlet.http.HttpServletRequest;

public class CommonUtil {

	public static String addMsgLoc(HttpServletRequest req, String msg, String loc) {
		req.setAttribute("message", msg);
		req.setAttribute("loc", loc);
		return "/msg.jsp"; 
	}
	
	public static String addMsgback(HttpServletRequest req, String msg) {
		req.setAttribute("message", msg);
		req.setAttribute("loc", "javascript:history.back()");
		return "/msg.jsp";
	}
	
}
