package br.edu.utfpr.monitoria;

import br.edu.utfpr.monitoria.model.Area;
import br.edu.utfpr.monitoria.model.Disciplina;
import br.edu.utfpr.monitoria.model.ProcessoSeletivo;
import java.util.Calendar;

public class ProcessoSeletivoFactory extends Factory<ProcessoSeletivo> {
    private static final ProcessoSeletivoFactory INSTANCE = new ProcessoSeletivoFactory();
    
    private static int cont = 0;
    
    private ProcessoSeletivoFactory() { }
    
    public static ProcessoSeletivoFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public ProcessoSeletivo create() {
        ProcessoSeletivo ps = new ProcessoSeletivo();
        
        Calendar d1 = Calendar.getInstance();
        Calendar d2 = Calendar.getInstance();
        d1.set(2016, 11, 1);
        d2.set(2016, 11, 30);
        
        ps.setDataAbertura(d1);
        ps.setDataEncerramento(d2);
        ps.setEdital("Edital " + ++cont);
        
       
        Area a1 = new Area();
        a1.setArea("Computação: programação");
        a1.setProcessoSeletivo(ps);
        a1.setVagas(2);
        
        ps.getAreas().add(a1);
        
        return ps;
    }    
}
