package customerService.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.base.CommonUtil;
import common.controller.AbstractAction;
import project.persistence.CSDAOMybatis;

public class CSEditEndAction extends AbstractAction {

	CSDAOMybatis dao=new CSDAOMybatis();
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String cs_tit =req.getParameter("title");
		String cs_content =req.getParameter("content");
		String cs_idx=req.getParameter("cs_idx");
		
		if(cs_tit==null||cs_content==null||cs_idx==null||cs_tit.trim().isEmpty()||
				cs_content.trim().isEmpty()||cs_idx.trim().isEmpty()) {
			
			this.setViewPage("cshome.do");
			this.setRedirect(true);
			
		}
		Map<String,String> map=new HashMap<String, String>();
		
		map.put("cs_tit",cs_tit);
		map.put("cs_content",cs_content);
		map.put("cs_idx",cs_idx);
		
		int n=dao.editCS(map);
		String msg=(n>0)?"수정 성공":"수정 실패";
		String loc=(n>0)?"cshome.do":"javascript:history.back()";
		String view=CommonUtil.addMsgLoc(req, msg, loc);
		//System.out.println(str);	
		this.setViewPage(view);
		this.setRedirect(false);

	}

}
