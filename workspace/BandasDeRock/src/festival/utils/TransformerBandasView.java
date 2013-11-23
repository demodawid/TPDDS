package festival.utils;

import festival.negocio.model.Banda;
import festival.presentacion.vistas.BandaView;

public class TransformerBandasView {
	public static BandaView transformBanda(Banda banda){
		BandaView bandaView = new BandaView();
		bandaView.setIdBanda(banda.getIdBanda());
		bandaView.setNombre(banda.getNombre());
		return bandaView;
	}
}
