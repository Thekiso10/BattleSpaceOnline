import Principal.Menu;
import Utils.Config;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		/* Cargar el archivo config */
		Config config = new Config();
		validarConfig(config);
		/* Cargar el menu */
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            		new Menu(config);
                }
           	});
	}

	public static void validarConfig(Config config){
		//Validar la configuracion
		System.out.println("[INFO] - Validar archivo de configuracion");
		//Cargar la configuración externa
		try{
			config.load(config.getExternalConfig());
		}catch (IOException e){
			System.out.println("[ERROR] - No se ha podido cargar el archivo de configuracion");
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}

}
