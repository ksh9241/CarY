package common.domain;

import java.io.Serializable;
import java.sql.Date;

public class CarInfoVO implements Serializable {

	private int idx; // 글번호
	private String car_num; // 차량번호
	private String car_size; // 차종
	private int b_code; // 브랜드코드
	private int m_code; // 모델코드
	private int s_code; // 세부모델코드
	
	private String b_name;
	private String m_name;
	private String s_name;
	
	private String car_fuel; // 연료
	private String car_age; // 연식
	private int car_cc; // 배기량
	private String car_seat; // 인승
	
	private String car_gear; // 변속기
	private String car_color; // 색상
	private int car_km; // 주행거리
	
	private int car_price; // 차 가격
	private String car_test; // 성능점검
	private String car_intro; // 차량 설명
	
	private int member_idx; // 글을 등록하는 회원의 회원번호
	
	private String car_img1; // 차량 사진1
	private String car_img2; // 차량 사진2
	private String car_img3; // 차량 사진3
	private Date car_date; // 게시글 등록시간
	int car_view; // 판매글 조회수 
	
	
	// 관리자 관리 변수
	int car_yn; // 차량 판매 여부
	int car_hs; // 홈 서비스 가능 여부
	
	// 차량 옵션 정보
	private String opt1;
	private String opt2;
	private String opt3;
	private String opt4;
	
	
	public CarInfoVO() {
		System.out.println("CarinfoVO 생성");
	}


	public CarInfoVO(int idx, String car_num, String car_size, int b_code, int m_code, int s_code, String car_fuel,
			String car_age, int car_cc, String car_seat, String car_gear, String car_color, int car_km, int car_price,
			String car_test, String car_intro, int member_idx, String car_img1, String car_img2, String car_img3,
			Date car_date, int car_view) {
		super();
		this.idx = idx;
		this.car_num = car_num;
		this.car_size = car_size;
		this.b_code = b_code;
		this.m_code = m_code;
		this.s_code = s_code;
		this.car_fuel = car_fuel;
		this.car_age = car_age;
		this.car_cc = car_cc;
		this.car_seat = car_seat;
		this.car_gear = car_gear;
		this.car_color = car_color;
		this.car_km = car_km;
		this.car_price = car_price;
		this.car_test = car_test;
		this.car_intro = car_intro;
		this.member_idx = member_idx;
		this.car_img1 = car_img1;
		this.car_img2 = car_img2;
		this.car_img3 = car_img3;
		this.car_date = car_date;
		this.car_view = car_view;
	}
	
	


	public String getB_name() {
		return b_name;
	}


	public void setB_name(String b_name) {
		this.b_name = b_name;
	}


	public String getM_name() {
		return m_name;
	}


	public void setM_name(String m_name) {
		this.m_name = m_name;
	}


	public String getS_name() {
		return s_name;
	}


	public void setS_name(String s_name) {
		this.s_name = s_name;
	}


	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	public String getCar_num() {
		return car_num;
	}


	public void setCar_num(String car_num) {
		this.car_num = car_num;
	}


	public String getCar_size() {
		return car_size;
	}


	public void setCar_size(String car_size) {
		this.car_size = car_size;
	}


	public int getB_code() {
		return b_code;
	}


	public void setB_code(int b_code) {
		this.b_code = b_code;
	}


	public int getM_code() {
		return m_code;
	}


	public void setM_code(int m_code) {
		this.m_code = m_code;
	}


	public int getS_code() {
		return s_code;
	}


	public void setS_code(int s_code) {
		this.s_code = s_code;
	}


	public String getCar_fuel() {
		return car_fuel;
	}


	public void setCar_fuel(String car_fuel) {
		this.car_fuel = car_fuel;
	}


	public String getCar_age() {
		return car_age;
	}


	public void setCar_age(String car_age) {
		this.car_age = car_age;
	}


	public int getCar_cc() {
		return car_cc;
	}


	public void setCar_cc(int car_cc) {
		this.car_cc = car_cc;
	}


	public String getCar_seat() {
		return car_seat;
	}


	public void setCar_seat(String car_seat) {
		this.car_seat = car_seat;
	}


	public String getCar_gear() {
		return car_gear;
	}


	public void setCar_gear(String car_gear) {
		this.car_gear = car_gear;
	}


	public String getCar_color() {
		return car_color;
	}


	public void setCar_color(String car_color) {
		this.car_color = car_color;
	}


	public int getCar_km() {
		return car_km;
	}


	public void setCar_km(int car_km) {
		this.car_km = car_km;
	}


	public int getCar_price() {
		return car_price;
	}


	public void setCar_price(int car_price) {
		this.car_price = car_price;
	}


	public String getCar_test() {
		return car_test;
	}


	public void setCar_test(String car_test) {
		this.car_test = car_test;
	}


	public String getCar_intro() {
		return car_intro;
	}


	public void setCar_intro(String car_intro) {
		this.car_intro = car_intro;
	}


	public int getMember_idx() {
		return member_idx;
	}


	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}


	public String getCar_img1() {
		return car_img1;
	}


	public void setCar_img1(String car_img1) {
		this.car_img1 = car_img1;
	}


	public String getCar_img2() {
		return car_img2;
	}


	public void setCar_img2(String car_img2) {
		this.car_img2 = car_img2;
	}


	public String getCar_img3() {
		return car_img3;
	}


	public void setCar_img3(String car_img3) {
		this.car_img3 = car_img3;
	}


	public Date getCar_date() {
		return car_date;
	}


	public void setCar_date(Date car_date) {
		this.car_date = car_date;
	}


	public String getOpt1() {
		return opt1;
	}


	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}


	public String getOpt2() {
		return opt2;
	}


	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}


	public String getOpt3() {
		return opt3;
	}


	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}


	public String getOpt4() {
		return opt4;
	}


	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}


	public int getCar_view() {
		return car_view;
	}


	public void setCar_view(int car_view) {
		this.car_view = car_view;
	}
	
	
}


	