package br.com.teste.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.empresa.model.UsuarioEmpresa;

public interface UsuarioEmpresaRepository extends JpaRepository<UsuarioEmpresa, Long> {
}
