package com.park.tdo;

public class ResponseVaga {
	private Integer id;
	private String code_vaga;
	private boolean oucupado;
	private boolean previlegio;
	private boolean reservado;
	
	
	
	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}

	public ResponseVaga(Integer id, String code_vaga, boolean oucupado, boolean previlegio,boolean reservado) {
		super();
		this.id = id;
		this.code_vaga = code_vaga;
		this.oucupado = oucupado;
		this.previlegio = previlegio;
		this.reservado = reservado;
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
	public boolean isOucupado() {
		return oucupado;
	}
	public void setOucupado(boolean status) {
		this.oucupado = status;
	}
	public boolean isPrevilegio() {
		return previlegio;
	}
	public void setPrevilegio(boolean previlegio) {
		this.previlegio = previlegio;
	}
}
