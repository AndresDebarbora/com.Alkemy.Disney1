package model;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "personajesdisney")
public class personaje {
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Id
        private Integer pk_personajeid;
        private String nombre;
        @SuppressWarnings("unused")
		private String imagen;
        private Integer edad;
        private Integer peso;
        private String historia;
        @JsonManagedReference
        @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "personaje_pelicula",
        joinColumns = {
                @JoinColumn(name = "pk_personajeid", nullable = false)},
        inverseJoinColumns = {
                @JoinColumn(name = "pk_peliculaid", nullable = false)})
        private List<Peliculas> peliculaID;
		public void setImagen(String originalFilename) {
			
			
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public Integer getEdad() {
			return edad;
		}
		public void setEdad(Integer edad) {
			this.edad = edad;
		}
		public Integer getPeso() {
			return peso;
		}
		public void setPeso(Integer peso) {
			this.peso = peso;
		}
		public String getHistoria() {
			return historia;
		}
		public void setHistoria(String historia) {
			this.historia = historia;
		}
}