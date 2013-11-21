package festival.presentacion.backingBeans;

import festival.negocio.model.Entrada;
import festival.persistencia.dao.EntradaDAO;
import festival.persistencia.dao.EntradaDAOImpl;
import festival.utils.ConstantesFestival;

public class RetornoEntradasBB {
	private String mensajeDeError;
	private Integer idEntradaARetornar;
	private Entrada entradaARetornar;
	
	
	public String verEntradaADevolver () {
		try {
			EntradaDAO entradaDAO = new EntradaDAOImpl();
			this.setEntradaARetornar(entradaDAO.getEntityById(this.getIdEntradaARetornar()));
			if (this.getEntradaARetornar() == null) {
				this.setMensajeDeError("La entrada es inexistente");
				return ConstantesFestival.FALLO;
			}
		} catch (Exception e) {
			this.setMensajeDeError("Error en la comunicacion con la base de datos");
			return ConstantesFestival.FALLO;
		}
		return ConstantesFestival.EXITO;
	}
	
	public String retornarEntrada() {
		
		return null;
	}
	
	public String iniciarRetornoEntrada(){
		this.setEntradaARetornar(null);
		this.setIdEntradaARetornar(null);
		this.setMensajeDeError(null);
		return "retornarEntrada";
	}
	
	/**
	 * @return the idEntradaARetornar
	 */
	public Integer getIdEntradaARetornar() {
		return idEntradaARetornar;
	}

	/**
	 * @param idEntradaARetornar the idEntradaARetornar to set
	 */
	public void setIdEntradaARetornar(Integer idEntradaARetornar) {
		this.idEntradaARetornar = idEntradaARetornar;
	}

	/**
	 * @return the entradaARetornar
	 */
	public Entrada getEntradaARetornar() {
		return entradaARetornar;
	}

	/**
	 * @param entradaARetornar the entradaARetornar to set
	 */
	public void setEntradaARetornar(Entrada entradaARetornar) {
		this.entradaARetornar = entradaARetornar;
	}

	/**
	 * @return the mensajeDeError
	 */
	public String getMensajeDeError() {
		return mensajeDeError;
	}

	/**
	 * @param mensajeDeError the mensajeDeError to set
	 */
	public void setMensajeDeError(String mensajeDeError) {
		this.mensajeDeError = mensajeDeError;
	}
}
