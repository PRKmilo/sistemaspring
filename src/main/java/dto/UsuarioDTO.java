package dto;


public class UsuarioDTO {
    private Long id;
    private String nombreUsuario;
    private Long[] roles;

    public UsuarioDTO(Long id, String nombreUsuario, Long[] roles){
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Long[] getRoles() {
        return roles;
    }

    public void setRoles(Long[] roles) {
        this.roles = roles;
    }


}