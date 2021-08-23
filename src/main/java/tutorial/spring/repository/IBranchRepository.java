package tutorial.spring.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import tutorial.spring.model.Branch;

public interface IBranchRepository extends PagingAndSortingRepository<Branch, Long> {
}
