package common.domain;

public class OptionVO {
	private int idx;
	private int opt_idx;
	private String opt_name;
	
	public OptionVO() {
		
	}
	
	public OptionVO(int idx, int opt_idx, String opt_name) {
		super();
		this.idx = idx;
		this.opt_idx = opt_idx;
		this.opt_name = opt_name;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getOpt_idx() {
		return opt_idx;
	}

	public void setOpt_idx(int opt_idx) {
		this.opt_idx = opt_idx;
	}

	public String getOpt_name() {
		return opt_name;
	}

	public void setOpt_name(String opt_name) {
		this.opt_name = opt_name;
	}
	
	
}
