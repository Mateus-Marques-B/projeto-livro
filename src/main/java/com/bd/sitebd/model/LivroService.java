package com.bd.sitebd.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    
    @Autowired
    LivroDAO ldao;

    public void inserir(Livro li){
        ldao.inserir(li);
    }

    public List<Map<String,Object>> obterTodosLivros(){
        return ldao.obterTodosLivros();
    }

    public void atualizarLivro(int id, Livro li){
        ldao.atualizarLivro(id, li);
    }

    public Livro obterLivro(int id){
        return ldao.obterLivro(id);
    }

    public void deletarLivro(int id){
        ldao.deletarLivro(id);
    }

    
}
