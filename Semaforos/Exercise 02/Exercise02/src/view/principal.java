package view;

import java.util.concurrent.Semaphore;
import controller.ThreadCarro;

public class principal {

	public static void main(String[] args) {
	
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		int contador = 0;
		
		while(contador < 50){
			for(int idCarro = 1; idCarro <= 4; idCarro ++){
				Thread pessoa = new ThreadCarro(idCarro, semaforo);		
				pessoa.start();
			}	
			contador ++;
		}
	}

}
