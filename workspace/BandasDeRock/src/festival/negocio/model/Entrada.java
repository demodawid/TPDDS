package festival.negocio.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Entrada", schema="DDS")
public class Entrada implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8245194543631781459L;
	
	/**
	 * Id interno de la entrada
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_entrada")
	private Integer idEntrada;
	
	/**
	 * La butaca asociada a la entrada 
	 */
	@OneToOne
	@JoinColumn(name="id_butaca")
	private Butaca butaca;
	
	/**
	 * Es anticipada?
	 */
	@Column(name="anticipada")
	private Boolean anticipada;
	
	/**
	 * El precio final cobrado por la entrada
	 */
	@Column(name="precio_final")
	private BigDecimal precioFinal;
	
	/**
	 * Fecha en la que fue realizada la venta
	 */
	@Column(name="fecha_venta")
	private Date fechaVenta;

	/**
	 * @return the idEntrada
	 */
	public Integer getIdEntrada() {
		return idEntrada;
	}

	/**
	 * @param idEntrada the idEntrada to set
	 */
	public void setIdEntrada(Integer idEntrada) {
		this.idEntrada = idEntrada;
	}

	/**
	 * @return the butaca
	 */
	public Butaca getButaca() {
		return butaca;
	}

	/**
	 * @param butaca the butaca to set
	 */
	public void setButaca(Butaca butaca) {
		this.butaca = butaca;
	}

	/**
	 * @return the anticipada
	 */
	public Boolean getAnticipada() {
		return anticipada;
	}

	/**
	 * @param anticipada the anticipada to set
	 */
	public void setAnticipada(Boolean anticipada) {
		this.anticipada = anticipada;
	}

	/**
	 * @return the precioFinal
	 */
	public BigDecimal getPrecioFinal() {
		return precioFinal;
	}

	/**
	 * @param precioFinal the precioFinal to set
	 */
	public void setPrecioFinal(BigDecimal precioFinal) {
		this.precioFinal = precioFinal;
	}

	/**
	 * @return the fechaVenta
	 */
	public Date getFechaVenta() {
		return fechaVenta;
	}

	/**
	 * @param fechaVenta the fechaVenta to set
	 */
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	
}
