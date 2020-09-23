package common.domain;

import java.io.Serializable;
import java.sql.Date;

public class UserVO implements Serializable {
	private int member_idx;
	private String member_id;
	private String member_pwd;
	private String member_email;
	private int member_year;
	private int member_month;
	private int member_day;
	private String member_sex;
	private int member_post;
	private String member_addr1;
	private String member_addr2;
	private String member_name;
	private String member_phone;
	private java.sql.Date member_date;
	
	public UserVO() {
		System.out.println("UserVO 생성");
		
	}

	public UserVO(int member_idx, String member_id, String member_pwd, String member_email, int member_year,
			int member_month, int member_day, String member_sex, int member_post, String member_addr1,
			String member_addr2, String member_name, String member_phone, Date member_date) {
		super();
		this.member_idx = member_idx;
		this.member_id = member_id;
		this.member_pwd = member_pwd;
		this.member_email = member_email;
		this.member_year = member_year;
		this.member_month = member_month;
		this.member_day = member_day;
		this.member_sex = member_sex;
		this.member_post = member_post;
		this.member_addr1 = member_addr1;
		this.member_addr2 = member_addr2;
		this.member_name = member_name;
		this.member_phone = member_phone;
		this.member_date = member_date;
	}

	public int getMember_idx() {
		return member_idx;
	}

	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_pwd() {
		return member_pwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public int getMember_year() {
		return member_year;
	}

	public void setMember_year(int member_year) {
		this.member_year = member_year;
	}

	public int getMember_month() {
		return member_month;
	}

	public void setMember_month(int member_month) {
		this.member_month = member_month;
	}

	public int getMember_day() {
		return member_day;
	}

	public void setMember_day(int member_day) {
		this.member_day = member_day;
	}

	public String getMember_sex() {
		return member_sex;
	}

	public void setMember_sex(String member_sex) {
		this.member_sex = member_sex;
	}

	public int getMember_post() {
		return member_post;
	}

	public void setMember_post(int member_post) {
		this.member_post = member_post;
	}

	public String getMember_addr1() {
		return member_addr1;
	}

	public void setMember_addr1(String member_addr1) {
		this.member_addr1 = member_addr1;
	}

	public String getMember_addr2() {
		return member_addr2;
	}

	public void setMember_addr2(String member_addr2) {
		this.member_addr2 = member_addr2;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public java.sql.Date getMember_date() {
		return member_date;
	}

	public void setMember_date(java.sql.Date member_date) {
		this.member_date = member_date;
	}

	
	
}