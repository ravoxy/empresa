package br.com.teste.empresa.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.teste.empresa.model.Empresa;
import br.com.teste.empresa.model.Situacao;
import br.com.teste.empresa.model.Usuario;
import br.com.teste.empresa.model.UsuarioEmpresa;
import br.com.teste.empresa.repository.EmpresaRepository;
import br.com.teste.empresa.repository.UsuarioEmpresaRepository;
import br.com.teste.empresa.repository.UsuarioRepository;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private UsuarioEmpresaRepository usuarioEmpresaRepository;

    @Transactional
    public void salvar(Usuario usuario, Long idEmpresa) {
        usuario.setVersion(LocalDateTime.now());
        Usuario novoUsuario = usuarioRepository.saveAndFlush(usuario);
        UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
        usuarioEmpresa.setEmpresa(empresaRepository.getOne(idEmpresa));
        usuarioEmpresa.setUsuario(novoUsuario);
        usuarioEmpresa.setSituacao(Situacao.ATIVO);
        usuarioEmpresa.setVersion(LocalDateTime.now());
        usuarioEmpresa.setUltimologon(LocalDateTime.now());
        usuarioEmpresaRepository.save(usuarioEmpresa);
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public List<Situacao> situacoes() {
        return Arrays.asList(Situacao.values());
    }

    public List<Empresa> empresas() {
        return empresaRepository.findAll();
    }

}
