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

@Controller
public class BranchController {
    @Autowired
    private IBranchService branchService;
    @GetMapping("/branchs")
    public ModelAndView showBranch() {
        ModelAndView modelAndView = new ModelAndView("branch/show");
        modelAndView.addObject("branchs", branchService.findAll());
        return modelAndView;
    }

    @GetMapping("/create-branch")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("branch/create");
        modelAndView.addObject("branch", new Branch());
        return modelAndView;
    }

    @PostMapping("/create-branch")
    public ModelAndView createBranch(@ModelAttribute Branch branch) {
        branchService.save(branch);
        return new ModelAndView("redirect:/branchs");
    }

    @GetMapping("/delete-branch")
    public ModelAndView deleteBranch(@RequestParam Long id) {
        branchService.deleteById(id);
        return new ModelAndView("redirect:/branchs");
    }

}
