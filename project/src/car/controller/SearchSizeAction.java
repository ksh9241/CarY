package car.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import common.domain.CarInfoVO;
import project.persistence.CarDAOMyBatis;

public class SearchSizeAction extends AbstractAction {

	CarDAOMyBatis dao = new CarDAOMyBatis();

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		// 1. 검색한 값 가져오기
		String carSize[] = req.getParameterValues("car_size");
		System.out.println("국산 CarSize: "+carSize);

		// 제조사/모델
		String b_code = req.getParameter("car_Brand");
		if(b_code==null||b_code.length()<1) {
			b_code=null;
		}
		System.out.println("브랜드 " + b_code);
		
		String m_code = req.getParameter("car_Model");
		
		 if(m_code==null||m_code.length()<1) { m_code=null; }
		
		System.out.println("모델" + m_code);
		
		String s_code = req.getParameter("car_Detail");
		if(s_code==null||s_code.length()<1) { s_code=null; }
		System.out.println("세부 "+s_code);

		// 연식
		String carAge_min = req.getParameter("car_Age_min");
		if (carAge_min == "") {
			carAge_min = "1000";
		}
		System.out.println("자동차 연식 최소 " + carAge_min);
		String carAge_max = req.getParameter("car_Age_max");
		if (carAge_max == "") {
			carAge_max = "3000";
		}
		System.out.println("자동차 연식 최대 " + carAge_max);

		/*
		 * 얘가 왜 자꾸 에러지 //연식 최소 최대 값이 바뀔 경우 String car_change=""; int
		 * aa=Integer.parseInt(carAge_min); int bb=Integer.parseInt(carAge_max);
		 * if(aa>bb) { car_change=carAge_min; carAge_min=carAge_max;
		 * carAge_max=car_change;
		 * 
		 * System.out.println("바뀐값 "+carAge_min+"/"+carAge_max); }
		 */

		// 주행거리
		String car_km_min = req.getParameter("car_distance_min");
		if (car_km_min == "") {
			car_km_min = "1000";
		}
		String car_km_max = req.getParameter("car_distance_max");
		if (car_km_max == "") {
			car_km_max = "990000";
		}
		System.out.println("car_km_min" + car_km_min);

		// 가격
		String car_price_min = req.getParameter("car_price_min");
		if (car_price_min == "") {
			car_price_min = "50000";
		}
		String car_price_max = req.getParameter("car_price_max");
		if (car_price_max == "") {
			car_price_max = "999999999";
		}
		System.out.println("가격 " + car_price_min);
		System.out.println("가격 " + car_price_max);

		// 색상
		String car_color[] = req.getParameterValues("car_Color");
		System.out.println("색상 " + car_color);

		// 연료
		String car_fuel[] = req.getParameterValues("car_Fuel");
		System.out.println("연료: " + car_fuel);
		// 변속기
		String car_gear[] = req.getParameterValues("car_Gear"); // 필요한 값 네임
		System.out.println("기어: " + car_gear);

		// 옵션
		String car_option[] = req.getParameterValues("opt_idx");
		System.out.println("옵션: " + car_option);

		// 성능점검
		String car_test = req.getParameter("car_test");
		System.out.println("성능점검: " + car_test);

		// 인승
		String car_seat[] = req.getParameterValues("car_Seat");
		System.out.println("인승: " + car_seat);

		List<String> carSizeArr = new ArrayList<>();
		List<String> color_list = new ArrayList<>();
		List<String> fuel_list = new ArrayList<>();
		List<String> gear_list = new ArrayList<>();
		List<String> opt_idx = new ArrayList<>(); // 옵션번호 받아서 idx값 처리하는 리스트
		//List<String> car_option2 = new ArrayList<>();
		List<String> option_idx = new ArrayList<>();
		List<String> seat_list = new ArrayList<>();

		if (car_option != null) {
			for (int i = 0; i < car_option.length; i++) {
				opt_idx.add(car_option[i]);
			}
			option_idx = dao.carOptionList(opt_idx);
		}
		
		/*옵션에 맞는 값이 없어서 반환되는 idx값이 없을 경우*/
		if(car_option!=null && option_idx.size()<1) {
			option_idx.add("0");
		}else if(car_option==null){
			option_idx.clear();
		}
		

		// 사이드바 차량 값 저장하기(count용)
		Map<String, Object> carSize3 = new HashMap<String, Object>();
		if (carSize != null) {
			for (int i = 0; i < carSize.length; i++) {
				carSizeArr.add(carSize[i]);
				carSize3.put("car_size", carSizeArr);
			}
		}
		if (b_code != null) {
			carSize3.put("b_code", b_code);
		}
		if (m_code !=null) {
			carSize3.put("m_code", m_code);
		}
		if (s_code !=null) {
			carSize3.put("s_code", s_code);
		}
		if (carAge_min != null || carAge_max != null) {
			carSize3.put("carAge_min", carAge_min);
			carSize3.put("carAge_max", carAge_max);
		}
		carSize3.put("car_km_min", car_km_min);
		carSize3.put("car_km_max", car_km_max);
		carSize3.put("car_price_min", car_price_min);
		carSize3.put("car_price_max", car_price_max);

