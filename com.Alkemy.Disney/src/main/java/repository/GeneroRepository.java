package repository;


	import java.util.Optional;

	import model.Generos;
	import org.springframework.data.repository.CrudRepository;


	public interface GeneroRepository extends CrudRepository<Generos, Integer> {
	    public default Optional<Generos> findById(Integer id) {
			
			return null;
		}
	    public Generos getById(Integer genderId);
	    
}
