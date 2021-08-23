package tutorial.spring.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tutorial.spring.model.Branch;
import tutorial.spring.model.Employee;

@Repository
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    Iterable<Employee> findAllByBranch(Branch branch);
    Iterable<Employee> findAllByOrderByAgeAsc();
}
