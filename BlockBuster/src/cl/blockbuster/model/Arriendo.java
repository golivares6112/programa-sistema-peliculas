package cl.blockbuster.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Arriendo database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Arriendo.findAll", query = "SELECT a FROM Arriendo a"),
    @NamedQuery(name = "Arriendo.findByIdArriendo", query = "SELECT a FROM Arriendo a WHERE a.idArriendo = :idArriendo"),
    @NamedQuery(name = "Arriendo.findByFechaInicio", query = "SELECT a FROM Arriendo a WHERE a.fecha_Inicio = :fechaInicio"),
    @NamedQuery(name = "Arriendo.findByFechaCaducidad", query = "SELECT a FROM Arriendo a WHERE a.fecha_Caducidad = :fechaCaducidad")})
public class Arriendo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idArriendo;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_Caducidad;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha_Inicio;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="Cliente_Cod")
	private Cliente cliente;

	//bi-directional many-to-one association to Pelicula
	@ManyToOne
	@JoinColumn(name="Pelicula_Cod")
	private Pelicula pelicula;

	//bi-directional many-to-one association to Vendedor
	@ManyToOne
	@JoinColumn(name="Vendedor_Cod")
	private Vendedor vendedor;

	public Arriendo() {
	}

	public int getIdArriendo() {
		return this.idArriendo;
	}

	public void setIdArriendo(int idArriendo) {
		this.idArriendo = idArriendo;
	}

	public Date getFecha_Caducidad() {
		return this.fecha_Caducidad;
	}

	public void setFecha_Caducidad(Date fecha_Caducidad) {
		this.fecha_Caducidad = fecha_Caducidad;
	}

	public Date getFecha_Inicio() {
		return this.fecha_Inicio;
	}

	public void setFecha_Inicio(Date fecha_Inicio) {
		this.fecha_Inicio = fecha_Inicio;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pelicula getPelicula() {
		return this.pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}