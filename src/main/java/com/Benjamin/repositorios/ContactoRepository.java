package com.Benjamin.repositorios;

import com.Benjamin.modelo.Contacto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactoRepository {
    private static List<Contacto> contactos = new ArrayList<>();
    private static int nextId = 0;

    static {
        contactos.add(new Contacto(nextId++, "Ana", "600111222"));
        contactos.add(new Contacto(nextId++, "Luis", "600333444"));
    }

    public List<Contacto> obtenerTodos() {
        return new ArrayList<>(contactos);
    }

    public Contacto obtenerPorId(Long id) {
        for (Contacto contacto : contactos) {
            if (contacto.getId() == id) {
                return contacto;
            }
        }
        return null;
    }

    public Contacto guardar(Contacto contacto) {
        contactos.add(contacto);
        return contacto;
    }

    public boolean eliminar(int id) {
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getId() == id) {
                contactos.remove(i);
                return true;
            }
        }
        return false;
    }
}
