package com.park.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reserva implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private Status status;
	private Status_Pagamento status_pag;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Reserva() {
		super();
	}
	public Reserva(Integer id, Status status, Status_Pagamento status_pag, User user) {
		super();
		Id = id;
		this.status = status;
		this.status_pag = status_pag;
		this.user = user;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Status_Pagamento getStatus_pag() {
		return status_pag;
	}
	public void setStatus_pag(Status_Pagamento status_pag) {
		this.status_pag = status_pag;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
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
		Reserva other = (Reserva) obj;
		return Objects.equals(Id, other.Id);
	}
	
}
