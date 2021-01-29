package hilos;

import utils.Music;

public class HiloMusica extends Thread {
	
	private Music musica;
	private boolean detenerMusicaMenu;
	
	public HiloMusica(Music music) {
		this.detenerMusicaMenu = false;
		this.musica = music;
	}
	
	public void run() {
		while(!detenerMusicaMenu) {
			musica.playMusicaMenu();
		}
	}
	
	public void stopMusicaMenu() {
		this.detenerMusicaMenu = true;
		this.musica.stop();
	}
};
