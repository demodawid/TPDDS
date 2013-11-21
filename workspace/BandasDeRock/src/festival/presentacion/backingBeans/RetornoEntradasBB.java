package festival.presentacion.backingBeans;

import festival.negocio.model.Entrada;
import festival.negocio.model.Festival;
import festival.negocio.model.Noche;
import festival.persistencia.dao.EntradaDAO;
import festival.persistencia.dao.EntradaDAOImpl;
import festival.persistencia.vistas.EntradaView;
import festival.persistencia.vistas.FestivalView;
import festival.persistencia.vistas.NocheView;
import festival.utils.ConstantesFestival;
import festival.utils.TransformerEntradasView;
import festival.utils.TransformerFestivalesView;
import festival.utils.TransformerNochesView;

public class RetornoEntradasBB {
	private String mensajeDeError;
	private Integer idEntradaARetornar;
	private Entrada entradaARetornarEntity;
	private EntradaView entradaARetornar;
	private FestivalView festivalDeLaEntradaARetornar;
	private NocheView nocheDeLaEntradaARetornar;
	
	
	public String verEntradaADevolver () {
		try {
			EntradaDAO entradaDAO = new EntradaDAOImpl();
			Entrada entradaEntity = entradaDAO.getEntityById(this.getIdEntradaARetornar());
			this.setEntradaARetornarEntity(entradaEntity);
			this.setEntradaARetornar(TransformerEntradasView.transormEntrada(entradaEntity));
			
			if (this.getEntradaARetornar() == null) {
				this.setMensajeDeError("La entrada es inexistente");
				return ConstantesFestival.FALLO;
			}
			
			Noche nocheEntity = entradaEntity.getButaca().getNoche();
			Festival festivalEntity = entradaEntity.getButaca().getNoche().getFestival();
			
			this.setFestivalDeLaEntradaARetornar(TransformerFestivalesView.transformFestival(festivalEntity));
			this.setNocheDeLaEntradaARetornar(TransformerNochesView.transformNoche(nocheEntity));
			
		} catch (Exception e) {
			this.setMensajeDeError("Error en la comunicacion con la base de datos");
			return ConstantesFestival.FALLO;
		}
		return ConstantesFestival.EXITO;
	}
	
	public String retornarEntrada() {
		try {
			EntradaDAO entradaDAO = new EntradaDAOImpl();
			entradaDAO.delete(this.getEntradaARetornarEntity());
		} catch (Exception e) {
			this.setMensajeDeError("Error interno en la base de datos");
			return ConstantesFestival.FALLO;
		}
		return ConstantesFestival.EXITO;
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
	public EntradaView getEntradaARetornar() {
		return entradaARetornar;
	}

	/**
	 * @param entradaARetornar the entradaARetornar to set
	 */
	public void setEntradaARetornar(EntradaView entradaARetornar) {
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

	/**
	 * @return the festivalDeLaEntradaARetornar
	 */
	public FestivalView getFestivalDeLaEntradaARetornar() {
		return festivalDeLaEntradaARetornar;
	}

	/**
	 * @param festivalDeLaEntradaARetornar the festivalDeLaEntradaARetornar to set
	 */
	public void setFestivalDeLaEntradaARetornar(
			FestivalView festivalDeLaEntradaARetornar) {
		this.festivalDeLaEntradaARetornar = festivalDeLaEntradaARetornar;
	}

	/**
	 * @return the nocheDeLaEntradaARetornar
	 */
	public NocheView getNocheDeLaEntradaARetornar() {
		return nocheDeLaEntradaARetornar;
	}

	/**
	 * @param nocheDeLaEntradaARetornar the nocheDeLaEntradaARetornar to set
	 */
	public void setNocheDeLaEntradaARetornar(NocheView nocheDeLaEntradaARetornar) {
		this.nocheDeLaEntradaARetornar = nocheDeLaEntradaARetornar;
	}

	/**
	 * @return the entradaARetornarEntity
	 */
	public Entrada getEntradaARetornarEntity() {
		return entradaARetornarEntity;
	}

	/**
	 * @param entradaARetornarEntity the entradaARetornarEntity to set
	 */
	public void setEntradaARetornarEntity(Entrada entradaARetornarEntity) {
		this.entradaARetornarEntity = entradaARetornarEntity;
	}
	
	
	
}
