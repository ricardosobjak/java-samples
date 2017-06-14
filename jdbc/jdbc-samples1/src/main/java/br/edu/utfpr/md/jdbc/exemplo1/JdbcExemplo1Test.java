package br.edu.utfpr.md.jdbc.exemplo1;

// estabelece a conexão com o SGBD.
import java.sql.DriverManager;
// permite conectar ao bando de dados.
import java.sql.Connection;
// executa comandos contra o banco de dados.
import java.sql.Statement;
// executa comandos contra o banco de dados.
import java.sql.PreparedStatement;
// possibilita a recupera��o dos valores buscados no banco de dados.
import java.sql.ResultSet;

// exce��o lançada pelos métodos da API JDBC.
import java.sql.SQLException;

/**
 * Esta classe exemplifica opera��es b�sicas de acesso a banco de dados por meio
 * do uso da API JDBC.
 *
 * A API JDBC disponibiliza um conjunto de interfaces que s�o implementadas por
 * desenvolvedores de SGBDs (Sistemas Gerenciadores de Bancos de Dados).
 *
 * As interfaces as serem utilizadas por aplica��es Java devem ser importadas
 * dos pacotes "java.sql.*" e, para funcionalidades avan�adas, "javax.sql.*"
 * Tais interfaces s�o: - Connection : permite a conex�o com o SGBD (local ou
 * remoto), - Statement : executa instru��es SQL contra o BD, -
 * PreparedStatement: executa instru��es SQL parametrizadas, e - ResultSet :
 * possui um conjunto de m�todos "getters" para a obten��o dos dos dados
 * retornados por uma instru��o SELECT. Estes m�todos devem ser utilizados de
 * acordo com o tipo de dado do valor a ser recuperado.
 *
 * A diferen�a entre "Statement" e "PreparedStatement" reside no fato de a
 * segunda enviar ao SDBD a instrucao SQL a ser executada, antes que esta seja
 * realmente executada, para fins de otimiza��o, bem como seu uso � mais
 * recomendado a instru��es que sejam executadas v�rias vezes.
 *
 * Com exce��o do m�todo que carrega o driver JDBC, todos os metodos das
 * interfaces, descritas acima, lan�am a exce��o "SQLException", que deve ser
 * capturada ou re-lancada.
 *
 * Existem dois m�todos que podem ser utilizados para executar comandos contra
 * uma ou mais tabelas: . executeQuery() => utilizado para o comando DML
 * "select"; . executeUpdate() => utilizado para os comandos DML "insert",
 * "update" e "delete". H� um terceiro m�todo "execute()". Este m�todo permite a
 * execu��o dos comandos DML sem distin��o de quais s�o.
 */
public class JdbcExemplo1Test {

