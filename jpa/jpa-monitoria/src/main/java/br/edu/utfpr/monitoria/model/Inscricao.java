package br.edu.utfpr.monitoria.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_processoseletivo_inscricao")
public class Inscricao implements Serializable {

    @Id
    private long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data;

    private boolean homologada;

    @ManyToOne(optional = false, targetEntity = Area.class)
    private Area area;

    @ManyToOne(optional = false, targetEntity = Aluno.class)
    private Aluno aluno;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public boolean isHomologada() {
        return homologada;
    }

    public void setHomologada(boolean homologada) {
        this.homologada = homologada;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "Inscricao{" + "id=" + id + ", data=" + data + ", homologada=" + homologada + ", area=" + area + ", aluno=" + aluno + '}';
    }
}
