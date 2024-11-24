package com.bd.sitebd.model;

import java.util.Map;

public class Tool {

    public static Livro converterLivro(Map<String,Object> registro){
        return new Livro((Integer) registro.get("id")
                          ,(String) registro.get("titulo")
                          ,(String) registro.get("autor")
                          ,(String) registro.get("genero")
                          ,(Integer) registro.get("ano"));
    }

}
