package com.backend.repository;

import com.backend.entity.Checkbook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckbookRepository extends JpaRepository<Checkbook, Long> {
}
