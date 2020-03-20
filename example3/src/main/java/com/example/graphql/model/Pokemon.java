package com.example.graphql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {

  public Pokemon(final Long id, final String name) {
    this.id = id;
    this.name = name;
  }

  @Id
  public Long id;

  @Column
  public String name;
}