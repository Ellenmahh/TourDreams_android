package br.com.tourdreams.app;

/**
 * Created by Ellen on 17/10/2017.
 */

public class Parceiro {
    private String nome;
    private String donoDoHotel;
    private int imagem;
    public Parceiro(String nome, String donoDoHotel, int imagem) {
        this.nome = nome;
        this.donoDoHotel = donoDoHotel;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDonoDoHotel() {
        return donoDoHotel;
    }

    public void setDonoDoHotel(String donoDoHotel) {
        this.donoDoHotel = donoDoHotel;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}
