package cl.blockbuster.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Cliente database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByDigito", query = "SELECT c FROM Cliente c WHERE c.digito = :digito"),
    @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cliente.findByPaterno", query = "SELECT c FROM Cliente c WHERE c.paterno = :paterno"),
    @NamedQuery(name = "Cliente.findByMaterno", query = "SELECT c FROM Cliente c WHERE c.materno = :materno"),
    @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Cliente.findByCelular", query = "SELECT c FROM Cliente c WHERE c.celular = :celular"),
    @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email")})
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCliente;

	private String celular;

	private String digito;

	private String direccion;

	private String email;

	private String materno;

	private String nombre;

	private String paterno;

	@Column(name="`Telefono Fijo`")
	private String telefono_Fijo;

	//bi-directional many-to-one association to Arriendo
	@OneToMany(mappedBy="cliente", fetch=FetchType.EAGER)
	private List<Arriendo> arriendos;

	public Cliente() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDigito() {
		return this.digito;
	}

	public void setDigito(String digito) {
		this.digito = digito;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaterno() {
		return this.materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPaterno() {
		return this.paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getTelefono_Fijo() {
		return this.telefono_Fijo;
	}

	public void setTelefono_Fijo(String telefono_Fijo) {
		this.telefono_Fijo = telefono_Fijo;
	}

	public List<Arriendo> getArriendos() {
		return this.arriendos;
	}

	public void setArriendos(List<Arriendo> arriendos) {
		this.arriendos = arriendos;
	}

	public Arriendo addArriendo(Arriendo arriendo) {
		getArriendos().add(arriendo);
		arriendo.setCliente(this);

		return arriendo;
	}

	public Arriendo removeArriendo(Arriendo arriendo) {
		getArriendos().remove(arriendo);
		arriendo.setCliente(null);

		return arriendo;
	}

}