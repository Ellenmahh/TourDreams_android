package br.com.tourdreams.app;

/**
 * Created by Ellen on 07/10/2017.
 */

public class Hotel {
    private String nome;
    private double preco;
    private String local;
    private int imagem;

    //construtor da classe
    public Hotel(String nome, double preco, String local, int imagem){
        this.nome = nome;
        this.preco = preco;
        this.local = local;
        this.imagem = imagem;

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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
