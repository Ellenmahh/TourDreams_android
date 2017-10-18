package br.com.tourdreams.app;

/**
 * Created by 15251365 on 28/09/2017.
 */

public class DadosQuarto {
    private String nome;
    private double preco;
    // private Caracteristicas[] caracteristicas ;
    private String caracteristicas;
    private  Integer imagens;
    public DadosQuarto(String nome, double preco, String caracteristicas,  Integer imagens) {
        this.nome = nome;
        this.preco = preco;
        this.caracteristicas = caracteristicas;
        this.imagens = imagens;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicases(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Integer getImagens() {
        return imagens;
    }

    public void setImagens(Integer imagens) {
        this.imagens = imagens;
    }
}
