package net.ChangeWithMe.SpringBootWebApp.Repository;

import net.ChangeWithMe.SpringBootWebApp.Entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
