package cl.blockbuster.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Pelicula database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p"),
    @NamedQuery(name = "Pelicula.findByIdPelicula", query = "SELECT p FROM Pelicula p WHERE p.idPelicula = :idPelicula"),
    @NamedQuery(name = "Pelicula.findByNombre", query = "SELECT p FROM Pelicula p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Pelicula.findByAnioPelicula", query = "SELECT p FROM Pelicula p WHERE p.anioPelicula = :anioPelicula"),
    @NamedQuery(name = "Pelicula.findByNombreDirector", query = "SELECT p FROM Pelicula p WHERE p.nombreDirector = :nombreDirector")})
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private short idPelicula;

	private short anioPelicula;

	private String nombre;

	private String nombreDirector;

	//bi-directional many-to-one association to Arriendo
	@OneToMany(mappedBy="pelicula", fetch=FetchType.EAGER)
	private List<Arriendo> arriendos;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="Categoria_Cod")
	private Categoria categoria;

	//bi-directional many-to-one association to Local
	@ManyToOne
	@JoinColumn(name="Local_Cod")
	private Local local;

	//bi-directional many-to-one association to Pai
	@ManyToOne
	@JoinColumn(name="Pais_Cod")
	private Pai pai;

	public Pelicula() {
	}

	public short getIdPelicula() {
		return this.idPelicula;
	}

	public void setIdPelicula(short idPelicula) {
		this.idPelicula = idPelicula;
	}

	public short getAnioPelicula() {
		return this.anioPelicula;
	}

	public void setAnioPelicula(short anioPelicula) {
		this.anioPelicula = anioPelicula;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreDirector() {
		return this.nombreDirector;
	}

	public void setNombreDirector(String nombreDirector) {
		this.nombreDirector = nombreDirector;
	}

	public List<Arriendo> getArriendos() {
		return this.arriendos;
	}

	public void setArriendos(List<Arriendo> arriendos) {
		this.arriendos = arriendos;
	}

	public Arriendo addArriendo(Arriendo arriendo) {
		getArriendos().add(arriendo);
		arriendo.setPelicula(this);

		return arriendo;
	}

	public Arriendo removeArriendo(Arriendo arriendo) {
		getArriendos().remove(arriendo);
		arriendo.setPelicula(null);

		return arriendo;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Local getLocal() {
		return this.local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Pai getPai() {
		return this.pai;
	}

	public void setPai(Pai pai) {
		this.pai = pai;
	}

}