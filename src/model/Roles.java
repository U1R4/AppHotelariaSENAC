package model;

public class Roles {
    private int id;
    private String nome;

    public Roles(String nome) {
        this.nome = nome;
    }

    public int id() {return id;}
    public String nome() {return nome;}

    public void setId(int id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
}
