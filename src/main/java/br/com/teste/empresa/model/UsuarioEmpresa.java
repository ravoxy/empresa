package br.com.teste.empresa.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emprUsuarioEmpresaesa")
public class UsuarioEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarioEmpresa;

    private LocalDate version;

    private Empresa empresa;

    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    private LocalDate ultimologon;

    public Long getIdUsuarioEmpresa() {
        return idUsuarioEmpresa;
    }

    public void setIdUsuarioEmpresa(Long idUsuarioEmpresa) {
        this.idUsuarioEmpresa = idUsuarioEmpresa;
    }

    public LocalDate getVersion() {
        return version;
    }

    public void setVersion(LocalDate version) {
        this.version = version;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    public LocalDate getUltimologon() {
        return ultimologon;
    }

    public void setUltimologon(LocalDate ultimologon) {
        this.ultimologon = ultimologon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioEmpresa)) return false;

        UsuarioEmpresa that = (UsuarioEmpresa) o;

        return idUsuarioEmpresa.equals(that.idUsuarioEmpresa);
    }

    @Override
    public int hashCode() {
        return idUsuarioEmpresa.hashCode();
    }
}
