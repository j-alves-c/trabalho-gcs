package dominio;

public class Administrador extends Usuario {
    private boolean permissaoAdministrador;

    public boolean getPermissaoAdministrador() {
        return permissaoAdministrador;
    }

    public void setPermissaoAdministrador(boolean permissaoAdministrador) {
        this.permissaoAdministrador = permissaoAdministrador;
    }

}