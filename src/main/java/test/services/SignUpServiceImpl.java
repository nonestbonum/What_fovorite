package test.services;

import org.springframework.validation.BindingResult;
import test.dto.FormDto;
import test.dto.SignUpForm;
import test.models.Account;
import test.models.Role;
import test.repositories.AccountsRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Locale;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final AccountsRepository accountsRepository;
    private final PasswordEncoder passwordEncoder;
    private final MailSenderImpl mailSender;


    @Override
    public void signUp(@Valid SignUpForm form) {
        Account account = Account.builder()
                .FIO(form.getFIO())
                .birthday(form.getBirthday())
                .email(form.getEmail().toLowerCase(Locale.ROOT))
                .role(Role.USER)
                .password(passwordEncoder.encode(form.getPassword()))
                .build();
        account.setActivationCode(UUID.randomUUID().toString());
        account.setActivated(false);
        accountsRepository.save(account);
        String message = String.format("Здравствуйте, %s! Для активации Вашего аккаунта перейдите по ссылке: http://localhost:8090/signUp/activate/%s",
                account.getFIO(), account.getActivationCode());
        mailSender.send(account.getEmail(), "Код активации", message);

    }

    @Override
    public boolean activateUser(String code) {
        Account account = accountsRepository.findAccountByActivationCode(code);

        if (account == null) {
            return false;
        }
        account.setActivationCode(null);
        account.setActivated(true);
        accountsRepository.save(account);
        return true;
    }

    @Override
    public boolean existsAccountByEmailAndPassword(SignUpForm form) { // тут вынесла логику в отдельный метод из signUp
        return accountsRepository.existsAccountByEmailAndPassword(form.getEmail(), passwordEncoder.encode(form.getPassword()));
    }
}
