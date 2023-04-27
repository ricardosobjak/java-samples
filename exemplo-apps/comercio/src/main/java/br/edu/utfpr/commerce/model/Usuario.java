package br.edu.utfpr.commerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario extends PessoaFisica {

    @Column(name = "usuario", length = 30, unique = true, nullable = false)
    private String usuario;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipo;

    public Usuario() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }
}
