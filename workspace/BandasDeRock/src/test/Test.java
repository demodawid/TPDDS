package test;

import org.hibernate.Session;

import festival.negocio.model.Entrada;
import festival.utils.HibernateUtil;


public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		
		
		Entrada unaEntrada = (Entrada) session.get(Entrada.class, 2);
		
		String nombreFestival = unaEntrada.getButaca().getNoche().getFestival().getNombre();
		
		System.out.println("Se obtuvo una entrada del festival: " + nombreFestival);
		
		HibernateUtil.getSessionFactory().close();
	}
}
