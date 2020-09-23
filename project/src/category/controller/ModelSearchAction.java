package category.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.domain.CategoryVO;
import project.persistence.CarDAOMyBatis;

public class ModelSearchAction extends AbstractAction {

	CarDAOMyBatis cdm = new CarDAOMyBatis();
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		// 모델 값 받아오기
		String model = req.getParameter("model");
		
		// 유효성 체크
		if (model == null || model.trim().isEmpty()) {
			this.setViewPage("carsell1.jsp");
			this.setRedirect(false);
			return;
		}
		
		// 각 받아오는 값에 모델 코드값을 저장.
		switch (model) {
	
			case "현대": model="10"; break;
			case "제네시스": model="11"; break;
			case "기아": model="12"; break;
			case "쉐보레(GM대우)": model="13"; break;
			case "르노삼성": model="14"; break;
			case "쌍용": model="15"; break;
			
			case "벤츠": model="20"; break;
			case "BMW": model="21"; break;
			case "아우디": model="22"; break;
			case "렉서스": model="23"; break;
			case "미니": model="24"; break;
			case "포드": model="25"; break;
		}
		
		int model_int = Integer.parseInt(model);
		
		List<CategoryVO> mlist = cdm.modelSearchList(model_int);
		req.setAttribute("mlist", mlist);
		this.setViewPage("/search/modelSearch.jsp");
		this.setRedirect(false);
	}

}
