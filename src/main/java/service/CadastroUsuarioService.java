package service;

import model.Usuario;
import repository.Usuarios;
import util.Transacional;

import javax.inject.Inject;
import java.io.Serializable;

public class CadastroUsuarioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuarios usuarios;
	
	@Transacional
	public void salvar(Usuario usuario) {
		usuarios.guardar(usuario);
	}
	
	@Transacional
	public void excluir(Usuario usuario) {
		usuarios.remover(usuario);
	}

}