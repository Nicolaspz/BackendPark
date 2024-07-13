package com.park.tdo;

public class RegisterRequestDTO {
	private String telefone;
    private String password;
    private String name;

    // Construtores, getters e setters

    public RegisterRequestDTO() {
    }

    public RegisterRequestDTO(String telefone, String password, String name) {
        this.telefone = telefone;
        this.password = password;
        this.name = name;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
