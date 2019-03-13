package br.com.teste.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teste.empresa.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
