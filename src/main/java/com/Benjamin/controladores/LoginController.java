package com.Benjamin.controladores;

import com.Benjamin.excepciones.BadRequestException;
import com.Benjamin.modelo.Usuario;
import com.Benjamin.repositorios.UsuarioRepository;
import com.Benjamin.seguridad.JWTAuthenticationConfig;
import com.Benjamin.seguridad.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    JWTAuthenticationConfig jwtAuthtenticationConfig;

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public String login(
            @RequestParam("user") String username,
            @RequestParam("encryptedPass") String encryptedPass)
            throws BadRequestException {
        List<Usuario> usuarios = usuarioRepository.getUsuarios();
        Usuario usuarioEncontrado = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) &&
                    PasswordEncryptor.decrypt(usuario.getEncryptedPass()).equals(encryptedPass)) {
                usuarioEncontrado = usuario;
                break;
            }
        }
        if (usuarioEncontrado == null) {
            throw new BadRequestException();
        }
        String token = jwtAuthtenticationConfig.getJWTToken(usuarioEncontrado.getUsername(), usuarioEncontrado.getRol());
        return token;
    }
}
