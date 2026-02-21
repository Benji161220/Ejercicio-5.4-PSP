package com.Benjamin.controladores;

import com.Benjamin.modelo.Contacto;
import com.Benjamin.servicios.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contactos")
public class ContactosController {

    @Autowired
    private ContactoService contactoService;

    @GetMapping
    public List<Contacto> getContactos() {
        return contactoService.obtenerTodosContactos();
    }

    @PostMapping
    public Contacto addContacto(@RequestBody Contacto contacto) {
        return contactoService.crearContacto(contacto);
    }

    @PutMapping("/{id}")
    public Contacto updateContacto(@PathVariable Long id, @RequestBody Contacto contacto) {
        return contactoService.actualizarContacto(id, contacto);
    }

    @DeleteMapping("/{id}")
    public void deleteContacto(@PathVariable int id) {
        contactoService.eliminarContacto(id);
    }
}
