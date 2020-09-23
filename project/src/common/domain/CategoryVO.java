package common.domain;

public class CategoryVO {
	private int b_code;
	private String b_name;
	
	private int m_code;
	private String m_name;
	
	private int s_code;
	private String s_name;
	
	public CategoryVO() {
		System.out.println("CVO 생성");
	}

	public CategoryVO(int b_code, String b_name, int m_code, String m_name, int s_code, String s_name) {
		super();
		this.b_code = b_code;
		this.b_name = b_name;
		this.m_code = m_code;
		this.m_name = m_name;
		this.s_code = s_code;
		this.s_name = s_name;
	}

	public int getB_code() {
		return b_code;
	}

	public void setB_code(int b_code) {
		this.b_code = b_code;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public int getM_code() {
		return m_code;
	}

	public void setM_code(int m_code) {
		this.m_code = m_code;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public int getS_code() {
		return s_code;
	}

	public void setS_code(int s_code) {
		this.s_code = s_code;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	
	
	
}
