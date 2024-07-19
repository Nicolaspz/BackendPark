package com.park.tdo;

public class ResponseVaga {
	private Integer id;
	private String code_vaga;
	private boolean status;
	private boolean previlegio;
	
	
	
	public ResponseVaga(Integer id, String code_vaga, boolean status, boolean previlegio) {
		super();
		this.id = id;
		this.code_vaga = code_vaga;
		this.status = status;
		this.previlegio = previlegio;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode_vaga() {
		return code_vaga;
	}
	public void setCode_vaga(String code_vaga) {
		this.code_vaga = code_vaga;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isPrevilegio() {
		return previlegio;
	}
	public void setPrevilegio(boolean previlegio) {
		this.previlegio = previlegio;
	}
}
