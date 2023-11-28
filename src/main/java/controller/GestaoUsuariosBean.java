package controller;

import model.Endereco;
import model.Usuario;
import repository.Usuarios;
import service.CadastroUsuarioService;
import util.UsuarioConverter;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class GestaoUsuariosBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private Usuarios usuarios;
    
    @Inject
    private CadastroUsuarioService cadastroUsuarioService;
    
    private List<Usuario> listaUsuarios;
    
    private Usuario  usuario = new Usuario(new Endereco());

    public void prepararEdicao(Usuario usuario) {
        this.usuario = usuario;
    }

    public void  salvar() {
        cadastroUsuarioService.salvar(usuario);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Usuário editado com sucesso"));
    }
    
    public void excluir(Usuario usuario) {
        cadastroUsuarioService.excluir(usuario);
    }

    public void resetUsuario() {
        this.usuario = new Usuario(new Endereco());
    }
    
    public void todosUsuarios() {
        listaUsuarios = usuarios.todas();
    }
    
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public boolean isUsuarioSeleciona() {
        return usuario != null && usuario.getId() != null;
    }
}