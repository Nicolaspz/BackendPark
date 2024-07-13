package com.park.tdo;

public class LoginRequestDTO {
	  private String telefone;
	    private String password;

	   

	    public LoginRequestDTO() {
	    }

	    public LoginRequestDTO(String telefone, String password) {
	        this.telefone = telefone;
	        this.password = password;
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
}
