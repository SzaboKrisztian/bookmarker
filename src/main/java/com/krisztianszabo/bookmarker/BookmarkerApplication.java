package com.krisztianszabo.bookmarker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BookmarkerApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(BookmarkerApplication.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(BookmarkerApplication.class);
  }
}
