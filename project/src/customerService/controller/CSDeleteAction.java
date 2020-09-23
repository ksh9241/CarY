package customerService.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.base.CommonUtil;
import common.controller.AbstractAction;
import project.persistence.CSDAOMybatis;

public class CSDeleteAction extends AbstractAction {

	CSDAOMybatis dao= new CSDAOMybatis();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
	String cs_idx =req.getParameter("cs_idx");
	
	if(cs_idx==null||cs_idx.trim().isEmpty()) {
		
		this.setViewPage("cshome.do");
		this.setRedirect(true);
		return;
	}
	
	int cs_idx_int=Integer.parseInt(cs_idx);
	
	int n=dao.deleteCS(cs_idx_int);
	String msg=(n>0)?"삭제 성공":"삭제 실패";
	String loc=(n>0)?"cshome.do":"javascript:history.back()";
	String view=CommonUtil.addMsgLoc(req, msg, loc);
	this.setViewPage(view);
	this.setRedirect(false);
	
	
		
		

	}

}
