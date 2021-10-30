package net.ChangeWithMe.SpringBootWebApp.Repository;

import net.ChangeWithMe.SpringBootWebApp.Entity.AssignTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignTaskRepository extends JpaRepository<AssignTask, Long> {
}
