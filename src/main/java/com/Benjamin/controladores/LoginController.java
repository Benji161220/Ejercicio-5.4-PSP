package com.Benjamin.controladores;

import com.Benjamin.excepciones.BadRequestException;
import com.Benjamin.seguridad.Constans;
import com.Benjamin.seguridad.JWTAuthenticationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    JWTAuthenticationConfig jwtAuthtenticationConfig;

    @PostMapping("/login")
    public String login(@RequestParam("user") String username,
                        @RequestParam("encryptedPass") String encryptedPass) throws BadRequestException {
        if (!(username.equals(Constans.USER) && encryptedPass.equals(Constans.PASS))) {
            throw new BadRequestException();
        }
        return jwtAuthtenticationConfig.getJWTToken(username);
    }
}
