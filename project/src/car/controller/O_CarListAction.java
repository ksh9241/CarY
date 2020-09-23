package car.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import common.domain.CarInfoVO;
import project.persistence.CarDAOMyBatis;

public class O_CarListAction extends AbstractAction {

	CarDAOMyBatis dao = new CarDAOMyBatis();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 총 상품 목록 가져오기
		//List<carVO> list = dao.selectCarList();
		// System.out.println("111"+list);

		//req.setAttribute("list", list);
		//this.setViewPage("carBuyHome.jsp");

		// 페이징 처리
		String cpStr = req.getParameter("cpage");
		if (cpStr == null || cpStr.trim().isEmpty()) {
			cpStr = "1";
		}
		int cpage = Integer.parseInt(cpStr);
		String a = req.getParameter("pageSize");
		HttpSession session = req.getSession();
		if (a == null || a.trim().isEmpty()) {
			a = (String) session.getAttribute("pageSize");
			if (a == null) {
				a = "15";
			}
		}
		session.setAttribute("pageSize", a);

		// 1. 총 차량 수 가져오기
		int totalCount = dao.getO_TotalCount();
		
		int pageSize = Integer.parseInt(a.trim());

		int pageCount = (totalCount - 1) / pageSize + 1;
		if (cpage < 1) {
			cpage = 1;
		}
		if (cpage > pageCount) {
			cpage = pageCount;
		}
		int end = cpage * pageSize;
		int start = end - (pageSize - 1);
		Map<String, Integer> se = new HashMap<String, Integer>();
		se.put("start", start);
		se.put("end",end);
		// 2. 게시목록 가져오기
		List<CarInfoVO> arr = dao.O_listCar(se);
		int pagingBlock = 5;
		int prevBlock = 0, nextBlock = 0;

		prevBlock = (cpage - 1) / pagingBlock * pagingBlock;
		nextBlock = prevBlock + (pagingBlock + 1);
		
		System.out.println("pageCount"+pageCount);

		req.setAttribute("pageCount", pageCount);
		req.setAttribute("cpage", cpage);
		req.setAttribute("boardArr", arr);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("pagingBlock", pagingBlock);
		req.setAttribute("prevBlock", prevBlock);
		req.setAttribute("nextBlock", nextBlock);
		req.setAttribute("list", arr);

		this.setViewPage("car/OverseasCarlist.jsp");
		this.setRedirect(false);

	}

}