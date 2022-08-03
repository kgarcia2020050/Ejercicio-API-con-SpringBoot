package com.kg.Kenneth.dao;

import com.kg.Kenneth.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


//Jpa nos trae metodos por default
public interface UsuarioDAO extends JpaRepository<Usuario,Integer> {
    public abstract Usuario findByEmail(String email);
}
