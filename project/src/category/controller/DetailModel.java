package category.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.domain.CategoryVO;
import project.persistence.CarDAOMyBatis;

public class DetailModel extends AbstractAction {

	CarDAOMyBatis dao=new CarDAOMyBatis();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String m_code=req.getParameter("M_Code");
		
		List<CategoryVO> s_code=dao.searchDetailModelList(m_code);
		
		req.setAttribute("s_name", s_code);
		this.setViewPage("search/detailmodel.jsp");
		this.setRedirect(false);
	}

}
