package br.edu.utfpr.jpa.model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    private String login;

    private String md5Password;

    private int papel;

    private String email;

    private String telefone;

    //@Column(columnDefinition="integer")
    private boolean ativo;

    public Pessoa() {
    }

    public Pessoa(Integer userId, String login, String nome) {
        this();
        this.id = userId;
        this.login = login;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMd5Password(String md5Password) {
        this.md5Password = md5Password;
    }

    public String getMd5Password() {
        return md5Password;
    }

    public void setPassword(String password) throws NoSuchAlgorithmException {

        // Create MessageDigest instance for MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        // Add password bytes to digest
        md.update(password.getBytes());
        // Get the hash's bytes
        byte[] bytes = md.digest();
        // This bytes[] has bytes in decimal format;
        // Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        // Get complete hashed password in hex format
        this.md5Password = sb.toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPapel() {
        return papel;
    }

    public void setPapel(int papel) {
        this.papel = papel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", login=" + login + ", md5Password=" + md5Password + ", papel=" + papel + ", email=" + email + ", telefone=" + telefone + ", ativo=" + ativo + '}';
    }
}
