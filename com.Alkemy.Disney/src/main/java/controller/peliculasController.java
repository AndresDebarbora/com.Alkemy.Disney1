package controller;

import service.GeneroService;
import service.PeliculasService;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import model.Generos;
import model.Peliculas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/peliculas")
@RestController
public class peliculasController {
    
    @Autowired
    private PeliculasService peliculasServices;
    @Autowired
    private GeneroService generoServices; 


    @GetMapping()
    public Iterable<Object[]> getAll(){
        return PeliculasService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Peliculas> findById(@PathVariable("id") Integer Id){
        return PeliculasService.findById(Id);
    }
    
    @GetMapping(params="nombre")
    public Iterable<Object[]> findByTitulo(@RequestParam("nombre") String titulo){
        return PeliculasService.findByTitulo(titulo);
    }
    @GetMapping(params="orden")
    public Iterable<Object[]> getByOrden(@RequestParam("orden") String orden){
        return PeliculasService.getByOrden(orden);
    }
    @GetMapping(value = "", params="generoId")
    public List<Peliculas> getByGenero(@RequestParam("generoId") Integer generoId){
        return Generos.getMoviesByGenreId(generoId);
    }
    
    @DeleteMapping(path = "delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        try {
        	PeliculasService.delete(id);
            return "Character was deleted id: " + id;
        } catch (Exception e) {
            return "Character cannot deleted id: " + id;
        }
    }

    @PostMapping("guardar")
    public Peliculas save(@RequestParam("file") MultipartFile imagen, @ModelAttribute Peliculas peliculas){
        if(!imagen.isEmpty()){
            Path imagesPath = Paths.get("src//main//resources//static//images");
            String absolutPath = imagesPath.toFile().getAbsolutePath();
            try {
                byte[] bytes = imagen.getBytes();
                Path route = Paths.get(absolutPath + imagen.getOriginalFilename());
                Files.write(route, bytes);
                peliculas.setImagen(imagen.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return PeliculasService.save(peliculas);
    }

	public PeliculasService getPeliculasServices() {
		return peliculasServices;
	}

	public void setPeliculasServices(PeliculasService peliculasServices) {
		this.peliculasServices = peliculasServices;
	}

	public GeneroService getGeneroServices() {
		return generoServices;
	}

	public void setGeneroServices(GeneroService generoServices) {
		this.generoServices = generoServices;
	}
}
