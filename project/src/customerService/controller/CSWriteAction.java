package customerService.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.base.CommonUtil;
import common.controller.AbstractAction;
import common.domain.UserVO;

public class CSWriteAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		/*
		HttpSession ses=req.getSession();
		UserVO user=(UserVO)ses.getAttribute("loginUser");
		System.out.println(user.getMember_id());
		if(user==null) {
			this.setViewPage(CommonUtil.addMsgLoc(req, "입력을 다시 확인해 주세요.","login/login.jsp"));
			this.setRedirect(false);
		}
		*/
	
		
		
		this.setViewPage("customerService/csinput.jsp");
		this.setRedirect(false);

	}

}
