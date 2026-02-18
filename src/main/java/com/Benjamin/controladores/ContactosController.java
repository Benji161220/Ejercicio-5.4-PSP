package com.Benjamin.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactosController {

    @GetMapping("/contactos")
    public List<String> getContactos() {
        return List.of("Ana - 600111222", "Luis - 600333444");
    }
}
