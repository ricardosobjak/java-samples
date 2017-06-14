package br.edu.utfpr.md.jdbc.exemplo2;

import br.edu.utfpr.md.jdbc.exemplo2.dao.BancoFactory;
import br.edu.utfpr.md.jdbc.exemplo2.dao.ConnectionFactory;
import br.edu.utfpr.md.jdbc.exemplo2.dao.PessoaDAO;
import br.edu.utfpr.md.jdbc.exemplo2.model.Pessoa;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

public class AppExemplo2Test {

    Connection _conn;

    public AppExemplo2Test() {
        try {
            //_conn = ConnectionFactory.createConnection(ConnectionFactory.DRIVER_DERBY, "jdbc:derby:db_teste;create=true", "test", "test");
            _conn = ConnectionFactory.createConnection(ConnectionFactory.DRIVER_MYSQL, "jdbc:mysql://localhost:3306/test", "root", "");
/*
            BancoFactory bancoFactory = new BancoFactory(_conn);
            
            try {
                bancoFactory.destruirTabelas();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            bancoFactory.criarTabelas();
            */
            PessoaDAO dao = new PessoaDAO(_conn);

            Pessoa p = inserirPessoa(dao, "Jaco", "jaco@gmail.com", "jaco", "1234", "4599999999", 1, true);

            System.out.println(p);

            mostrarPessoas(dao.buscaTodosUsingRowSet());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Pessoa inserirPessoa(PessoaDAO dao, String nome, String email, String login, String senha, String telefone, int papel, boolean ativo) {
        Pessoa u = new Pessoa();
        u.setNome(nome);
        u.setAtivo(ativo);
        u.setEmail(email);
        u.setLogin(login);
        u.setPapel(papel);
        try {
            u.setPassword(senha);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        u.setTelefone(telefone);

        if (dao.insere(u)) {
            return u;
        }

        return null;
    }

    public void mostrarPessoas(Collection<Pessoa> pes) {
        for (Pessoa p : pes) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        new AppExemplo2Test();
    }

}
