package tutorial.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tutorial.spring.model.Branch;
import tutorial.spring.model.Employee;
import tutorial.spring.service.branch.IBranchService;
import tutorial.spring.service.employee.IEmployeeService;

import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IBranchService branchService;

    @ModelAttribute("branchs")
    public Iterable<Branch> findAll() {
        return branchService.findAll();
    }

    @GetMapping("/")
    public ModelAndView showEmployee(@RequestParam Optional<Branch> branch) {
        ModelAndView modelAndView = new ModelAndView("employee/show");
        Iterable<Employee> employees;
        if (branch.isPresent()) {
            employees = employeeService.findAllByBranch(branch.get());
        } else {
            employees = employeeService.findAll();
        }
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/create-employee")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("message", false);
        return modelAndView;
    }

    @PostMapping("/create-employee")
    public ModelAndView createEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("message", true);
        return modelAndView;
    }

    @GetMapping("/edit-employee")
    public ModelAndView showEditForm(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        modelAndView.addObject("employee", employeeService.findById(id).get());
        modelAndView.addObject("message", false);
        return modelAndView;
    }

    @PostMapping("/edit-employee")
    public ModelAndView editEmployee(@ModelAttribute Employee employee, @RequestParam Long id) {
        employeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        modelAndView.addObject("employee", employeeService.findById(id).get());
        modelAndView.addObject("message", true);
        return modelAndView;
    }

    @GetMapping("/delete-employee")
    public ModelAndView deleteEmployee(@RequestParam Long id) {
        employeeService.deleteById(id);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/detail-employee")
    public ModelAndView showDetail(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("employee/detail");
        modelAndView.addObject("employee", employeeService.findById(id).get());
        return modelAndView;
    }

    @GetMapping("/sort-employee")
    public ModelAndView sortEmployee() {
        return new ModelAndView("employee/show", "employees", employeeService.findAllByOrderByAgeAsc());
    }
}
