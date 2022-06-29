package com.idat.EC2KINTSONREATEGUI.DTO;

public class UsuariosDTOResponse {

	private Integer idUsuario;
    private String usuario;
    private String password;
    private String rol;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UsuariosDTOResponse(String token) {
        super();
        this.token = token;
    }

    public UsuariosDTOResponse() {
        super();
        // TODO Auto-generated constructor stub
    }
}
