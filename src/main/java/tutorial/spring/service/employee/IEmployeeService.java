package tutorial.spring.service.employee;

import tutorial.spring.model.Branch;
import tutorial.spring.model.Employee;
import tutorial.spring.service.IGeneralService;

public interface IEmployeeService extends IGeneralService<Employee> {
    Iterable<Employee> findAllByBranch(Branch branch);
    Iterable<Employee> findAllByOrderByAgeAsc();
}
