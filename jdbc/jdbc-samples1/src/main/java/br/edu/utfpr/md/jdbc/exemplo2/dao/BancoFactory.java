package br.edu.utfpr.md.jdbc.exemplo2.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoFactory {

    private Connection conn;

    public BancoFactory(Connection conn) {
        this.conn = conn;
    }

    public void criarTabelas() throws SQLException {
        try {
            conn.setAutoCommit(false);
            Statement s = conn.createStatement();

            s.execute(PessoaDAO.TABLE.SQL_CREATE);
            System.out.println(PessoaDAO.TABLE.SQL_CREATE);

            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

    public void destruirTabelas() throws SQLException {
        try {
            conn.setAutoCommit(false);
            Statement s = conn.createStatement();

            s.execute("DROP TABLE if exists tb_pessoa");

            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        }
    }

}
