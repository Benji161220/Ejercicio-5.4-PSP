package com.Benjamin.servicios;

import com.Benjamin.modelo.Contacto;
import com.Benjamin.repositorios.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoService {

    @Autowired
    private ContactoRepository contactoRepository;

    public List<Contacto> obtenerTodosContactos() {
        return contactoRepository.obtenerTodos();
    }

    public Contacto obtenerContactoPorId(Long id) {
        return contactoRepository.obtenerPorId(id);
    }

    public Contacto crearContacto(Contacto contacto) {
        return contactoRepository.guardar(contacto);
    }

    public Contacto actualizarContacto(Long id, Contacto contactoUpdate) {
        Contacto contacto = contactoRepository.obtenerPorId(id);
        if (contacto != null) {
            contacto.setNombre(contactoUpdate.getNombre());
            contacto.setTelefono(contactoUpdate.getTelefono());
            return contactoRepository.guardar(contacto);
        }
        return null;
    }


    public void borrarContacto(Long id) {
        contactoRepository.eliminar(id);
    }
}
