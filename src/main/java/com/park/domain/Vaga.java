package com.park.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
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
	private String codeVaga;
	private boolean oucupado;
	private boolean previlegio;
	
	 @Column(nullable = false)
	 private boolean reservado = false;
	
	public boolean isReservado() {
		return reservado;
	}


	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}


	@OneToMany(mappedBy = "vaga")
	List<Entrada_Saida> Entrada_Saida= new ArrayList<>();
	
	@OneToMany(mappedBy = "vaga")
	List<Reserva> reserva= new ArrayList<>();
	
	public Vaga(Integer id, String codeVaga, boolean oucupado, boolean previlegio) {
		super();
		this.id = id;
		this.codeVaga = codeVaga;
		this.oucupado = oucupado;
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


	public String getCodeVaga() {
		return codeVaga;
	}


	public void setCodeVaga(String code_vaga) {
		this.codeVaga = code_vaga;
	}


	public boolean isOucupado() {
		return oucupado;
	}


	public void setOucupado(boolean oucupado) {
		this.oucupado = oucupado;
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
