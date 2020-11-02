import org.apache.log4j.Logger;
public class emplyeeTEST {
	private static final Logger l = Logger.getLogger(emplyeeTEST.class);
	public static void main(String[] args) { emplyeeTEST al = new emplyeeTEST(); al.getAllPrducts(); }
	public void getAllPrducts ()
	{
	try {
	l.info("In getAllPrducts() : ");

	l.debug("Je vais lancer la divsion.");
	//int i = 1/0;
	l.debug("Je viens de lancer la divsion. " + i);
	l.debug("Je viens de finir l'opération X.");
	l.info("Out getAllPrducts() without errors.");
	}
	catch (Exception e) { l.error("Erreur dans getAllPrducts() : " + e); }
	}
	}