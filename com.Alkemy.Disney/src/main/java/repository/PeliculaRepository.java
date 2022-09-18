package repository;

 
	import java.util.Optional;



	import model.Peliculas;

	import org.springframework.data.jpa.repository.Query;
	import org.springframework.data.repository.CrudRepository;
	import org.springframework.stereotype.Repository;

	@Repository
	public interface PeliculaRepository extends CrudRepository<Peliculas, Integer> {

	    public static Iterable<Object[]> findByTitulo(String titulo) {
			// TODO Auto-generated method stub
			return null;
		}

	    public default Optional<Peliculas> findById(Integer id) {
			return null;
		}
	    
	    @Query(value = "SELECCIONAR titulo,imagen,fecha de creacion de la pelicula",nativeQuery = true)
	    public static Iterable<Object[]> getAll() {
			
			return null;
		}

	    @Query(value = "SELECCIONAR titulo,imagen,fecha de creacion de la Pelicula ordenado por fecha de creacion ascendente",nativeQuery = true)
	    public static Iterable<Object[]> getAllByOrderASC() {
			// TODO Auto-generated method stub
			return null;
		}

	    @Query(value = "SELECCIONAR titulo,imagen,fecha de creacion de la Pelicula ordenado por fecha de creacion descendente",nativeQuery = true)
	    public static Iterable<Object[]> getAllByOrderDESC() {
			
			return null;
		}
	    
	    public Peliculas getById(Integer peliculaId);
	}

