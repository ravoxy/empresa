package br.com.teste.empresa.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.teste.empresa.model.Empresa;
import br.com.teste.empresa.model.Situacao;
import br.com.teste.empresa.model.Usuario;
import br.com.teste.empresa.service.UsuarioService;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    private static final String CADASTRO_VIEW = "CadastroUsuario";

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject(new Usuario());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(Usuario usuario, String empresa) {
        usuarioService.salvar(usuario, Long.valueOf(empresa));
        return "redirect:/usuarios";
    }

    @RequestMapping
    public ModelAndView pesquisar() {
        ModelAndView mv = new ModelAndView("PesquisaUsuarios");
        List<Usuario> todosUsuarios = usuarioService.listarTodos();
        mv.addObject("usuarios", todosUsuarios);
        return mv;
    }

    @RequestMapping("{codigo}")
    public ModelAndView editar(@PathVariable("codigo") Usuario usuario) {
        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject(usuario);
        return mv;
    }

    @RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
    public String excluir(@PathVariable Long codigo) {
        usuarioService.deletar(codigo);
        return "redirect:/usuarios";
    }

    @ModelAttribute("situacoes")
    public List<Situacao> situacoes() {
        return Arrays.asList(Situacao.values());
    }

    @ModelAttribute("empresas")
    public List<Empresa> empresas() {
        return usuarioService.empresas();
    }

}
