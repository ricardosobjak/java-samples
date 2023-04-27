package br.edu.utfpr.commerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Calendar;

/**
 * Conta a Receber.
 * 
 * @author Sobjak
 */
@Entity
@Table(name = "tb_conta_receber")
public class ContaReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "numero_parcela")
    private Integer numeroParcela;
    
    @Column(name = "total_parcelas")
    private Integer totalParcelas;
    
    @Column(name = "data_emissao")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataEmissao;
    
    @Column(name = "data_vencimento")
    @Temporal(TemporalType.DATE)
    private Calendar dataVencimento;
    
    @Column(name = "valor")
    private float valor;
    
    @Column(name = "data_pagamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataPagamento;

    @ManyToOne
    @JoinColumn(name = "filial_id")
    private Filial filial;

    @ManyToOne
    @JoinColumn(name = "nota_fiscal_id")
    private NotaFiscal notaFiscal;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    public ContaReceber() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(Integer numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public Integer getTotalParcelas() {
        return totalParcelas;
    }

    public void setTotalParcelas(Integer totalParcelas) {
        this.totalParcelas = totalParcelas;
    }

    public Calendar getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Calendar dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Calendar getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Calendar dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}