package br.edu.utfpr.nf.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "tb_produto")
@NamedQueries({
    @NamedQuery(name = "Produto.count", query = "SELECT COUNT(p) FROM Produto p"),
    @NamedQuery(name = "Produto.nome", query = "SELECT p FROM Produto p WHERE p.nome LIKE :nome"),
    @NamedQuery(name = "Produto.categoria", query = "SELECT p FROM Produto p WHERE p.categoria.nome LIKE :nome"),
})
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao")
    @Lob
    @Basic(fetch = FetchType.EAGER)
    private String descricao;

    @Column(name = "unidade_medida", nullable = false)
    private String unidadeMedida;

    @Column(name = "percentual_ipi")
    private Float percentualIpi;

    @Column(name = "valor_unitario")
    private Float valorUnitario;

    @Column(name = "peso_liquido")
    private Float pesoLiquido;

    @Column(name = "peso_bruto")
    private Float pesoBruto;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "produto", targetEntity = Estoque.class, fetch = FetchType.LAZY)
    private List<Estoque> estoques = new ArrayList<>();

    public Produto() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public Float getPercentualIpi() {
        return percentualIpi;
    }

    public void setPercentualIpi(Float percentualIpi) {
        this.percentualIpi = percentualIpi;
    }

    public Float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Float getPesoLiquido() {
        return this.pesoLiquido;
    }

    public void setPesoLiquido(Float pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public Float getPesoBruto() {
        return this.pesoBruto;
    }

    public void setPesoBruto(Float pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Estoque> getEstoques() {
        return estoques;
    }

    public void setEstoques(List<Estoque> estoques) {
        this.estoques = estoques;
    }

}
