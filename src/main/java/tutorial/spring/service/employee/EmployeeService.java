package tutorial.spring.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutorial.spring.model.Branch;
import tutorial.spring.model.Employee;
import tutorial.spring.repository.IEmployeeRepository;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    IEmployeeRepository employeeRepository;
    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Iterable<Employee> findAllByBranch(Branch branch) {
        return employeeRepository.findAllByBranch(branch);
    }

    @Override
    public Iterable<Employee> findAllByOrderByAgeAsc() {
        return employeeRepository.findAllByOrderByAgeAsc();
    }

}
