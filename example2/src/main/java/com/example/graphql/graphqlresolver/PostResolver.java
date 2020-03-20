package com.example.graphql.graphqlresolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.dao.AuthorDao;
import com.example.graphql.model.Author;
import com.example.graphql.model.Post;
import java.util.Optional;

public class PostResolver implements GraphQLResolver<Post> {
  private AuthorDao authorDao;

  public PostResolver(AuthorDao authorDao) {
    this.authorDao = authorDao;
  }

  public Optional<Author> getAuthor(Post post) {
    return authorDao.getAuthor(post.getAuthorId());
  }
}