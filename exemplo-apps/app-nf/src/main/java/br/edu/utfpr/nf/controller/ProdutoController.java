package br.edu.utfpr.nf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @GetMapping
    public void getProdutos() {

    }

    @GetMapping("/{id}")
    public void getProduto(@PathVariable Long id) {
        System.out.println(id);
    }
    

}
