package br.edu.utfpr.monitoria.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_processoseletivo")
public class ProcessoSeletivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String edital;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataAbertura;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataEncerramento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "processoSeletivo", targetEntity = Area.class)
    private List<Area> areas = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEdital() {
        return edital;
    }

    public void setEdital(String edital) {
        this.edital = edital;
    }

    public Calendar getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Calendar dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Calendar getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(Calendar dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    @Override
    public String toString() {
        return "ProcessoSeletivo{" + "id=" + id + ", edital=" + edital + ", dataAbertura=" + dataAbertura + ", dataEncerramento=" + dataEncerramento + ", areas=" + areas + '}';
    }
}
