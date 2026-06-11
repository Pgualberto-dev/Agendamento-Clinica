package entities;

public abstract class Pessoa {

    protected Integer id;
    protected String nome;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract String getDocumento();

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}
