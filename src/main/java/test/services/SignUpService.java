package test.services;


import test.dto.SignUpForm;

public interface SignUpService {
    boolean signUp(SignUpForm form);

    boolean activateUser(String code);
}
