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


@Entity
public class Vaga implements Serializable {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code_vaga;
	private boolean status;
	private boolean previlegio;
	
	@OneToMany(mappedBy = "vaga")
	List<Entrada_Saida> Entrada_Saida= new ArrayList<>();
	
	public Vaga(Integer id, String code_vaga, boolean status, boolean previlegio) {
		super();
		this.id = id;
		this.code_vaga = code_vaga;
		this.status = status;
		this.previlegio = previlegio;
	}


	public Vaga() {
		super();
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


	public List<Entrada_Saida> getEntrada_Saida() {
		return Entrada_Saida;
	}


	public void setEntrada_Saida(List<Entrada_Saida> entrada_Saida) {
		Entrada_Saida = entrada_Saida;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vaga other = (Vaga) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
