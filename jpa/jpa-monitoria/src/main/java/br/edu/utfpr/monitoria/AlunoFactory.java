package br.edu.utfpr.monitoria;

import br.edu.utfpr.monitoria.model.Aluno;
import java.util.Calendar;

public class AlunoFactory extends Factory<Aluno> {
    private static final AlunoFactory INSTANCE = new AlunoFactory();
    
    private static int cont = 0;
    
    private AlunoFactory() { }
    
    public static AlunoFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public Aluno create() {
        Aluno a = new Aluno();
        a.setNome("Aluno " + ++cont);
        a.setCpf("123456789" + cont);
        a.setNascimento(Calendar.getInstance());
        a.setRegistroInstitucional("000" + cont);
        return a;
    }    
}
