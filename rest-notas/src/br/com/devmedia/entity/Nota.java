package br.com.devmedia.entity;

public class Nota {
  private static int sequence = 0;
  private int id;
  private String titulo;
  private String descricao;
  
  
  
  public Nota(int id, String titulo, String descricao) {
    this.id = sequence++;
    this.titulo = titulo;
    this.descricao = descricao;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getTitulo() {
    return titulo;
  }
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
  public String getDescricao() {
    return descricao;
  }
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  
  
}
