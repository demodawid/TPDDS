package festival.utils;

import festival.negocio.model.Entrada;
import festival.persistencia.vistas.EntradaView;

public class TransformerEntradasView {
	public static EntradaView transormEntrada(Entrada entrada){
		EntradaView entradaView = new EntradaView();
		if (entrada != null) {
			if (entrada.getAnticipada()) {
				entradaView.setAnticipada("Si");
			} else {
				entradaView.setAnticipada("No");
			}
			
			entradaView.setButaca(
					TransformerButacasView.transformButaca(entrada.getButaca())
					);
			entradaView.setFechaVenta(entrada.getFechaVenta());
			entradaView.setIdEntrada(entrada.getIdEntrada());
			entradaView.setPrecioFinal(entrada.getPrecioFinal().toString());
			
			return entradaView;
		}
		return null;
	}
}
