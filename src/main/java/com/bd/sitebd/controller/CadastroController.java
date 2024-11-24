package com.bd.sitebd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bd.sitebd.model.Livro;
import com.bd.sitebd.model.LivroService;
import com.bd.sitebd.model.Tool;


@Controller
public class CadastroController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/") 
    public String Principal(){
        return "principal"; 
    }
    
    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        Livro livro = new Livro("", "", "", 0); // Novo livro
        model.addAttribute("livro", livro);
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(Model model, @ModelAttribute Livro li){
        LivroService ls = context.getBean(LivroService.class);
        ls.inserir(li);
        return "sucesso";
    }

    @GetMapping("/atualizar/{id}")
    public String atualizar(Model model, @PathVariable int id) {
        LivroService ls = context.getBean(LivroService.class);
        Livro li = ls.obterLivro(id);
        model.addAttribute("id", id);
        model.addAttribute("livro", li);
        return "atualizar";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Livro li){
        LivroService ls = context.getBean(LivroService.class);
        ls.atualizarLivro(id, li);
        return "redirect:/listagem";
    }

    
    @GetMapping("/listagem")
    public String listagem(Model model){
        LivroService ls = context.getBean(LivroService.class);
        List<Map<String,Object>> lista = ls.obterTodosLivros();
        List<Livro> listaLivros = new ArrayList<Livro>();
        for(Map<String,Object> registro : lista){
            listaLivros.add(Tool.converterLivro(registro));
        }
        model.addAttribute("livros", listaLivros);
        return "listagem";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable int id){
        LivroService ls = context.getBean(LivroService.class);
        ls.deletarLivro(id);
        return "redirect:/listagem";
    }

}