package tn.esprit.spring;
import org.apache.log4j.Logger;
	
public class AffichageLogHela {

	
		private static final Logger l = Logger.getLogger(AffichageLogHela.class);
		public static void main(String[] args) { AffichageLogHela al = new AffichageLogHela(); al.getAllEntreprises(); }
		
		public void getAllEntreprises ()
		{
		try {
		l.info("In getAllEntreprises() : ");

		l.debug("Je vais lancer la divsion.");
		//int i = 1/1;
		l.debug("Je viens de lancer la divsion. " );
		l.debug("Je viens de finir l'opération X.");
		l.info("Out getAllEntreprises() without errors.");
		}
		catch (Exception e) { l.error("Erreur dans getAllEntreprises() : " + e); }
		}
		
}
