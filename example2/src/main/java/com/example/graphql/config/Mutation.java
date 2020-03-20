package com.example.graphql.config;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphql.dao.PostDao;
import com.example.graphql.model.Post;
import java.util.UUID;

public class Mutation implements GraphQLMutationResolver {

  private PostDao postDao;

  public Mutation(PostDao postDao) {
    this.postDao = postDao;
  }

  public Post writePost(String title, String text, String category, String author) {
    Post post = new Post();
    post.setId(UUID.randomUUID().toString());
    post.setTitle(title);
    post.setText(text);
    post.setCategory(category);
    post.setAuthorId(author);
    postDao.savePost(post);

    return post;
  }
}
