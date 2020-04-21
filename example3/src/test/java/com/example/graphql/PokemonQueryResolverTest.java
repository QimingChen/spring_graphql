package com.example.graphql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.graphql.model.Pokemon;
import com.example.graphql.repository.PokemonRepository;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import java.io.IOException;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@GraphQLTest
public class PokemonQueryResolverTest {

	@Autowired
	private GraphQLTestTemplate graphQLTestTemplate;

	@MockBean
	private PokemonRepository pokemonRepository;

	@Test
	public void getPokemonById_Success() throws IOException {
		Pokemon pokemon = new Pokemon(1, "Pikachu");
		when(pokemonRepository.findById(any()))
				.thenReturn(Optional.of(pokemon));

		GraphQLResponse response =
				graphQLTestTemplate.postForResource("get-pokemon-by-id.graphql");

		System.out.println(response.getRawResponse().toString());

		assertTrue(response.isOk());
		assertEquals("1", response.get("$.data.pokemon.id"));
		assertEquals("Pikachu", response.get("$.data.pokemon.name"));
	}
}
