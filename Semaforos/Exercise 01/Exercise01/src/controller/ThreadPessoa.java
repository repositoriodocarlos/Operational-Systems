package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadPessoa extends Thread {
	
	private int idPessoa;
	private Semaphore semaforo;
	private int caminho = 200;
	
	public ThreadPessoa(int idPessoa, Semaphore semaforo){
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}
	
	public void run(){
		andar();
		try{
			semaforo.acquire();
			passarPorta();
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally{
			semaforo.release();
		}
	}
	
	private void andar(){
		int caminhoPercorrido = 0;
		while(caminho >= 0){
			int velocidade = gerarAleatorios(4,6);
			long longTime = 1000;
			caminho -= velocidade;
			try {
				Thread.sleep(longTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Pessoa " + idPessoa + " andou " + velocidade + " metros.");
		}
	}
	
	private void passarPorta(){
		int time = (int) (Math.random() * 1001 + 1000);
		long longTime = (long) time;
		try {
			Thread.sleep(longTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("A Pessoa " + idPessoa + " cruzou a porta.");
	}
	
	public static int gerarAleatorios(int minimo, int maximo){
		Random random = new Random();
		return random.nextInt((maximo - minimo) + 1)  + minimo;
	}

}
