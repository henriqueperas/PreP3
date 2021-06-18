package view;

import java.util.concurrent.Semaphore;

import controller.ArquivosController;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idFilme = 0; idFilme < 5; idFilme++) {
			Thread tFilme = new ArquivosController(idFilme, semaforo);
			tFilme.start();
		}
		

	}

}
