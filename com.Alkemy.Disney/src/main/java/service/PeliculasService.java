package service;


import java.util.Optional;

import model.Peliculas;
import repository.PeliculaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculasService {
    @Autowired
    private static PeliculaRepository PeliculaRepository;

    public Iterable<Peliculas> findAll(){
        return PeliculaRepository.findAll();
    }
    public static Iterable<Object[]> getAll(){
        return repository.PeliculaRepository.getAll();
    }

    public static Optional<Peliculas> findById(Integer id){
        return PeliculaRepository.findById(id);
    }
    public static Peliculas save(Peliculas peliculas)
    {
        return PeliculaRepository.save(peliculas);
    }
    public static Iterable<Object[]> findByTitulo(String titulo){
        return repository.PeliculaRepository.findByTitulo(titulo);
    }

    public static Iterable<Object[]> getByOrden(String orden){
        if(orden.equals("ASC")){
            return repository.PeliculaRepository.getAllByOrderASC();            
        }else if(orden.equals("DESC")){
            return repository.PeliculaRepository.getAllByOrderDESC();  
        }else{
            return repository.PeliculaRepository.getAll();
        }
    }
    
    public static boolean delete(Integer id){
        try{
            PeliculaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
        
    }

}
