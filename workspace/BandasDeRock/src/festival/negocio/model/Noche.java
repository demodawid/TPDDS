package festival.negocio.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Noche", schema="DDS")
public class Noche implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1251069962856131116L;
	
	/**
	 * id interno de la noche
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_noche")
	private Integer idNoche;
	
	/**
	 * festival al que pertenece la noche
	 */
	@ManyToOne
	@JoinColumn(name="id_festival")
	private Festival festival;
	
	/**
	 * numero de noche dentro del festival
	 */
	@Column(name="numero")
	private Integer numero;
	
	/**
	 * fecha en la que se realiza el festival
	 */
	@Column(name="fecha")
	private Date fecha;
	
	/**
	 * fecha en la que no se puede comprar mas entradas anticipadas
	 */
	@Column(name="fecha_fin_anticipada")
	private Date fechaFinAnticipada;
	
	/**
	 * Descuento por comprar entradas de forma anticipada
	 */
	@Column(name="descuento")
	private Integer descuento;
	
	/**
	 * El porcentaje de devolucion de dinero en caso de retorno/cancelacion
	 */
	@Column(name="devolucion")
	private Integer devolucion;
	
	/**
	 * Hora de inicio del festival
	 */
	@Column(name="hora_inicio")
	private Time horaInicio;
	
	
	/**
	 * Las bandas que tocan durante la noche
	 */
	@ManyToMany(fetch=FetchType.EAGER) //si no es eager, hibernate intenta eliminar el contenido de la tabla Noche_Banda despues de leerlo... muy raro 
	@JoinTable(name="Noche_Banda", schema="DDS",
		joinColumns={
			@JoinColumn(name="id_noche", nullable = false, updatable = false)
		},
		inverseJoinColumns={
			@JoinColumn(name="id_banda", nullable = false, updatable = false)
		}
	)
	List<Banda> listaBandas;
	
	/**
	 * Las butacas existentes para esa noche
	 */
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_noche")
	private List<Butaca> butacas;

	/**
	 * @return the idNoche
	 */
	public Integer getIdNoche() {
		return idNoche;
	}

	/**
	 * @param idNoche the idNoche to set
	 */
	public void setIdNoche(Integer idNoche) {
		this.idNoche = idNoche;
	}

	/**
	 * @return the festival
	 */
	public Festival getFestival() {
		return festival;
	}

	/**
	 * @param festival the festival to set
	 */
	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the fechaFinAnticipada
	 */
	public Date getFechaFinAnticipada() {
		return fechaFinAnticipada;
	}

	/**
	 * @param fechaFinAnticipada the fechaFinAnticipada to set
	 */
	public void setFechaFinAnticipada(Date fechaFinAnticipada) {
		this.fechaFinAnticipada = fechaFinAnticipada;
	}

	/**
	 * @return the descuento
	 */
	public Integer getDescuento() {
		return descuento;
	}

	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(Integer descuento) {
		this.descuento = descuento;
	}

	/**
	 * @return the horaInicio
	 */
	public Time getHoraInicio() {
		return horaInicio;
	}

	/**
	 * @param horaInicio the horaInicio to set
	 */
	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	/**
	 * @return the listaBandas
	 */
	public List<Banda> getListaBandas() {
		return listaBandas;
	}

	/**
	 * @param listaBandas the listaBandas to set
	 */
	public void setListaBandas(List<Banda> listaBandas) {
		this.listaBandas = listaBandas;
	}

	/**
	 * @return the butacas
	 */
	public List<Butaca> getButacas() {
		return butacas;
	}

	/**
	 * @param butacas the butacas to set
	 */
	public void setButacas(List<Butaca> butacas) {
		this.butacas = butacas;
	}

	/**
	 * @return the devolucion
	 */
	public Integer getDevolucion() {
		return devolucion;
	}

	/**
	 * @param devolucion the devolucion to set
	 */
	public void setDevolucion(Integer devolucion) {
		this.devolucion = devolucion;
	}
	
}
