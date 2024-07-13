package com.park.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Ticket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String placa;
	private Integer tempo ;
	private double preco;
	
	@OneToOne(mappedBy = "tiket")
	private Entrada_Saida entrada_saida;
	
	public Entrada_Saida getEntrada_saida() {
		return entrada_saida;
	}

	public void setEntrada_saida(Entrada_Saida entrada_saida) {
		this.entrada_saida = entrada_saida;
	}

	public Ticket() {
		super();
	}

	public Ticket(Integer id, String placa, Integer tempo, double preco, Entrada_Saida entrada_Saida) {
		super();
		this.id = id;
		this.placa = placa;
		this.tempo = tempo;
		this.preco = preco;
		this.entrada_saida=entrada_Saida;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
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
		Ticket other = (Ticket) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
