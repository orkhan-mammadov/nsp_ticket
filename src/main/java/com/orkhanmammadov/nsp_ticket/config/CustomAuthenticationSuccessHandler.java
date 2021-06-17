package com.orkhanmammadov.nsp_ticket.config;

import com.orkhanmammadov.nsp_ticket.entity.User;
import com.orkhanmammadov.nsp_ticket.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

        System.out.println("\n Authentication Success Handler \n");

        String username = authentication.getName();

        User user = userServiceImpl.findByUsername(username);

        HttpSession httpSession = httpServletRequest.getSession();

        httpSession.setAttribute("user", user);

        httpServletResponse.setStatus(200);

        //httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/api/company/1");

    }
}
