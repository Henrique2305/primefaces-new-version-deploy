package repository;

import model.Usuario;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public Usuarios() {

	}

	public Usuarios(EntityManager manager) {
		this.manager = manager;
	}

	public Usuario porId(Long id) {
		return manager.find(Usuario.class, id);
	}
	
	public List<Usuario> todas() {
         return manager.createQuery("from Usuario", Usuario.class).getResultList();
    }

	public Usuario guardar(Usuario usuario) {
		return manager.merge(usuario);
	}

	public void remover(Usuario usuario) {
		usuario = porId(usuario.getId());
		manager.remove(usuario);
	}
}