package com.park.tdo;

public class ResponseDTO {

	private Integer id;
	private String nome;
    private String role;
    private String token;


    public ResponseDTO(String nome,  Integer id, String role,String token) {
		super();
		this.nome = nome;
		this.id = id;
		this.role = role;
		this.token = token;
	}

	public ResponseDTO() {
    }

    

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
	
}
