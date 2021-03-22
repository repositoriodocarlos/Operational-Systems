package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {
	private int idCarro;
	private Semaphore semaforo;
	private String sentido;
	
	public ThreadCarro(int idCarro, Semaphore semaforo){
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}
	
	public void run(){
		try {
			semaforo.acquire();
			andar();
			System.out.println("O carro " + idCarro + " está andando para " + sentido);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally{
			semaforo.release();
		}
	}
	
	private void andar(){
		switch (idCarro){
		case 1:
			sentido = "a direita.";			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			sentido = "cima.";
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			sentido = "a esquerda.";
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 4:
			sentido = "baixo";
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		}			
	}
	
}
