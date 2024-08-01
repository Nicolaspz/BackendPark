package com.park.tdo;

import java.time.LocalDateTime;

public class ReservaDTO {
    private Integer id;
    private String status;
    private String statusPagamento;
    private Integer userId;
    private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
    private Integer vagaId;
    private String veiculo;
    private Double valor;
    private String metodoPagamento;

   

    public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getStatusPagamento() {
		return statusPagamento;
	}



	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}



	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
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



	public Integer getVagaId() {
		return vagaId;
	}



	public void setVagaId(Integer vagaId) {
		this.vagaId = vagaId;
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



	public ReservaDTO(Integer id, String status, String statusPagamento, Integer userId, LocalDateTime dataInicio,
                      LocalDateTime dataTermino, Integer vagaId, String veiculo, Double valor, String metodoPagamento) {
        this.id = id;
        this.status = status;
        this.statusPagamento = statusPagamento;
        this.userId = userId;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.vagaId = vagaId;
        this.veiculo = veiculo;
        this.valor = valor;
        this.metodoPagamento = metodoPagamento;
    }

    // Getters e Setters aqui
}
