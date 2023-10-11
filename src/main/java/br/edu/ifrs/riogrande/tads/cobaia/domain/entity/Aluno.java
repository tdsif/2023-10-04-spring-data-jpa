package br.edu.ifrs.riogrande.tads.cobaia.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

// POJO: Plain Old Java Object (o velho e bom objeto java)

@Table(name = "alunos")
@Entity
public class Aluno { // orm.xml

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer matricula;
  
  @JsonProperty("nomeCompleto")
  @Column(length = 100, nullable = false, unique = true)
  private String nome;

  @JsonIgnore // não vai para o payload ("não vira json")
  @Column(length = 11, nullable = false, unique = true)
  private String cpf;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Integer getMatricula() {
    return matricula;
  }

  public void setMatricula(Integer matricula) {
    this.matricula = matricula;
  }

  public String getNome() {
    return nome;
  }
  
  public void setNome(String nome) {
    this.nome = nome;
  }

  // Builder "preguiçoso"
  public Aluno withMatricula(Integer matricula) {
    this.setMatricula(matricula);
    return this;
  }

  public Aluno withNome(String nome) {
    this.setNome(nome);
    return this;
  }

  @Override
  public String toString() {
    return "Aluno [matricula=" + matricula + ", nome=" + nome + ", cpf=" + cpf + "]";
  }
  
  
}
