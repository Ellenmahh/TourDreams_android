package br.com.tourdreams.app;

/**
 * Created by 15251365 on 28/09/2017.
 */

public class DadosQuarto {
    private String nome;
    private double preco;
    private Caracteristicas[] caracteristicas ;
    private String[] imagens;

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

    public Caracteristicas[] getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicases(Caracteristicas[] caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String[] getImagens() {
        return imagens;
    }

    public void setImagens(String[] imagens) {
        this.imagens = imagens;
    }
}
