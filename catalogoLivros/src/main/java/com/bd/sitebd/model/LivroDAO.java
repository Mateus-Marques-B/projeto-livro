package com.bd.sitebd.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class LivroDAO {
    //DAO = Data Acssess Object 

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserir(Livro li){
        String sql = "INSERT INTO livro(titulo, autor, genero, ano) VALUES (?,?,?,?);";
        Object[] parametros = new Object[4];
        parametros[0] = li.getTitulo();
        parametros[1] = li.getAutor();
        parametros[2] = li.getGenero();
        parametros[3] = li.getAno();
        jdbc.update(sql,parametros);

    }

    public List<Map<String,Object>> obterTodosLivros(){
        String sql = "Select * from livro;";
        return jdbc.queryForList(sql);
    }

    public void atualizarLivro(int id, Livro li){
        String sql = "UPDATE livro SET ";
        sql += "titulo = ?, autor = ?, genero = ?, ano = ? WHERE id = ?";
        jdbc.update(sql, li.getTitulo(), li.getAutor(), li.getGenero(), li.getAno(), id);
    }

    public Livro obterLivro(int id){
        String sql = "Select * from livro where id = ?";
        return Tool.converterLivro(jdbc.queryForMap(sql,id));
    }

    public void deletarLivro(int id){
        String sql = "DELETE FROM livro where id = ?";
        jdbc.update(sql,id);
    }


}
