package category.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.domain.CategoryVO;
import project.persistence.CarDAOMyBatis;

public class Model extends AbstractAction {

	CarDAOMyBatis dao=new CarDAOMyBatis();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String b_code=req.getParameter("B_Code");
		//System.out.println("MODEL.B_Code : "+b_code);
		
		List<CategoryVO> m_name=dao.searchModelList(b_code);
		
		req.setAttribute("m_name", m_name);
		this.setViewPage("search/model.jsp");
		this.setRedirect(false);
	}

}
