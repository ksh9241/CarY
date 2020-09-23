package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.base.CommonUtil;
import common.controller.AbstractAction;
import common.domain.UserVO;
import project.persistence.UserDAOMyBatis;

public class SignupEndAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String userid = req.getParameter("userid");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String sex = req.getParameter("sex");
		String hp = req.getParameter("hp");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String email = req.getParameter("email");
		
		
		String year = req.getParameter("year");
		String mouth = req.getParameter("month");
		String day = req.getParameter("day");
		String post = req.getParameter("post");
		
		// integer
		
		int year_int = Integer.parseInt(year);
		int mouth_int = Integer.parseInt(mouth);
		int day_int = Integer.parseInt(day);
		int post_int = Integer.parseInt(post);
		
		if(userid == null || pwd == null || name == null || sex == null || hp == null 
			|| addr1 == null || addr2 == null || year == null || mouth == null || day == null
			|| post == null || userid.trim().isEmpty() || pwd.trim().isEmpty()
			|| name.trim().isEmpty() || sex.trim().isEmpty() || hp.trim().isEmpty() 
			|| addr1.trim().isEmpty() || addr2.trim().isEmpty() || year.trim().isEmpty()
			|| mouth.trim().isEmpty() || day.trim().isEmpty() || post.trim().isEmpty()) {
			this.setViewPage(CommonUtil.addMsgback(req, "입력을 다시 확인해 주세요."));
			this.setRedirect(false);
			return;
		}
		
		UserVO uv = new UserVO(0, userid, pwd, email, year_int, mouth_int, day_int, sex, post_int, addr1, addr2, name, hp, null);
		
		UserDAOMyBatis dao = new UserDAOMyBatis(); 
		int n = dao.insertMember(uv);
		System.out.println("insert = "+n);
		
		String msg = (n>0)? "회원 가입 되었습니다! 로그인 해주세요.":"회원 가입 실패! 입력값을 다시 확인해 주세요.";
		String loc = (n>0)? "login.do":"javascript:history.back()";
		
		this.setViewPage(CommonUtil.addMsgLoc(req, msg, loc));
		this.setRedirect(false);
	}
}
