package user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import common.domain.PostVO;
import project.persistence.PostDAOMyBatis;

public class PostListAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession session = req.getSession();
		String cpStr = req.getParameter("cpage");
		System.out.println("cpStr="+cpStr);
		
		if (cpStr == null || cpStr.trim().isEmpty()) {
			if(cpStr == null) {
				cpStr = "1";
			}
		}
		
		String tempName = req.getParameter("roadName");
		String roadName = tempName.replaceAll(" ", "").replaceAll("-", "");
		System.out.println("tempName="+tempName);
		System.out.println("roadName="+roadName);

		// 첫 페이지 수
		int cpage = Integer.parseInt(cpStr);
		
		session.setAttribute("cpage", cpage);
		
		//총 검색 글 수
		PostDAOMyBatis postDao = new PostDAOMyBatis();
		int totalPostResult = postDao.getTotalPost(roadName);
		System.out.println("총 검색 글 수 :" + totalPostResult);
		
		int pageSize = 5; // 한 페이지당 보여줄 검색 수
		int pageCount = (totalPostResult-1)/pageSize +1; // 총 페이지 수
		
		if(cpage < 1) {
			cpage = 1; // 첫 페이지로 지정
		}
		if(cpage > pageCount) {
			cpage = pageCount; // 마지막 페이지로 지정
		}
		
		// start, end 값 구하는 식
		int end = cpage * pageSize;
		int start = end - (pageSize-1);
		
		// roadName, start, end 를 담는 맵
		Map<String, String> paging = new HashMap<>();
		paging.put("roadName", roadName);
		paging.put("start", String.valueOf(start));
		paging.put("end", String.valueOf(end));

		// 총 검색 목록
		List<PostVO> postList = postDao.ListPostByRoadName(paging);
		
		
		/*
		 * int pagingBlock = 5; // 페이지를 5개 단위로 블럭 처리. int prevBlock = 0, nextBlock = 0;
		 * 
		 * prevBlock = (cpage-1)/pagingBlock * pagingBlock; nextBlock = prevBlock +
		 * (pagingBlock+1);
		 */
		
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("cpage", cpage);
		req.setAttribute("postList", postList);
		req.setAttribute("totalPostResult", totalPostResult);
		
		this.setViewPage("member/postPagingResult.jsp");
		this.setRedirect(false);
	}

}
