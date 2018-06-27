package com.github.project.repository;

import com.github.project.model.AnotherService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnotherServiceRepository extends JpaRepository<AnotherService, Long> {
}
