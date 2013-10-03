package cl.blockbuster.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Pais database table.
 * 
 */
@Entity
@Table(name="Pais")
@NamedQueries({
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pai p"),
    @NamedQuery(name = "Pais.findByIdPais", query = "SELECT p FROM Pai p WHERE p.idPais = :idPais"),
    @NamedQuery(name = "Pais.findByPais", query = "SELECT p FROM Pai p WHERE p.pais = :pais")})
public class Pai implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private byte idPais;

	private String pais;

	//bi-directional many-to-one association to Pelicula
	@OneToMany(mappedBy="pai", fetch=FetchType.EAGER)
	private List<Pelicula> peliculas;

	public Pai() {
	}

	public byte getIdPais() {
		return this.idPais;
	}

	public void setIdPais(byte idPais) {
		this.idPais = idPais;
	}

	public String getPais() {
		return this.pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Pelicula> getPeliculas() {
		return this.peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public Pelicula addPelicula(Pelicula pelicula) {
		getPeliculas().add(pelicula);
		pelicula.setPai(this);

		return pelicula;
	}

	public Pelicula removePelicula(Pelicula pelicula) {
		getPeliculas().remove(pelicula);
		pelicula.setPai(null);

		return pelicula;
	}

}