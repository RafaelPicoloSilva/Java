/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estoque.model;

/**
 *
 * @author FEF
 */
public class Produto {
    private int idProduto;
    private String nomeProduto;
    private double ultimoPrecoPago;
    private double saldoAtual;
    private TipoProduto tipoProduto;
    private UnidadeMedida unidadeMedida;

    public Produto(int idProduto, String nomeProduto, double ultimoPrecoPago, double saldoAtual, TipoProduto tipoProduto, UnidadeMedida unidadeMedida) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.ultimoPrecoPago = ultimoPrecoPago;
        this.saldoAtual = saldoAtual;
        this.tipoProduto = tipoProduto;
        this.unidadeMedida = unidadeMedida;
    }

    public Produto() {
        this.idProduto = 0;
        this.nomeProduto = "";
        this.ultimoPrecoPago = 0;
        this.saldoAtual = 0;
        this.tipoProduto = new TipoProduto();
        this.unidadeMedida = new UnidadeMedida();
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getUltimoPrecoPago() {
        return ultimoPrecoPago;
    }

    public void setUltimoPrecoPago(double ultimoPrecoPago) {
        this.ultimoPrecoPago = ultimoPrecoPago;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }
    
    
}
