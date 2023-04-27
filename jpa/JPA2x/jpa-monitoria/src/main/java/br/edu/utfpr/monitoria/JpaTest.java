package br.edu.utfpr.monitoria;


import br.edu.utfpr.monitoria.model.Disciplina;
import br.edu.utfpr.monitoria.model.ProcessoSeletivo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JpaTest {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SamplesJpaPU");
        EntityManager manager = factory.createEntityManager();
        
        // Persistindo Alunos
        manager.getTransaction().begin();
        manager.persist(AlunoFactory.getInstance().create());
        manager.persist(AlunoFactory.getInstance().create());
        manager.getTransaction().commit();
        
        // Persistindo Disciplina
        manager.getTransaction().begin();
        Disciplina disc1 = DisciplinaFactory.getInstance().create();
        manager.persist(disc1);
        manager.getTransaction().commit();
        
        // Persistindo o ProcessoSeletivo
        manager.getTransaction().begin();
        ProcessoSeletivo ps1 = ProcessoSeletivoFactory.getInstance().create();
        ps1.getAreas().get(0).getDisciplinas().add(disc1); // Setando a disciplina na area1
        manager.persist(ps1);
        manager.getTransaction().commit();
        
    }


}