		if (car_color != null) {
			for (int i = 0; i < car_color.length; i++) {
				color_list.add(car_color[i]);
				carSize3.put("car_color", color_list);
			}
		}
		if (car_fuel != null) {
			for (int i = 0; i < car_fuel.length; i++) {
				fuel_list.add(car_fuel[i]);
				carSize3.put("car_fuel", fuel_list);
			}
		}
		if (car_gear != null) {
			for (int i = 0; i < car_gear.length; i++) {
				gear_list.add(car_gear[i]);
				carSize3.put("car_gear", gear_list);
			}
		}

		if (option_idx != null) {
			carSize3.put("option_idx", option_idx);
		}

		if (car_test != null) {
			carSize3.put("car_test", car_test);
		}
		if (car_seat != null) {
			for (int i = 0; i < car_seat.length; i++) {
				seat_list.add(car_seat[i]);
				carSize3.put("car_seat", seat_list);
			}
		}

		String cpStr = req.getParameter("cpage");
		if (cpStr == null || cpStr.trim().isEmpty()) {
			cpStr = "1";
		}
		int cpage = Integer.parseInt(cpStr);
		String a = req.getParameter("pageSize2");

		if (a == null || a.trim().isEmpty()) {
			a = (String) session.getAttribute("pageSize2");
			if (a == null) {
				a = "15";
			}
		}
		session.setAttribute("pageSize2", a);

		// 2. 검색한 차량 수 가져오기
		int Count = dao.getSideOptCount(carSize3);
		// System.out.println("차량수는:"+Count);
		// System.out.println("카사이즈3="+carSize3);

		int pageSize2 = Integer.parseInt(a.trim());

		int pageCount2 = (Count - 1) / pageSize2 + 1;
		if (cpage < 1) {
			cpage = 1;
		}
		if (cpage > pageCount2) {
			cpage = pageCount2;
		}
		int end = cpage * pageSize2;
		int start = end - (pageSize2 - 1);

		// 페이징처리까지 가능한 사이드바 차량 검색
		Map<String, Object> se = new HashMap<String, Object>();
		se.put("start", String.valueOf(start));
		se.put("end", String.valueOf(end));
		if (carSize != null) {
			for (int i = 0; i < carSize.length; i++) {
				se.put("car_size", carSizeArr);
			}

		}
		if (b_code != null) {
			se.put("b_code", b_code);
		}
		if (m_code !=null) {
			se.put("m_code", m_code);
		}
		if (s_code !=null) {
			se.put("s_code", s_code);
		}
		if (carAge_min != null || carAge_max != null) {
			se.put("carAge_min", carAge_min);
			se.put("carAge_max", carAge_max);
		}
		se.put("car_km_min", car_km_min);
		se.put("car_km_max", car_km_max);
		se.put("car_price_min", car_price_min);
		se.put("car_price_max", car_price_max);

		if (car_color != null) {
			for (int i = 0; i < car_color.length; i++) {
				se.put("car_color", color_list);
			}
		}
		if (car_fuel != null) {
			for (int i = 0; i < car_fuel.length; i++) {
				se.put("car_fuel", fuel_list);
			}
		}
		if (car_gear != null) {
			for (int i = 0; i < car_gear.length; i++) {
				se.put("car_gear", gear_list);
			}
		}
		if (option_idx != null) {
			se.put("option_idx", option_idx);
		}

		/*
		 * if(car_option !=null) { for(int i=0;i<car_option.length;i++) {
		 * car_option2.add(car_option[i]); } se.put("car_option", car_option2); }
		 */

		if (car_test != null) {
			se.put("car_test", car_test);
		}
		if (car_seat != null) {
			for (int i = 0; i < car_seat.length; i++) {
				se.put("car_seat", seat_list);
			}
		}

		// for(String str : se.get("carSize")) {
		// System.out.println("str:"+str);
		// }

		// 3. 차량크기에 맞는 차량 페이징처리해서 가져오기
		List<CarInfoVO> arr = dao.carSideOptList(se);
		System.out.println("arr+" + arr);

		int pagingBlock2 = 5;
		int prevBlock2 = 0, nextBlock2 = 0;

		prevBlock2 = (cpage - 1) / pagingBlock2 * pagingBlock2;
		nextBlock2 = prevBlock2 + (pagingBlock2 + 1);

		req.setAttribute("Count", Count);
		req.setAttribute("searchList", arr);
		req.setAttribute("pageCount2", pageCount2); 
		req.setAttribute("cpage", cpage);
		req.setAttribute("pagingBlock2", pagingBlock2);
		req.setAttribute("prevBlock2", prevBlock2);
		req.setAttribute("nextBlock2", nextBlock2);
		req.setAttribute("search", carSize);

		this.setViewPage("car/carSize.jsp");
		this.setRedirect(false);

	}

}
