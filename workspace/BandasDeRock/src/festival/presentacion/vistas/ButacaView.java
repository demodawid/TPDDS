package festival.presentacion.vistas;

import java.math.BigDecimal;


public class ButacaView {
	private Integer idButaca;
	private Integer numero;
	private String sector;
	private BigDecimal precioBase;
	private String disponible;
	private Integer idEntrada;
	private Integer descuento;
	private Integer devolucion;
	
	/**
	 * Metodo que calcula el precio con descuento
	 */
	public String getPrecioConDescuento() {
		return this.getPrecioBase()
					.subtract(
						this.getPrecioBase().multiply(BigDecimal.valueOf(descuento))
											.divide(new BigDecimal(100))
							).toString();
	}
	
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
	/**
	 * @return the disponible
	 */
	public String getDisponible() {
		return disponible;
	}
	/**
	 * @param disponible the disponible to set
	 */
	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}
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
