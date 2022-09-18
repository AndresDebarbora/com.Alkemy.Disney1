package service;

import java.util.List;
import java.util.Optional;

import model.Generos;
import model.Peliculas;
import repository.GeneroRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService{
    
    @Autowired
    private GeneroRepository GeneroRepository;

    public Generos save(Generos generos){
        return GeneroRepository.save(generos);       
    }
    public boolean delete(Integer id){
        try{
            GeneroRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
        
    }
    public Optional<Generos> findById(Integer genderId) {
        return GeneroRepository.findById(genderId);
    }
    public List<Peliculas> getMoviesByGenreId(Integer genreId) {
        Generos generos = GeneroRepository.getById(genreId);
        if(generos != null){
            List<Peliculas> movies = generos.getPeliculasID();   
            return movies;
        }else{
            return null;
        }

    }

}