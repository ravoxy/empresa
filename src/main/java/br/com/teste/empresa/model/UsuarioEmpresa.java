package br.com.teste.empresa.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "usuarioEmpresa")
public class UsuarioEmpresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_empresa_seq")
    @SequenceGenerator(name = "usuario_empresa_seq", sequenceName = "usuario_empresa_seq")
    private Long idUsuarioEmpresa;

    private LocalDateTime version;

    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private Situacao situacao;

    private LocalDateTime ultimologon;

    public Long getIdUsuarioEmpresa() {
        return idUsuarioEmpresa;
    }

    public void setIdUsuarioEmpresa(Long idUsuarioEmpresa) {
        this.idUsuarioEmpresa = idUsuarioEmpresa;
    }

    public LocalDateTime getVersion() {
        return version;
    }

    public void setVersion(LocalDateTime version) {
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

    public LocalDateTime getUltimologon() {
        return ultimologon;
    }

    public void setUltimologon(LocalDateTime ultimologon) {
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
