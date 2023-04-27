package br.edu.utfpr.nf.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_nota_fiscal")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "chave_acesso")
    private String chaveAcesso;

    @Column(name = "data_emissao")
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataEmissao;

    @Column(name = "numero")
    private String numero;

    @Column(name = "data_saida")
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dataSaida;

    @Column(name = "valor_frete")
    private float valorFrete;

    @Column(name = "valor_seguro")
    private float valorSeguro;

    @Column(name = "valor_desconto")
    private float valorDesconto;

    @Column(name = "valor_outras_despesas")
    private float valorOutrasDespesas;

    @Column(name = "observacao")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "filial_id")
    private Filial filial;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @ManyToMany
    @JoinTable(name = "tb_nota_fiscal_itens",
            joinColumns = @JoinColumn(name = "notafiscal_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> itens = new ArrayList<>();

    public NotaFiscal() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChaveAcesso() {
        return chaveAcesso;
    }

    public void setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public float getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(float valorFrete) {
        this.valorFrete = valorFrete;
    }

    public float getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(float valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public float getValorOutrasDespesas() {
        return valorOutrasDespesas;
    }

    public void setValorOutrasDespesas(float valorOutrasDespesas) {
        this.valorOutrasDespesas = valorOutrasDespesas;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Produto> getItens() {
        return itens;
    }

    public void setItens(List<Produto> itens) {
        this.itens = itens;
    }

}
