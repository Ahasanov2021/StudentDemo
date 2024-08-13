package az.ingress.demo.service;

import az.ingress.demo.model.Account;
import az.ingress.demo.repository.AccountRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransferService {

    private final AccountRepository accountRepository;
    private final EntityManagerFactory entityManagerFactory;

    @SneakyThrows
    public void transfer(Account from, Account to, double amount){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try{
            if(from.getBalance() < amount) {
                throw new RuntimeException();
            }
//        log.info("waiting");
//        Thread.sleep(10000);
//        Hesabdan pul cixilanda 0 olanda dbde dbye 210 yazir yene cunki Account from ordan alinan obyektde hele de 240di

            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);

//            accountRepository.save(from);
            entityManager.merge(from);
            if (true) {
                throw new RuntimeException();
            }
//            accountRepository.save(to);
            entityManager.merge(to);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e){
            entityManager.getTransaction().rollback();
        }
        entityManager.close();

    }


//    @Transactional(rollbackOn = Exception.class)
    // @Transactional only locks runtime exceptions
    // rollbackOn helps to lock noted exception type
    // dontRollbackOn makes Transactional not to rollback noted exception type
    @Transactional
    // Transactional uses proxy design pattern
    public void transfer2(Account from, Account to, double amount) throws Exception {

        if(from.getBalance() < amount) {
            throw new RuntimeException();
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        accountRepository.save(from);
        if (true) {
            throw new Exception();
        }
        accountRepository.save(to);
    }

//    public void
}
