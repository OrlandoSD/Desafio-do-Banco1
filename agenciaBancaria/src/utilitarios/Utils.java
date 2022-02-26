package utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
	
	static NumberFormat formatandoValores = new DecimalFormat("R$ #.##0.00");
		
	public static String formatandoValores(Double valor) {
		
		return formatandoValores(valor);
	}
}
