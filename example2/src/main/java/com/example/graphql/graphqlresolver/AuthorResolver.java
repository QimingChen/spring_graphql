package com.example.graphql.graphqlresolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphql.dao.PostDao;
import com.example.graphql.model.Author;
import com.example.graphql.model.Post;
import java.util.List;

public class AuthorResolver implements GraphQLResolver<Author> {
  private PostDao postDao;

  public AuthorResolver(PostDao postDao) {
    this.postDao = postDao;
  }

  public List<Post> getPosts(Author author) {
    return postDao.getAuthorPosts(author.getId());
  }
}