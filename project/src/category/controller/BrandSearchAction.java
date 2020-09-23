package category.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.domain.CategoryVO;
import project.persistence.CarDAOMyBatis;

public class BrandSearchAction extends AbstractAction {

	CarDAOMyBatis cdm = new CarDAOMyBatis();
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		// 국산 or 수입 받기
		String country = req.getParameter("country");
		
		// 유효성 체크
		if (country == null || country.trim().isEmpty()) {
			this.setViewPage("carsell1.jsp");
			this.setRedirect(false);
			return;
		}
		
		// 받은 value 가 국산이면 1을 저장, 외제면 2를 저장
		int val = (country.equals("국산"))? 1:2;
		List<CategoryVO> blist = cdm.brandSearchList(val);
		
		req.setAttribute("blist", blist);
		
		this.setViewPage("/search/brandSearch.jsp");
		this.setRedirect(false);

	}

}
