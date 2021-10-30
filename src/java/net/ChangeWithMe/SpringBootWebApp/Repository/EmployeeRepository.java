package net.ChangeWithMe.SpringBootWebApp.Repository;

import net.ChangeWithMe.SpringBootWebApp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT * FROM employee where id=:id", nativeQuery = true)
    Employee getEmployeeById(int id);

    @Query(value = "SELECT \n" +
            "    e.*\n" +
            "FROM\n" +
            "    employee e\n" +
            "WHERE\n" +
            "    e.id IN (SELECT \n" +
            "            direct_manager\n" +
            "        FROM\n" +
            "            employee\n" +
            "        WHERE\n" +
            "            id=:id);", nativeQuery = true)
    Employee getManagerByEmployeeId(int id);

}

