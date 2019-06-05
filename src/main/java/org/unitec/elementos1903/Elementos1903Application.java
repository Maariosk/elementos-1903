package org.unitec.elementos1903;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Elementos1903Application implements CommandLineRunner {

    @Autowired
    RepoCliente repoCliente;
	public static void main(String[] args) {
		SpringApplication.run(Elementos1903Application.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        //Insertar
        repoCliente.save(new Cliente(1,"Mario","Maario@gmail.com"));
        repoCliente.save(new Cliente(2,"Msk","Maario@gmail.com"));
        repoCliente.save(new Cliente(3,"Jose","Maario@gmail.com"));
        //Actualizar por ID
         // repoCliente.save(new Cliente(1,"Marioo","Maario@gmail.com"));
        //Buscar todos
        for(Cliente c: repoCliente.findAll()){
            //Buscar por Id
            System.out.println(repoCliente.findById(1));
        }
        //Borrar
        //repoCliente.deleteById(1);
    }

}
