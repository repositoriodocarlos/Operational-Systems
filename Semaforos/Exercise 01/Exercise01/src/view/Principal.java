package view;

import java.util.concurrent.Semaphore;

import controller.ThreadPessoa;

public class Principal {
	
	public static void main(String args[]){
		int permissoes = 1;	
		Semaphore semaforo = new Semaphore(permissoes);	 
		
		for(int idPessoa = 1; idPessoa <= 4; idPessoa ++){
			Thread pessoa = new ThreadPessoa(idPessoa,semaforo);
			pessoa.start();		
		}
	}
}
