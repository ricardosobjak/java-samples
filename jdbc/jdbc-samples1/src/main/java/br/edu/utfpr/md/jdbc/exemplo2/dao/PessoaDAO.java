package br.edu.utfpr.md.jdbc.exemplo2.dao;

import br.edu.utfpr.md.jdbc.exemplo2.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.RowSet;
import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;

import com.sun.rowset.JdbcRowSetImpl;

public class PessoaDAO extends AbstractDAO<Pessoa> {

    public class TABLE {

        static final String NOME = "tb_pessoa";

        class COLUMN {

            static final String ID = "id";
            static final String NOME = "nome";
            static final String LOGIN = "login";
            static final String SENHA = "senha";
            static final String EMAIL = "email";
            static final String TELEFONE = "telefone";
            static final String PAPEL = "papel";
            static final String ATIVO = "ativo";
        }

        static final String SQL_CREATE = "CREATE TABLE if not exists " + NOME + " ("
                //+ COLUMN.ID + " INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + COLUMN.ID + " INTEGER NOT NULL AUTO_INCREMENT, "
                + COLUMN.NOME + " VARCHAR(50) NOT NULL, "
                + COLUMN.LOGIN + " VARCHAR(20), "
                + COLUMN.SENHA + " VARCHAR(100), "
                + COLUMN.EMAIL + " VARCHAR(100), "
                + COLUMN.PAPEL + " INTEGER NOT NULL, "
                + COLUMN.TELEFONE + " VARCHAR(20), "
                + COLUMN.ATIVO + " INTEGER, "
                + "PRIMARY KEY (" + COLUMN.ID + ") "
                //+ "CONSTRAINT primary_key PRIMARY KEY (" + COLUMN.ID + ") "
                + ")";

    }

    public PessoaDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean insere(Pessoa t) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(TABLE.NOME);
        sb.append(" ( ");
        sb.append(TABLE.COLUMN.NOME + ", ");
        sb.append(TABLE.COLUMN.LOGIN + ", ");
        sb.append(TABLE.COLUMN.SENHA + ", ");
        sb.append(TABLE.COLUMN.EMAIL + ", ");
        sb.append(TABLE.COLUMN.PAPEL + ", ");
        sb.append(TABLE.COLUMN.TELEFONE + ", ");
        sb.append(TABLE.COLUMN.ATIVO);
        sb.append(" ) values (?,?,?,?,?,?,?)");

        Logger.getLogger("current.package").info(sb.toString());

        try (PreparedStatement ps = _conn.prepareStatement(sb.toString());) {

            _conn.setAutoCommit(false);

            ps.setString(1, t.getNome());
            ps.setString(2, t.getLogin());
            ps.setString(3, t.getMd5Password());
            ps.setString(4, t.getEmail());
            ps.setInt(5, t.getPapel());
            ps.setString(6, t.getTelefone());
            ps.setInt(7, t.isAtivo() ? 1 : 0);

            if (ps.executeUpdate() > 0) {
                _conn.commit();
                return true;
            }
        } catch (SQLException e) {
            Logger.getLogger("current.package").log(Level.SEVERE, "Erro ao inserir Pessoa", e);
        }

        return false;
    }

    @Override
    public boolean update(Pessoa t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean remove(Pessoa t) {
        String sql = "DELETE FROM " + TABLE.NOME + " WHERE " + TABLE.COLUMN.ID + " = ?";

        try (PreparedStatement ps = _conn.prepareStatement(sql);) {
            ps.setLong(1, t.getId());

            if (ps.executeUpdate() != 0) {
                _conn.commit();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Pessoa buscaId(Object id) {
        String query = "SELECT * FROM " + TABLE.NOME + " WHERE " + TABLE.COLUMN.ID + " = " + id;

        try (PreparedStatement statement = _conn.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();) {

            if (resultSet.next()) {
                return resultSetToObject(resultSet);
            }

        } catch (SQLException e) {
            Logger.getLogger("current.package").log(Level.SEVERE, "Erro ao buscar Pessoas", e);
        }

        return null;
    }

    protected Pessoa resultSetToObject(ResultSet rs) throws SQLException {
        Pessoa p = new Pessoa();
        p.setId(rs.getLong(TABLE.COLUMN.ID));
        p.setNome(rs.getString(TABLE.COLUMN.NOME));
        p.setLogin(rs.getString(TABLE.COLUMN.LOGIN));
        p.setMd5Password(rs.getString(TABLE.COLUMN.SENHA));
        p.setTelefone(rs.getString(TABLE.COLUMN.TELEFONE));
        p.setPapel(rs.getInt(TABLE.COLUMN.PAPEL));
        p.setAtivo((rs.getInt(TABLE.COLUMN.ATIVO) != 0 ? true : false));

        return p;
    }

    @Override
    public Collection<Pessoa> buscaTodos() {
        String query = "SELECT * FROM " + TABLE.NOME;

        List<Pessoa> pessoas = new ArrayList<>();

        try (PreparedStatement statement = _conn.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();) {

            while (resultSet.next()) {
                pessoas.add(resultSetToObject(resultSet));
            }

        } catch (SQLException e) {
            Logger.getLogger("current.package").log(Level.SEVERE, "Erro ao buscar Pessoas", e);
        }

        return pessoas;
    }

    public Collection<Pessoa> buscaTodosUsingRowSet() {
        String query = "SELECT * FROM " + TABLE.NOME;

        List<Pessoa> pessoas = new ArrayList<>();

        try (JdbcRowSet jdbcRowSet = new JdbcRowSetImpl(_conn);) {
            jdbcRowSet.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
            jdbcRowSet.setCommand(query);
            jdbcRowSet.execute();
            jdbcRowSet.addRowSetListener(new ExampleListener());

            while (!jdbcRowSet.isLast()) {
                jdbcRowSet.next();
                pessoas.add(resultSetToObject(jdbcRowSet));
            }
        } catch (SQLException e) {
            Logger.getLogger("current.package").log(Level.SEVERE, "Erro ao buscar Pessoas", e);
        }

        return pessoas;
    }
}

class ExampleListener implements RowSetListener {

    public void cursorMoved(RowSetEvent event) {
        System.out.println("ExampleListener notified of cursorMoved event");
        System.out.println(event.getSource());
        RowSet r = (RowSet) event.getSource();
        try {
            System.out.println(r.getString(1));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void rowChanged(RowSetEvent event) {
        System.out.println("ExampleListener notified of rowChanged event");
        System.out.println(event.toString());
    }

    public void rowSetChanged(RowSetEvent event) {
        System.out.println("ExampleListener notified of rowSetChanged event");
        System.out.println(event.toString());
    }
}
