package service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.personaje;
import repository.PersonajesRepository;

public class PersonajesServices  {

	public Object personaje;
	
	@Service
	public class personajeServices {
	    @Autowired
	    private PersonajesRepository<personaje> PersonajesRepository;
	    
	    public Iterable<personaje> findAll(){
	        return repository.PersonajesRepository.findAll(personaje);
	    }
	    public Iterable<Object[]> getAll() {
	        return repository.PersonajesRepository.getAll();

	    }

	    public boolean delete(Integer id) {
	        	PersonajesRepository.deleteById(id);
	            return true;
	  
	        }
	        
	    }




	public personaje save(personaje personaje) {
		return null;
	}

	public void delete(Integer id) {
		
	}

	public Iterable<Object[]> findByEdad(Integer edad) {	
		return null;
	}

	public Iterable<Object[]> findByNombre(String nombre) {
		return null;
	}

	public Optional<personaje> findById(Integer personajeId) {
		return null;
	}

	public Iterable<Object[]> getAll() {
		return null;
	}


	}
