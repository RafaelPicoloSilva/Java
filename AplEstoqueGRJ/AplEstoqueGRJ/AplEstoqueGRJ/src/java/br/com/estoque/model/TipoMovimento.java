/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.estoque.model;

/**
 *
 * @author FEF
 */
public class TipoMovimento {
    private int idTipoMovimento;
    private String descricao;

    public TipoMovimento(int idTipoMovimento, String descricao) {
        this.idTipoMovimento = idTipoMovimento;
        this.descricao = descricao;
    }

    public TipoMovimento() {
        this.idTipoMovimento = 0;
        this.descricao = "";
    }

    public int getIdTipoMovimento() {
        return idTipoMovimento;
    }

    public void setIdTipoMovimento(int idTipoMovimento) {
        this.idTipoMovimento = idTipoMovimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
