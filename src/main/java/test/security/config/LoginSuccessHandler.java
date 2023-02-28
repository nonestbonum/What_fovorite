package test.security.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import test.security.details.AccountDetailsImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        AccountDetailsImpl accountDetails = (AccountDetailsImpl) authentication.getPrincipal();
        String redirectURL;
        if (accountDetails.getRole().equals("USER") && accountDetails.isActivated()) {
            redirectURL = accountDetails.id().toString();
        } else if (!accountDetails.isActivated()) {
            redirectURL = "/error/403";
        } else redirectURL = "/accounts/" + accountDetails.id().toString();
        response.sendRedirect(redirectURL);
    }
}