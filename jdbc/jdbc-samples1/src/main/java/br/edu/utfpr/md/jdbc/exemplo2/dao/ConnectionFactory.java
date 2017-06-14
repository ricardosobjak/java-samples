package br.edu.utfpr.md.jdbc.exemplo2.dao;

//estabelece a conex�o com o SGBD.
import java.sql.DriverManager;
//permite conectar ao bando de dados.
import java.sql.Connection;
//executa comandos contra o banco de dados.
import java.sql.Statement;
//executa comandos contra o banco de dados.
import java.sql.PreparedStatement;
//possibilita a recupera��o dos valores buscados no banco de dados.
import java.sql.ResultSet;
//permite mostra valores num�ricos formatados de acordo com um determinado padr�o.
import java.text.NumberFormat;
//exce��o lan�ada pelos m�todos da API JDBC.
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
public class ConnectionFactory {
    // a 'string' que define o driver a ser utilizado, depende do SGBD Derby

    public final static String DRIVER_DERBY = "org.apache.derby.jdbc.EmbeddedDriver";
    public final static String DRIVER_MYSQL = "com.mysql.jdbc.Driver";

    public static Connection createConnection(String driver, String url, String usuario, String senha) throws ClassNotFoundException, SQLException {

        System.out.println("Criando uma conexao ao SGBD");
        System.out.println("Driver............: " + driver);
        System.out.println("URL de conexao....: " + url);
        if (usuario != null) {
            System.out.println("Usuario...........: " + usuario);
        }
        if (senha != null) {
            System.out.println("Senha.............: " + senha);
        }
        System.out.println();

        // carrega o driver JDBC. Caso o driver n�o seja encontrado
        // (possivelmente
        // o arquivo .JAR n�o est� listado na vari�vel CLASSPATH.
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw e;
        }

        // Estabelece uma conex�o com o driver rec�m-carregado.
        // O m�todo "getConnection()" eh sobrecarregado tal que ele pode ser
        // invocado em 1 de 3 possibilidades:
        // . getConnection(String url):
        // somente a localiza��o do banco de dados. Neste caso, nao h�
        // usu�rio nem senha,
        // . getConnection(String url, String usuario, String senha):
        // alem da 'string' de conex�o com o BD, passa-se o c�digo do usu�rio
        // e sua senha, e
        // . getConnection(String url, Properties dados):
        // juntamente com a 'string' de conex�o com o BD, passa-se um objeto
        // do tipo "java.util.Properties" contendo informa��es para a conex�o.
        return DriverManager.getConnection(url, usuario, senha);

    }

}
