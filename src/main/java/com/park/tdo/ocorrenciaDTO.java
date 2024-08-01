package com.park.tdo;

import com.park.domain.User;

public class ocorrenciaDTO {

	private Integer Id;
	private String placa;
	private String descricao;
	
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public ocorrenciaDTO(Integer Id,String placa, String descricao) {
		super();
		this.placa = placa;
		this.descricao = descricao;
		this.Id=Id;
		
		
	}
	
	
}
