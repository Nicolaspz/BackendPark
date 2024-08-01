package com.park.tdo;

import com.park.domain.Role;

public class userDTO {
	private String nome;
	private String telefone;
	private String senha;
	private Role role;
	private Integer id;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public userDTO(String nome, String telefone, Role role, Integer id) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.role = role;
		this.id = id;
	}
	

}
