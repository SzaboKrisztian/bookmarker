package com.krisztianszabo.bookmarker;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends CrudRepository<Link, Integer> {
  List<Link> findAllByOrderByIdAsc();
}
