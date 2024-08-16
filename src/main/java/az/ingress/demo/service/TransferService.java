package az.ingress.demo.service;

import az.ingress.demo.model.Account;
import az.ingress.demo.repository.AccountRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransferService {

    private final AccountRepository accountRepository;
    private final EntityManagerFactory entityManagerFactory;
    private final ApplicationContext context;
    // All spring beans are stored in Application context

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
    @Transactional(isolation = Isolation.SERIALIZABLE)
    // Transactional uses proxy design pattern
    public void transfer2(Account from, Account to, double amount, EntityManager entityManager) {

        if(from.getBalance() < amount) {
            throw new RuntimeException();
        }

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        entityManager.merge(from);
        if (true) {
            throw new RuntimeException();
        }
        entityManager.merge(to);
    }

    @Transactional
    // methods with @Transactinal should be called outside the class it's been declared
    public void hello() {

    }

    // How @Transactional works
    public void proxyTransfer(Account from, Account to, double amount) {
        // This way a method annotated with @Transactional can be called inside the same class it was declared
        context.getBean(TransferService.class).hello();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            transfer2(from, to, amount, entityManager);
            entityManager.getTransaction().commit();
        } catch (NullPointerException e) {
            entityManager.getTransaction().commit();
        }  catch (RuntimeException e) {
            entityManager.getTransaction().rollback();
        } catch (Exception e) {
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }

    }


    // Transactional isolation phenomenas
    // 1.Dirty read - can see uncommitted all data
    // 2.nonrepeatable read - can see uncommitted updates or deletes
    // 3.phantom - can see uncommitted inserts or updates

    


}
