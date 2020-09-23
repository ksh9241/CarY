package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.base.CommonUtil;
import common.controller.AbstractAction;
import common.domain.UserVO;
import project.persistence.UserDAOMyBatis;

public class LoginEndAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String userid = req.getParameter("userid");
		String pwd = req.getParameter("pwd");
		
		if(userid == null || pwd == null || userid.trim().isEmpty()
				|| pwd.trim().isEmpty()) {
			this.setViewPage(CommonUtil.addMsgback(req, "입력을 다시 확인해 주세요."));
			this.setRedirect(false);
			return;
		}
		
		UserDAOMyBatis dao = new UserDAOMyBatis();
		UserVO user = dao.checkById(userid);
		if(user == null) {
			this.setViewPage(CommonUtil.addMsgback(req, "아이디 또는 비밀번호가 틀렸습니다."));
			this.setRedirect(false);
			return;
		} else if(!pwd.equals(user.getMember_pwd())){
			this.setViewPage(CommonUtil.addMsgback(req, "아이디 또는 비밀번호가 틀렸습니다."));
			this.setRedirect(false);
			return;
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", user);
		}
		
		this.setRedirect(true);
		this.setViewPage("index.do");
			
	}
}
