package cl.blockbuster.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Vendedor database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v"),
    @NamedQuery(name = "Vendedor.findByIdVendedor", query = "SELECT v FROM Vendedor v WHERE v.idVendedor = :idVendedor"),
    @NamedQuery(name = "Vendedor.findByNombre", query = "SELECT v FROM Vendedor v WHERE v.nombre = :nombre"),
    @NamedQuery(name = "Vendedor.findByApellido", query = "SELECT v FROM Vendedor v WHERE v.apellido = :apellido"),
    @NamedQuery(name = "Vendedor.findByTelefono", query = "SELECT v FROM Vendedor v WHERE v.telefono = :telefono"),
    @NamedQuery(name = "Vendedor.findByDireccion", query = "SELECT v FROM Vendedor v WHERE v.direccion = :direccion"),
    @NamedQuery(name = "Vendedor.findByEscritura", query = "SELECT v FROM Vendedor v WHERE v.escritura = :escritura"),
    @NamedQuery(name = "Vendedor.findByLectura", query = "SELECT v FROM Vendedor v WHERE v.lectura = :lectura"),
    @NamedQuery(name = "Vendedor.findByModificacion", query = "SELECT v FROM Vendedor v WHERE v.modificacion = :modificacion"),
    @NamedQuery(name = "Vendedor.findByBorrado", query = "SELECT v FROM Vendedor v WHERE v.borrado = :borrado")})
public class Vendedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private short idVendedor;

	private String apellido;

	private String borrado;

	private String direccion;

	private String escritura;

	private String lectura;

	private String modificacion;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Arriendo
	@OneToMany(mappedBy="vendedor", fetch=FetchType.EAGER)
	private List<Arriendo> arriendos;

	//bi-directional many-to-one association to Local
	@ManyToOne
	@JoinColumn(name="Local_Cod")
	private Local local;

	public Vendedor() {
	}

	public short getIdVendedor() {
		return this.idVendedor;
	}

	public void setIdVendedor(short idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getBorrado() {
		return this.borrado;
	}

	public void setBorrado(String borrado) {
		this.borrado = borrado;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEscritura() {
		return this.escritura;
	}

	public void setEscritura(String escritura) {
		this.escritura = escritura;
	}

	public String getLectura() {
		return this.lectura;
	}

	public void setLectura(String lectura) {
		this.lectura = lectura;
	}

	public String getModificacion() {
		return this.modificacion;
	}

	public void setModificacion(String modificacion) {
		this.modificacion = modificacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Arriendo> getArriendos() {
		return this.arriendos;
	}

	public void setArriendos(List<Arriendo> arriendos) {
		this.arriendos = arriendos;
	}

	public Arriendo addArriendo(Arriendo arriendo) {
		getArriendos().add(arriendo);
		arriendo.setVendedor(this);

		return arriendo;
	}

	public Arriendo removeArriendo(Arriendo arriendo) {
		getArriendos().remove(arriendo);
		arriendo.setVendedor(null);

		return arriendo;
	}

	public Local getLocal() {
		return this.local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

}