package com.park.domain;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Status_Pagamento statusPagamento;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;

    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;

    private String veiculo;
    private Double valor;
    private String metodoPagamento;
    

    public Reserva() {
        super();
    }

    public Reserva(Integer id, Status status, Status_Pagamento statusPagamento, User user, LocalDateTime dataInicio,
                   LocalDateTime dataTermino, Vaga vaga, String veiculo, Double valor,
                   String metodoPagamento) {
        super();
        this.id = id;
        this.status = status;
        this.statusPagamento = statusPagamento;
        this.user = user;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.vaga = vaga;
        this.veiculo = veiculo;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
       
    }

    

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Status_Pagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setStatusPagamento(Status_Pagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDateTime dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga= vaga;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
        Reserva other = (Reserva) obj;
        return Objects.equals(id, other.id);
    }
}
