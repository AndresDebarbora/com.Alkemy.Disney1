package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "peliculas")
public class Peliculas {
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Id
        private Integer pk_peliculaid;
        private String titulo;
        private String imagen;
        @JsonFormat(pattern="yyyy/MM/dd")
        private Date fecha_creacion;
        private Integer rating;
        @JsonBackReference
        @ManyToMany(fetch=FetchType.LAZY,  mappedBy = "peliculaID", cascade = CascadeType.ALL)
        private List<personaje> personajeID;

        @JsonBackReference
        @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinColumn(name="pk_generosid")
        private Generos generosID;

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getImagen() {
			return imagen;
		}

		public void setImagen(String imagen) {
			this.imagen = imagen;
		}

		public Integer getRating() {
			return rating;
		}

		public void setRating(Integer rating) {
			this.rating = rating;
		}
}

