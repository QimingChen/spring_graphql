package com.example.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.model.Pokemon;
import com.example.graphql.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokemonQueryResolver implements GraphQLQueryResolver {

  @Autowired
  private PokemonRepository repository;

  public Pokemon getPokemon(Integer id) {
    return repository.findById(id).orElse(null);
  }
}
