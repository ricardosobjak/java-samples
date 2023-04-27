import br.edu.utfpr.jpa.dao.PessoaDAO;
import br.edu.utfpr.jpa.model.Pessoa;
import java.security.NoSuchAlgorithmException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class JpaTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public JpaTest() {
    }

    @BeforeClass
    public static void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("SamplesJpaPU");

        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterClass
    public static void tearDown() {
        entityManager.close();
        entityManagerFactory.close();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void test1_insertPessoaSemDAO() {
        EntityTransaction tx = entityManager.getTransaction();

        Pessoa p = entityManager.find(Pessoa.class, 1);
        if (p == null) {
            p = criarPessoa("Jacó", "jaco@gmail.com", "jaco", "1234", "00000000000", "4599999999", 1, true);

            tx.begin();
            entityManager.persist(p);
            tx.commit();
        }
    }

    @Test
    public void test2_insertPessoaComDAO() {
        PessoaDAO dao = new PessoaDAO(entityManager);
        Pessoa p = criarPessoa("José", "jose@gmail.com", "jose", "1234", "00000000000", "4599999999", 1, true);
        
        entityManager.getTransaction().begin();
        dao.save(p);
        entityManager.getTransaction().commit();
    }

    @Test
    public void test3_listarPessoas() {
        PessoaDAO dao = new PessoaDAO(entityManager);

        System.out.println(dao.findAll());
    }

    public static Pessoa criarPessoa(String nome, String email, String login, String senha, String cpf, String telefone, int papel, boolean ativo) {
        Pessoa u = new Pessoa();

        u.setNome(nome);
        u.setAtivo(ativo);
        u.setEmail(email);
        u.setLogin(login);
        u.setPapel(papel);
        u.setCpf(cpf);
        try {
            u.setPassword(senha);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        u.setTelefone(telefone);

        return u;
    }
}