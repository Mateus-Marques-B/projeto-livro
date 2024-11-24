package com.bd.sitebd.model;

public class Livro {
    
    private int id, ano;
    private String titulo, autor, genero;

    //sobrecarga para tela de cadastro
    public Livro(){
        
    }

    //Sobrecarga dos construtores Livro
    public Livro(int id, String titulo, String autor, String genero, int ano) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.ano = ano;
    }

    //para inserir registro
    public Livro( String titulo, String autor, String genero, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.ano = ano;
    }    

    public int getId(){
        return id;
      }
      public void setId(int id) {
        this.id = id;
      }
    
      public String getTitulo(){
        return titulo;
      }
      public void setTitulo(String titulo) {
        this.titulo = titulo;
      }
    
      public String getAutor(){
        return autor;
      }
      public void setAutor(String autor){
        this.autor = autor;
      }
    
      public String getGenero(){
        return genero;
      }
      public void setGenero(String genero){
        this.genero = genero;
      }
    
      public int getAno(){
        return ano;
      }
      public void setAno(int ano){
        this.ano = ano;
      }
}