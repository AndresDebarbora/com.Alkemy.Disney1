package repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import model.personaje;

@Repository
public interface PersonajesRepository<Personaje> extends CrudRepository <Personaje, Integer>{

	public static Iterable<Object[]> findByNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static Iterable<Object[]> findByEdad(Integer edad) {
		
		return null;
	}
	
	@Query(value="seleccionar imagen, nombre del personaje", nativeQuery=true)
	public static Iterable<Object[]> getAll() {
		
		return null;
	}
	
	public static List<Object[]> findById(String nombre) {
		
		return null;
	}

	public static Iterable<personaje> findAll(Object personaje) {
		// TODO Auto-generated method stub
		return null;
	}
	public default Iterable<personaje> deleteById(String personaje) {
		// TODO Auto-generated method stub
		return null;
	}
}
