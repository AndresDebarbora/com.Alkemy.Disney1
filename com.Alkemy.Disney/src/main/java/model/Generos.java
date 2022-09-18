package model;


	import java.util.List;

	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;

	import com.fasterxml.jackson.annotation.JsonManagedReference;

	import lombok.Data;

	@Data
	@Entity
	@Table(name = "generos")
	public class Generos {
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Id
	    private Integer pk_generoid;
	    private String nombre;
	    private String imagen;

	    @JsonManagedReference
	    @OneToMany(mappedBy = "generosID",fetch=FetchType.LAZY, cascade = CascadeType.ALL)
		private List<Peliculas> peliculaID;

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getImagen() {
			return imagen;
		}

		public void setImagen(String imagen) {
			this.imagen = imagen;
		}

		public static List<Peliculas> getMoviesByGenreId(Integer generoId) {
			// TODO Auto-generated method stub
			return null;
		}

		public List<Peliculas> getPeliculasID() {
			// TODO Auto-generated method stub
			return null;
		}

	}
