package br.edu.utfpr.monitoria;

import br.edu.utfpr.monitoria.model.Disciplina;

public class DisciplinaFactory extends Factory<Disciplina> {

    private static final DisciplinaFactory INSTANCE = new DisciplinaFactory();

    private static int cont = 0;

    private DisciplinaFactory() {
    }

    public static DisciplinaFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public Disciplina create() {
        Disciplina d = new Disciplina();
        d.setNome("Disciplina " + cont);
        return d;
    }
}
