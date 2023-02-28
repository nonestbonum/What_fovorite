package test.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import test.models.Account;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Long> {

    boolean existsAccountByEmailAndPassword(String email, String pass);

    @Override
    List<Account> findAll();

    Account findAccountByActivationCode(String code);

    Optional<Account> findByEmail(String email);


    @Transactional
    void deleteAccountById(Long accId);


//    @Query(nativeQuery = true, value = "select * from account_table")
//    List<Account> getAllAccounts();

    Account getAccountById(Long id);


}
