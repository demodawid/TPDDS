package festival.negocio.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Butaca", schema="DDS")
public class Butaca implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 584983887655448757L;
	
	/**
	 * Id interno de la butaca
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_butaca")
	private Integer idButaca;
	
	/**
	 * La noche a la cual pertenece la butaca
	 */
	@ManyToOne
	@JoinColumn(name="id_noche")
	private Noche noche;
	
	/**
	 * El estado de la butaca
	 * 'O' = Ocupada, 'D' = Disponible
	 */
	@Column(name="estado")
	private Character estado;

	/**
	 * El numero de butaca
	 */
	@Column(name="numero")
	private Integer numero;
	
	/**
	 * El sector de la butaca
	 */
	@Column(name="sector")
	private String sector;
	
	/**
	 * El precio base de la butaca
	 */
	@Column(name="precio")
	private BigDecimal precioBase;
	
	/**
	 * La entrada asociada a la butaca (en caso de haberla)
	 */
	@OneToOne(cascade=CascadeType.ALL, mappedBy="butaca")
	private Entrada entrada;

	/**
	 * @return the idButaca
	 */
	public Integer getIdButaca() {
		return idButaca;
	}

	/**
	 * @param idButaca the idButaca to set
	 */
	public void setIdButaca(Integer idButaca) {
		this.idButaca = idButaca;
	}

	/**
	 * @return the noche
	 */
	public Noche getNoche() {
		return noche;
	}

	/**
	 * @param noche the noche to set
	 */
	public void setNoche(Noche noche) {
		this.noche = noche;
	}

	/**
	 * @return the estado
	 */
	public Character getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Character estado) {
		this.estado = estado;
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
	 * @return the sector
	 */
	public String getSector() {
		return sector;
	}

	/**
	 * @param sector the sector to set
	 */
	public void setSector(String sector) {
		this.sector = sector;
	}

	/**
	 * @return the precioBase
	 */
	public BigDecimal getPrecioBase() {
		return precioBase;
	}

	/**
	 * @param precioBase the precioBase to set
	 */
	public void setPrecioBase(BigDecimal precioBase) {
		this.precioBase = precioBase;
	}
	
	
}
