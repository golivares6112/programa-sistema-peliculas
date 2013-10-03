package cl.blockbuster.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Local database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Local.findAll", query = "SELECT l FROM Local l"),
    @NamedQuery(name = "Local.findByIdLocal", query = "SELECT l FROM Local l WHERE l.idLocal = :idLocal"),
    @NamedQuery(name = "Local.findByCiudad", query = "SELECT l FROM Local l WHERE l.ciudad = :ciudad")})
public class Local implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private byte idLocal;

	private String ciudad;

	//bi-directional many-to-one association to Pelicula
	@OneToMany(mappedBy="local", fetch=FetchType.EAGER)
	private List<Pelicula> peliculas;

	//bi-directional many-to-one association to Vendedor
	@OneToMany(mappedBy="local", fetch=FetchType.EAGER)
	private List<Vendedor> vendedors;

	public Local() {
	}

	public byte getIdLocal() {
		return this.idLocal;
	}

	public void setIdLocal(byte idLocal) {
		this.idLocal = idLocal;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public List<Pelicula> getPeliculas() {
		return this.peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public Pelicula addPelicula(Pelicula pelicula) {
		getPeliculas().add(pelicula);
		pelicula.setLocal(this);

		return pelicula;
	}

	public Pelicula removePelicula(Pelicula pelicula) {
		getPeliculas().remove(pelicula);
		pelicula.setLocal(null);

		return pelicula;
	}

	public List<Vendedor> getVendedors() {
		return this.vendedors;
	}

	public void setVendedors(List<Vendedor> vendedors) {
		this.vendedors = vendedors;
	}

	public Vendedor addVendedor(Vendedor vendedor) {
		getVendedors().add(vendedor);
		vendedor.setLocal(this);

		return vendedor;
	}

	public Vendedor removeVendedor(Vendedor vendedor) {
		getVendedors().remove(vendedor);
		vendedor.setLocal(null);

		return vendedor;
	}

}