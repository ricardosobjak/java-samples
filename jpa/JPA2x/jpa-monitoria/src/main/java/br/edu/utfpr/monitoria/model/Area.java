package br.edu.utfpr.monitoria.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_processoseletivo_area")
public class Area implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String area;

    private int vagas;

    @OneToMany(mappedBy = "area", targetEntity = Inscricao.class)
    private List<Inscricao> inscricoes = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.DETACH, targetEntity = Disciplina.class)
    @JoinTable(name = "tb_processoseletivo_area_disciplina")
    private List<Disciplina> disciplinas = new ArrayList<>();
    
    @ManyToOne(optional = false)
    private ProcessoSeletivo processoSeletivo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void setInscricoes(List<Inscricao> inscricoes) {
        this.inscricoes = inscricoes;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public ProcessoSeletivo getProcessoSeletivo() {
        return processoSeletivo;
    }

    public void setProcessoSeletivo(ProcessoSeletivo processoSeletivo) {
        this.processoSeletivo = processoSeletivo;
    }

    @Override
    public String toString() {
        return "Area{" + "id=" + id + ", area=" + area + ", vagas=" + vagas + ", inscricoes=" + inscricoes + ", disciplinas=" + disciplinas + ", processoSeletivo=" + processoSeletivo + '}';
    }
    
}
