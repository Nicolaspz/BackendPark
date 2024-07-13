package com.park.domain;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Entrada_Saida implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String placa;
	private LocalDateTime tempo_entrada;
	private LocalDateTime tempo_saida;
	private boolean status;
	
	@ManyToOne
	@JoinColumn
	private Vaga vaga;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Ticket tiket;
	
	@Override
	public int hashCode() {
		return Objects.hash(Id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada_Saida other = (Entrada_Saida) obj;
		return Objects.equals(Id, other.Id);
	}

	

	public Entrada_Saida() {
		super();
	}

	public Entrada_Saida(String placa, LocalDateTime tempo_entrada, boolean status, Vaga vaga) {
		super();
		
		this.placa = placa;
		this.tempo_entrada = tempo_entrada;
		this.status = status;
		this.vaga = vaga;
		
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

	public LocalDateTime getTempo_entrada() {
		return tempo_entrada;
	}

	public void setTempo_entrada(LocalDateTime tempo_entrada) {
		this.tempo_entrada = tempo_entrada;
	}

	public LocalDateTime getTempo_saida() {
		return tempo_saida;
	}

	public void setTempo_saida(LocalDateTime tempo_saida) {
		this.tempo_saida = tempo_saida;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
	

}
