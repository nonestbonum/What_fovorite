package test.services;


import org.springframework.validation.BindingResult;
import test.dto.SignUpForm;

import javax.validation.Valid;

public interface SignUpService {


    void signUp(@Valid SignUpForm form);

    boolean activateUser(String code);

    boolean existsAccountByEmailAndPassword(SignUpForm form);
}
