package dto;

public class UsuarioDTO {
    private String nombreUsuario;
    private Long idRol;
    private String nombreRol;
    
    public UsuarioDTO(String nombreUsuario, Long idRol, String nombreRol) {
        this.nombreUsuario = nombreUsuario;
        this.idRol = idRol;
        this.nombreRol = nombreRol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

}