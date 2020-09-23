package customerService.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import common.domain.CsVO;
import common.domain.UserVO;
import project.persistence.CSDAOMybatis;

public class CSWriteEndAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session=req.getSession();
		
		UserVO vo=(UserVO)session.getAttribute("loginUser");
		//1. name이 title, content인 값을 String 에 담는다
		String title =req.getParameter("title");
		String content =req.getParameter("content");
		String writer =vo.getMember_id();
		
		//2. title만 유효성 체크
		if(title==null||title.trim().isEmpty()) {
			
			this.setViewPage("cswrite.do");
			this.setRedirect(true);
		}
		//3. CsVO에 담는다 이때  cs_tit, cs_content 를 제외한 요소들은 기본값(Stirng이나 이외 Object일 경우 ㅡnull int나 기본자료형은 0을 넣어준다)
		CsVO cvo=new CsVO(0,title,content,writer,null,0,0);
		System.out.println(cvo.getCs_tit());
		//4. DAO 객체를 불러준다 DAOMybatis 이용 -만들어진 instance명은 dao
		CSDAOMybatis dao= new CSDAOMybatis();
		//5. insert문을 mapper에 만들어주고
		int n=dao.insertCS(cvo);
		System.out.println(n);		
		//6. dao를 통해서 insert사용 해서 값을 테이블에 저장시켜준다.
		this.setViewPage("cshome.do");
		this.setRedirect(false);
		
	}

}
