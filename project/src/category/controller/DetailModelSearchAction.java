package category.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.domain.CategoryVO;
import project.persistence.CarDAOMyBatis;

public class DetailModelSearchAction extends AbstractAction {

	CarDAOMyBatis cdm = new CarDAOMyBatis();
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		// 세부모델 값 받아오기
		String dmodel = req.getParameter("dmodel");
		
		// 유효성 체크
		if (dmodel == null || dmodel.trim().isEmpty()) {
			this.setViewPage("carsell1.jsp");
			this.setRedirect(false);
			return;
		}
		
		List<CategoryVO> dlist = cdm.dmodelSearchList(dmodel);
		
		req.setAttribute("dlist", dlist);
		this.setViewPage("/search/dModelSearch.jsp");
		this.setRedirect(false);
	}

}
