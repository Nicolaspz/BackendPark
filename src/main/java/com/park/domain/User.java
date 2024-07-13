package com.park.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "users")
public class User implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String telefone;
	private String senha;
	private Role role;
	
	@OneToMany(mappedBy = "user")
	List<Reserva> reserva = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	List<Ocorrencia> ocorrencia= new ArrayList<>();
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public User() {
		super();
	}

	public User(Integer id, String nome, String telefone, String senha, Role role) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.senha = senha;
		this.role = role;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	public List<Ocorrencia> getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(List<Ocorrencia> ocorrencia) {
		this.ocorrencia = ocorrencia;
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

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	
	
	
}
