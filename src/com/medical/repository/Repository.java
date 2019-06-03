package com.medical.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    Optional<T> findById(Long var1);

    List<T> getAll();

    Long put(T var1);

    List<Long> putAll(List<T> var1);
}
