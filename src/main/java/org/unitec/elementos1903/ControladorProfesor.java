/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.elementos1903;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MarioSk1
 */

@RestController
@RequestMapping("/api")
public class ControladorProfesor {
    
    @Autowired
       RepoProfersor repoProfe;
    
    //El metodo para guardar
    @PostMapping("/profesor")
    public Estatus guardar(@RequestBody String json)throws Exception{
        //Primero vamos a recibir el json del cliente web y lo transformamos a un objeto en java con
        //la clase ObjectMapper
        ObjectMapper maper = new ObjectMapper();
        Profesor profe = maper.readValue(json, Profesor.class);
        repoProfe.save(profe);
        Estatus e= new Estatus();
        e.setMensaje("Profe guardado");
        e.setSuccess(true);
        
        return e;
    }
    //Buscar todos
    @GetMapping("/profesor")
    public List<Profesor> buscarTodos(){
        return repoProfe.findAll();
         
    }
    
    //BORRAR
    @DeleteMapping("/profesor/{id}")
    public Estatus borrar (@PathVariable Integer id){
        repoProfe.deleteById(id);
        Estatus e= new Estatus();
        e.setSuccess(true);
        e.setMensaje("Profesor Borrado");
        return e;
        
    }
    
    //Acuatizar
    @PutMapping("/profesor")
    public Estatus actualizar(@RequestBody String json )throws Exception{
            //Primero vamos a recibir el json del cliente web y lo transformamos a un objeto en java con
        //la clase ObjectMapper
        ObjectMapper maper = new ObjectMapper();
        Profesor profe = maper.readValue(json, Profesor.class);
        repoProfe.save(profe);
        Estatus e= new Estatus();
        e.setMensaje("Profe guardado");
        e.setSuccess(true);
        
        return e;
    }
    @GetMapping("/profesor/{id}")
    public Profesor buscarPorId(@PathVariable Integer id){
        return repoProfe.findById(id).get();
    }
}
