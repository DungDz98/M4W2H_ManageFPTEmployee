package tutorial.spring.service.branch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tutorial.spring.model.Branch;
import tutorial.spring.repository.IBranchRepository;

import java.util.Optional;

@Service
public class BranchService implements IBranchService{
    @Autowired
    private IBranchRepository branchRepository;
    @Override
    public Iterable<Branch> findAll() {
        return branchRepository.findAll();
    }

    @Override
    public Optional<Branch> findById(Long id) {
        return branchRepository.findById(id);
    }

    @Override
    public void save(Branch branch) {
        branchRepository.save(branch);
    }

    @Override
    public void deleteById(Long id) {
        branchRepository.deleteById(id);
    }
}
