package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.domain.UserVO;
import project.persistence.UserDAOMyBatis;

public class IdCheckAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String userid = req.getParameter("userid");
		
		if (userid == null || userid.trim().isEmpty()) {
			this.setViewPage("member/signup.jsp");
			this.setRedirect(false);
			return;
		}
		
		UserDAOMyBatis uvo = new UserDAOMyBatis();
		UserVO user = uvo.checkById(userid);
	
		req.setAttribute("user", user);
	
		this.setViewPage("login/idCheckShow.jsp");
		this.setRedirect(false);
	}

}
