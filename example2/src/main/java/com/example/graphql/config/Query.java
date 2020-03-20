package com.example.graphql.config;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.graphql.dao.PostDao;
import com.example.graphql.model.Post;
import java.util.List;
import org.springframework.context.annotation.Configuration;

public class Query implements GraphQLQueryResolver {
  private PostDao postDao;

  public Query(PostDao postDao) {
    this.postDao = postDao;
  }

  public List<Post> getRecentPosts(int count, int offset) {
    return postDao.getRecentPosts(count, offset);
  }
}
