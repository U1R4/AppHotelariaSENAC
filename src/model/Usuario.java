package model;

public class Usuario{

    private int id, role_id;
    private String nome,email,senha;

    public Usuario(int role_id, String nome, String email, String senha) {
        this.role_id = role_id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public int id() {return id;}
    public int role_id() {return role_id;}
    public String nome() {return nome;}
    public String email() {return email;}
    public String senha() {return senha;}

    public void setId(int id) {this.id = id;}
    public void setRole_id(int role_id) {this.role_id = role_id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setEmail(String email) {this.email = email;}
    public void setSenha(String senha) {this.senha = senha;}
}
