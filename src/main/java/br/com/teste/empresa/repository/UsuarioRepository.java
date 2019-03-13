package br.com.teste.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.empresa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
