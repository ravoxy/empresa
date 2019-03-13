package br.com.teste.empresa.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.teste.empresa.model.Situacao;
import br.com.teste.empresa.model.Usuario;
import br.com.teste.empresa.repository.UsuarioRepository;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
    private static final String CADASTRO_VIEW = "CadastroUsuario";

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
        mv.addObject(new Usuario());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Usuario usuario, Errors errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            return "CadastroUsuario";
        }

        usuarioRepository.save(usuario);
        attributes.addFlashAttribute("mensagem", "Usuario salvo com sucesso!");
        return "redirect:/usuarioRepository/novo";
    }

    @RequestMapping
    public ModelAndView pesquisar() {
        ModelAndView mv = new ModelAndView("PesquisaUsuarios");
        List<Usuario> todosUsuarios = usuarioRepository.findAll();
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
    public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
        usuarioRepository.deleteById(codigo);
        attributes.addFlashAttribute("mensagem", "Usuario excluido com sucesso!");
        return "redirect:/usuarioRepository";
    }

    @ModelAttribute("totasSituacoes")
    public List<Situacao> todosStatusUsuarios() {
        return Arrays.asList(Situacao.values());
    }


}
