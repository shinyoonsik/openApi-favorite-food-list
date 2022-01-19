package com.example.restaurent.db_local_test;

import java.util.List;
import java.util.Optional;

public interface MemoryDbRepositoryIfs<T>{

  Optional<T> findById(int index); // <T> 제네릭
  T save(T entity);
  void deleteById(int index);
  List<T> findAll();
}
