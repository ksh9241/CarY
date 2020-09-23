package common.domain;

import java.sql.Date;

public class CsVO {

	private  int cs_idx;//�����ͱ۹�ȣ
	private  String cs_tit;//����
	private  String cs_content;//����
	private  String cs_writer;//�ۼ���(ID)
	private  Date cs_date;//��¥
	private  int cs_secret;//��������
	
	private  int member_idx;//ȸ����ȣ
	 
	 public CsVO() {
		 
	 }

	 
	public CsVO(int cs_idx, String cs_tit, String cs_content, String cs_writer, Date cs_date, int cs_secret,
			int member_idx) {
		super();
		this.cs_idx = cs_idx;
		this.cs_tit = cs_tit;
		this.cs_content = cs_content;
		this.cs_writer = cs_writer;
		this.cs_date = cs_date;
		this.cs_secret = cs_secret;
		this.member_idx = member_idx;
	}


	public int getCs_idx() {
		return cs_idx;
	}

	public void setCs_idx(int cs_idx) {
		this.cs_idx = cs_idx;
	}

	public String getCs_tit() {
		return cs_tit;
	}

	public void setCs_tit(String cs_tit) {
		this.cs_tit = cs_tit;
	}

	public String getCs_content() {
		return cs_content;
	}

	public void setCs_content(String cs_content) {
		this.cs_content = cs_content;
	}

	public String getCs_writer() {
		return cs_writer;
	}

	public void setCs_writer(String cs_writer) {
		this.cs_writer = cs_writer;
	}

	public Date getCs_date() {
		return cs_date;
	}

	public void setCs_date(Date cs_date) {
		this.cs_date = cs_date;
	}

	public int getCs_secret() {
		return cs_secret;
	}

	public void setCs_secret(int cs_secret) {
		this.cs_secret = cs_secret;
	}

	public int getMember_idx() {
		return member_idx;
	}

	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	
	
	
}
