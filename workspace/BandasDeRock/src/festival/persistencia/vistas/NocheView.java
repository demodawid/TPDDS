package festival.persistencia.vistas;

import java.util.Date;
import java.util.List;

public class NocheView {
	private Integer idNoche;
	private String numero;
	private Date fecha;
	private Date fechaFinAnticipada;
	private List<BandaView> listaBandas;
	private String descuento;
	private Integer devolucion;
	private String horaInicio;
	private List<ButacaView> butacas;
	
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
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
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
	 * @return the listaBandas
	 */
	public List<BandaView> getListaBandas() {
		return listaBandas;
	}
	/**
	 * @param listaBandas the listaBandas to set
	 */
	public void setListaBandas(List<BandaView> listaBandas) {
		this.listaBandas = listaBandas;
	}
	/**
	 * @return the descuento
	 */
	public String getDescuento() {
		return descuento;
	}
	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(String descuento) {
		this.descuento = descuento;
	}
	/**
	 * @return the horaInicio
	 */
	public String getHoraInicio() {
		return horaInicio;
	}
	/**
	 * @param horaInicio the horaInicio to set
	 */
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	/**
	 * @return the butacas
	 */
	public List<ButacaView> getButacas() {
		return butacas;
	}
	/**
	 * @param butacas the butacas to set
	 */
	public void setButacas(List<ButacaView> butacas) {
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
