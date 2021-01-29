package principal;

import swing.jFrams.MarcoMenu;
import utils.Config;
import utils.Music;
import hilos.HiloMusica;

 public class Menu {
	 private HiloMusica musica;
	 
	 public Menu(Config config) {
		 Music music = new Music(Integer.parseInt(config.getProperty("battleSpaceOnline.config.music.volume", "1")));
		 //Cargar musica
		 HiloMusica musica = new HiloMusica(music);
		 /*musica.start();*/
		 //Crear objecto partida
		 Partida partida = new Partida(music, musica);
		 //Cargar JFrame
		 @SuppressWarnings("unused")
		 MarcoMenu m = new MarcoMenu(config, partida);

	 }
}
 
 