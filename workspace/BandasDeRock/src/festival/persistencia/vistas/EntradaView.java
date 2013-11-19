package festival.persistencia.vistas;

import java.util.Date;


public class EntradaView {
	private Integer idEntrada;
	private ButacaView butaca;
	private String anticipada;
	private String precioFinal;
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
	public ButacaView getButaca() {
		return butaca;
	}
	/**
	 * @param butaca the butaca to set
	 */
	public void setButaca(ButacaView butaca) {
		this.butaca = butaca;
	}
	/**
	 * @return the anticipada
	 */
	public String getAnticipada() {
		return anticipada;
	}
	/**
	 * @param anticipada the anticipada to set
	 */
	public void setAnticipada(String anticipada) {
		this.anticipada = anticipada;
	}
	/**
	 * @return the precioFinal
	 */
	public String getPrecioFinal() {
		return precioFinal;
	}
	/**
	 * @param precioFinal the precioFinal to set
	 */
	public void setPrecioFinal(String precioFinal) {
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
