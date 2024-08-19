package az.ingress.demo.repository;

import az.ingress.demo.model.Account;
import az.ingress.demo.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findByName(String name);


}