    private String _driver = "com.mysql.jdbc.Driver";
    private String _url = "jdbc:mysql://localhost:3306/test";
    private String _usuario = "root";
    private String _senha = "";

    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rset;


    
    public JdbcExemplo1Test() {
        System.out.println("Conectando ao SGBD...");
        System.out.println("Driver............: " + _driver);
        System.out.println("URL de conexao....: " + _url);
        if (_usuario != null) {
            System.out.println("Usuario...........: " + _usuario);
        }
        if (_senha != null) {
            System.out.println("Senha.............: " + _senha);
        }
        System.out.println();

        // carrega o driver JDBC. Caso o driver nao seja encontrado (possivelmente
        // o arquivo .JAR não está listado na variavel CLASSPATH.
        try {
            Class.forName(_driver);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }

        // Estabelece uma conexao com o driver recem-carregado.
        // O m�todo "getConnection()" eh sobrecarregado tal que ele pode ser
        // invocado em 1 de 3 possibilidades:
        // . getConnection(String url):
        //   somente a localiza��o do banco de dados. Neste caso, nao h�
        //   usu�rio nem senha,
        // . getConnection(String url, String usuario, String senha):
        //   alem da 'string' de conex�o com o BD, passa-se o c�digo do usu�rio
        //   e sua senha, e
        // . getConnection(String url, Properties dados):
        //   juntamente com a 'string' de conex�o com o BD, passa-se um objeto
        //   do tipo "java.util.Properties" contendo informa��es para a conex�o.
        conn = null;
        try {
            conn = DriverManager.getConnection(_url, _usuario, _senha);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    } // public Jdbc1(String[])

    public void criarTabelas() {
        try {
            conn.setAutoCommit(false);
            Statement s = conn.createStatement();

            String SQL_CREATE = "CREATE TABLE EMPREGADO ("
                    + "id INTEGER NOT NULL AUTO_INCREMENT, "
                    + "nome VARCHAR(50) NOT NULL, "
                    + "salario float, "
                    + "PRIMARY KEY (id) "
                    + ")";

            s.execute(SQL_CREATE);

            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    /**
     * O metodo a seguir obtém (seleciona) um conjunto de registros da tabela
     * 'EMPREGADO'. Neste caso, todos (indicado pelo * - asterisco) os registros
     * serao selecionados . a sintaxe, b�sica, para a instru��o SELECT �: select
     * * | <COLUNA_1>, <COLUNA_2>, ..., <COLUNA_N>
     * from <TABELA_1> <ALIAS_1>, ..., <TABELA_N> <ALIAS_N>
     * where <CONDICAO>
     *
     * Uma vez que o m�todo "executeQuery()" seja executado, este retornar� um
     * objeto "ResultSet". Com este objeto � poss�vel 'navegar' pelos registro
     * recuperados. � importante observar que o m�todo "next()", deve ser
     * chamado antes que uma tentativa de acessar os dados seja feita. Somente
     * assim o primeiro registro ser� disponibilizado.
     *
     * � poss�vel, ao desenvolvedor, re-lan�ar a exce��o "SQLException" ao inv�s
     * de trat�-la no m�todo que utiliza as interfaces da API JDBC.
     */
    public void listar() {
        try {
            // estabelece a conexão com o banco de dados.
            stmt = conn.createStatement();

            // executa o comando desejado.
            rset = stmt.executeQuery("select * from EMPREGADO");
            System.out.println("Listando...");

            // isto é necessário para que o primeiro registro torne-se disponível.
            while (rset.next()) {
                int codigo = rset.getInt("id");
                String nome = rset.getString("nome");
                double salario = rset.getDouble("salario");

                System.out.println(codigo + " " + nome + " " + salario);
            }

            // ao final do processamento, a conex�o com a tabela é fechada.
            rset.close();

            // ao final do processamento, a conexão com o banco de dados é fechada.
            stmt.close();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    /**
     * O método a seguir inclui um novo registro na tabela 'EMPREGADO'. A
     * sintaxe para a instrução INSERT é: insert into <NOME_TABELA> (
     * <COLUNA_1>, <COLUNA_2>, ..., <COLUNA_N> ) values ( <VALOR_1>, <VALOR_2>,
     * ..., <VALOR_N> )
     *
     * Este método demonstra a possibilidade de o desenvolvedor re-lançar uma
     * exceção de BD ao invés de tratá-la localmente.
     */
    private int incluirDados(String nome, float salario) throws SQLException {
        System.out.println("Incluindo...");
        stmt = conn.createStatement();
        int res = stmt.executeUpdate("insert into EMPREGADO (nome, salario) values ('"+nome+"', "+salario+");", Statement.RETURN_GENERATED_KEYS);
        
        int id = -1; // Cria um id inválido
        
        // Obtendo o ID gerado automaticamente pelo banco
        rset = stmt.getGeneratedKeys();
        if (rset.next())
            id = rset.getInt(1);
        
        stmt.close();
        
        return id;
    }

    /**
     * Método para alterar dados na tabela 'EMPREGADO'. A sintaxe para a
     * instrução UPDATE é: update <NOME_TABELA> <CAMPO_1> = <VALOR_1>, ...,
     * <CAMPO_N> = <VALOR_N>
     * where <CONDICAO>
     * Se a clausula 'where' for omitida, todos os registros da tabela ser�o
     * alterados.
     */
    public void alterar(int id) throws SQLException {
        System.out.println("Alterando...");
        stmt = conn.createStatement();
        stmt.executeUpdate("update EMPREGADO set salario = 1.0 where id = " + id);
        stmt.close();
    }

    /**
     * Metodo para excluir dados na tabela 'EMPREGADO'. A sintaxe para a
     * instrução DELETE é: delete from <NOME_TABELA> where <CONDICAO>
     * Se a clausula 'where' for omitida, todos os registros da tabela serão
     * excluídos.
     */
    public void excluir1() throws SQLException {
        System.out.println("Excluindo 1...");

        stmt = conn.createStatement();
        stmt.executeUpdate("delete from EMPREGADO where salario = 1.0");
        stmt.close();

    }

    /**
     * Metodo que exclui todos os empregados cujo nome combina com o fornecido.
     */
    public void excluir2() throws SQLException {
        System.out.println("Excluindo 2...");

        pstmt = conn.prepareStatement("delete from EMPREGADO where nome = ?");
        pstmt.setString(1, "Carlota Joaquina");
        pstmt.executeUpdate();
        pstmt.close();

    }

    public static void main(String[] args) {
        JdbcExemplo1Test jdbc1 = new JdbcExemplo1Test();

        //jdbc1.criarTabelas();
        
        jdbc1.listar();

        System.out.println("***************************************************");
        
        int idInserido = 0;
        try {
            idInserido = jdbc1.incluirDados("Juca de Abreu", 3200);
            jdbc1.incluirDados("Carlota Joaquina", 2200);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        System.out.println("***************************************************");
        
        jdbc1.listar();
        
        System.out.println("***************************************************");
        
        try {
            jdbc1.alterar(idInserido);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        System.out.println("***************************************************");
        
        jdbc1.listar();
        
        System.out.println("***************************************************");
        
        try {
            jdbc1.excluir1();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        System.out.println("***************************************************");
        
        jdbc1.listar();
        
        System.out.println("***************************************************");
        
        try {
            jdbc1.excluir2();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        System.out.println("***************************************************");
       
        jdbc1.listar();
    }
}
