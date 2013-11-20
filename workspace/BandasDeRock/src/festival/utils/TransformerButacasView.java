package festival.utils;

import festival.negocio.model.Butaca;
import festival.persistencia.vistas.ButacaView;

public class TransformerButacasView {
	public static ButacaView transformButaca(Butaca butaca, Integer descuento){
		ButacaView butacaView = new ButacaView();
		
		butacaView.setIdButaca(butaca.getIdButaca());
		butacaView.setNumero(butaca.getNumero());
		butacaView.setPrecioBase(butaca.getPrecioBase());
		butacaView.setSector(butaca.getSector());
		butacaView.setDescuento(descuento);
		if (butaca.getEntrada() == null) {
			butacaView.setDisponible("Si");
		} else {
			butacaView.setDisponible("No");
			butacaView.setIdEntrada(butaca.getEntrada().getIdEntrada());
		}
		return butacaView;
	}
}
