package com.example.graphql.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.model.Pokemon;
import com.example.graphql.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokemonQuery implements GraphQLQueryResolver {

  @Autowired
  private PokemonRepository repository;

  public Pokemon getPokemon(Long id) {
    return repository.findById(id).orElse(null);
  }
}