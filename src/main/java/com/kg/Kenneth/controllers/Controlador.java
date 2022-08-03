package com.kg.Kenneth.controllers;


import com.kg.Kenneth.dao.UsuarioDAO;
import com.kg.Kenneth.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controlador {

    @Autowired
    private UsuarioDAO userDao;



    @GetMapping("/saludo")
    public String saludo(){
        return "Hola mundo";
    }


    @PostMapping("/nuevo")
    public Usuario nuevo(@RequestBody Usuario usuario){
     return userDao.save(usuario);
    }

    @GetMapping("/todos")
    public ArrayList<Usuario>verUsuarios(){
        return (ArrayList<Usuario>) userDao.findAll();
    }

    @GetMapping("/usuario/{ID}")
    public Optional<Usuario> usuarioPorId(@PathVariable("ID") Integer id){
        return userDao.findById(id);
    }

    @GetMapping("/email/{correo}")
    public Usuario usuarioEmail(@PathVariable("correo")String email){
        return userDao.findByEmail(email);
    }

    @DeleteMapping("/borrar/{ID}")
    public String eliminarUsuario(@PathVariable("ID")Integer id){
        userDao.deleteById(id);
        return "Se elimino al usuario con el ID "+id;
    }


}
