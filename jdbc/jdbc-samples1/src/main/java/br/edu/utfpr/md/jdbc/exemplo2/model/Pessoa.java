package br.edu.utfpr.md.jdbc.exemplo2.model;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Pessoa implements Serializable {

    private Long id;
    private String login;
    private String md5Password;
    private String nome;

    private int papel;
    private String email;

    private String telefone;

    private boolean ativo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Pessoa() {
    }

    public Pessoa(Long userId, String login, String nome) {
        this();
        this.id = userId;
        this.login = login;
        this.nome = nome;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID=" + id);
        sb.append(", ");
        sb.append("Nome=" + nome);
        sb.append(", ");
        sb.append("Login=" + login);
        sb.append(", ");
        sb.append("Senha MD5=" + md5Password);
        sb.append(", ");
        sb.append("Ativo=" + ativo);
        sb.append(", ");
        sb.append("E-mail=" + email);
        sb.append(", ");
        sb.append("Telefone=" + telefone);
        sb.append(", ");
        sb.append("Papel=" + papel);

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.id == null) {
            return false;
        }
        Pessoa u = (Pessoa) obj;
        return this.id.equals(u.id);
    }
}
