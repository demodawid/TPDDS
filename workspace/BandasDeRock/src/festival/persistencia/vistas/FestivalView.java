package festival.persistencia.vistas;

import java.util.List;

public class FestivalView {
	private Integer idFestival;
	private List<NocheView> noches;
	private String nombre;
	private String predio;
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
	 * @return the noches
	 */
	public List<NocheView> getNoches() {
		return noches;
	}
	/**
	 * @param noches the noches to set
	 */
	public void setNoches(List<NocheView> noches) {
		this.noches = noches;
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
