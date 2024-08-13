package az.ingress.demo.repository;

import az.ingress.demo.model.Account;
import az.ingress.demo.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {




}
