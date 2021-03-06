package festival.negocio.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Banda", schema="DDS")
public class Banda implements Serializable {
	
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6696929920118910226L;

	/**
	 * id interno de la banda
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_banda")
	private Integer idBanda;
	
	/**
	 * nombre de la banda
	 */
	@Column(name="nombre")
	private String nombre;
	
	/**
	 * Noches en las que toca
	 */
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="listaBandas")
	private List<Noche> noches;

	/**
	 * @return the idBanda
	 */
	public Integer getIdBanda() {
		return idBanda;
	}

	/**
	 * @param idBanda the idBanda to set
	 */
	public void setIdBanda(Integer idBanda) {
		this.idBanda = idBanda;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the noches
	 */
	public List<Noche> getNoches() {
		return noches;
	}

	/**
	 * @param noches the noches to set
	 */
	public void setNoches(List<Noche> noches) {
		this.noches = noches;
	}
	
	
}
