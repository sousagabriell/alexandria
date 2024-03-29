package br.com.alexandria.biblioteca.repository;

import br.com.alexandria.biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
	public Optional<Usuario> findByUsuario(String usuario);
	public Optional<Usuario> findById(Long id);
}
