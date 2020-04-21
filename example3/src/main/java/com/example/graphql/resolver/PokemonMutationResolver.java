package com.example.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.model.CreatePokemonInput;
import com.example.graphql.model.Pokemon;
import com.example.graphql.repository.PokemonRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PokemonMutationResolver implements GraphQLMutationResolver {

  @Autowired
  private PokemonRepository pokemonRepository;

  @Transactional
  public Pokemon createPokemon(CreatePokemonInput input) {
    return pokemonRepository.save(new Pokemon(input.getId(), input.getName()));
  }
}
