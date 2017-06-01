package br.edu.utfpr.monitoria.model;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa_aluno")
public class Aluno extends Pessoa {
    @ManyToMany
    @JoinTable(name = "tb_curso_aluno")
    private ArrayList<Curso> cursos = new ArrayList<>();

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "Aluno{" + "cursos=" + cursos + '}';
    }    
}
