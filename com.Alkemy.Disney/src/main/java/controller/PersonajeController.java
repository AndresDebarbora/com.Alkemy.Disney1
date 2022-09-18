package controller;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import model.personaje;
import service.PersonajesServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/personajes")
@RestController
public class PersonajeController {

    @Autowired
    private PersonajesServices PersonajesServices;

    @GetMapping()
    public Iterable<Object[]> getAll(){
        return PersonajesServices.getAll();
    }

    @GetMapping("/{id}")
    public Optional<personaje> findById(@PathVariable("id") Integer personajeId){
        return PersonajesServices.findById(personajeId);
    }
    
    @GetMapping(params="nombre")
    public Iterable<Object[]> findByName(@RequestParam("name") String nombre){
        return PersonajesServices.findByNombre(nombre);
    }
    
    @GetMapping(params="edad")
    public Iterable<Object[]> findByAge(@RequestParam("edad") Integer edad){
        return PersonajesServices.findByEdad(edad);
    }
  
    @DeleteMapping(path = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        try {
        	PersonajesServices.delete(id);
            return "el personaje fue borrado: " + id;
        } catch (Exception e) {
            return "El personaje no puede ser borrado: " + id;
        }
    }
    
    @PostMapping("guardar")
    public personaje save(@RequestParam("file") MultipartFile imagen, @ModelAttribute personaje personaje){
        if(!imagen.isEmpty()){
            Path imagesPath = Paths.get("src//main//resources//static//images");
            String absolutPath = imagesPath.toFile().getAbsolutePath();
            try {
                byte[] bytes = imagen.getBytes();
                Path route = Paths.get(absolutPath + imagen.getOriginalFilename());
                Files.write(route, bytes);
                personaje.setImagen(imagen.getOriginalFilename());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return PersonajesServices.save(personaje);
    }
    
}
