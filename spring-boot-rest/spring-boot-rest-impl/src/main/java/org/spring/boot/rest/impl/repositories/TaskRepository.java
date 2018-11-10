package org.spring.boot.rest.impl.repositories;

import org.spring.boot.rest.impl.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
