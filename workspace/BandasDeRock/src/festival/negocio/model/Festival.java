package festival.negocio.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Festival", schema="DDS")
public class Festival implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 216771960519473729L;
	
	/**
	 * id interno del festival
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_festival")
	private Integer idFestival;
	
	/**
	 * nombre del festival
	 */
	@Column(name="nombre")
	private String nombre;
	
	/**
	 * predio en el que se realiza el festival
	 */
	@Column(name="predio")
	private String predio;
	
	/**
	 * Las noches del festival
	 */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="id_festival")
	private List<Noche> noches;
	
		

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

	/**
	 * @return the idFestival
	 */
	public Integer getIdFestival() {
		return idFestival;
	}

	/**
	 * @param idFestival the idFestival to set
	 */
	public void setIdFestival(Integer idFestival) {
		this.idFestival = idFestival;
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
	 * @return the predio
	 */
	public String getPredio() {
		return predio;
	}

	/**
	 * @param predio the predio to set
	 */
	public void setPredio(String predio) {
		this.predio = predio;
	}
	
}
