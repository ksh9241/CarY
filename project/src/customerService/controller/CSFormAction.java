package customerService.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.domain.CsVO;
import project.persistence.CSDAOMybatis;

public class CSFormAction extends AbstractAction {

	
	CSDAOMybatis dao = new CSDAOMybatis();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
	String cs_idx = req.getParameter("idx");
	System.out.println(cs_idx);
	if(cs_idx ==null||cs_idx.trim().isEmpty()) {
		
		this.setViewPage("csindex.do");
		this.setRedirect(true);
	}
		int cs_idx_int = Integer.parseInt(cs_idx);
		CsVO cs = dao.getcs(cs_idx_int);
	
		req.setAttribute("cs", cs);
	
		this.setViewPage("customerService/my.jsp");
		this.setRedirect(false);

	}

}
