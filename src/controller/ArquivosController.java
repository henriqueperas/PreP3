package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ArquivosController extends Thread {
	
	private int idFilme;
	private Semaphore semaforo;

	String testeB[] = new String[200]; 
	int interB;
	int inter = 0;
	String[] testeA;
	String genero;
	String titulo; 
	String sub;
	String ano;
	String generoB[] = new String[200];
	String tituloB[] = new String[200]; 
	String subB[] = new String[200];
	String anoB[] = new String[200];
	
	String path = "C:\\TEMP2";
	String name = "netflix.csv";
	
	public ArquivosController(int idFilme, Semaphore semaforo) {
		this.idFilme = idFilme;
		this.semaforo = semaforo;
	}
	
	public void run() {
		

		try {
			semaforo.acquire();
			readFile(path, name);
			separacao();
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
			// fim seção critica
		}
		
	}
	
	public void readFile(String path, String name) throws IOException {
		File arq = new File(path, name);
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			interB = 0;
			while (linha != null) {
				testeA = linha.split(";");
				generoB[interB] = testeA[0];
				tituloB[interB] = testeA[1];
				subB[interB] = testeA[2];
				anoB[interB] = testeA[4];
				interB = interB + 1;
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}else {
			throw new IOException("Diretorio invalido");
		}
		
	}

	public void separacao() throws IOException {
		// TODO Auto-generated method stub
		if(idFilme == 0) {
			System.out.println("---------------Filmes de 2013------------- \n");
			for(int j = 1; j < interB; j++) {
				String teste = anoB[j];
				String teste2 = teste.substring(0, 4);
				if(teste2.equalsIgnoreCase("2013")) {
					System.out.println(tituloB[j] + "			" + generoB[j] + "			" + subB[j]);
				}
			}
			System.out.println("\n");
		}else if(idFilme == 1) {
			System.out.println("---------------Filmes de 2014------------- \n");
			for(int j = 1; j < interB; j++) {
				String teste1 = anoB[j];
				String teste12 = teste1.substring(0, 4);
				if(teste12.equalsIgnoreCase("2014")) {
					System.out.println(tituloB[j] + "			" + generoB[j] + "			" + subB[j]);
				}
			}
			System.out.println("\n");
		}else if(idFilme == 2) {
			System.out.println("---------------Filmes de 2015------------- \n");
			for(int j = 1; j < interB; j++) {
				String teste2 = anoB[j];
				String teste22 = teste2.substring(0, 4);
				if(teste22.equalsIgnoreCase("2015")) {
					System.out.println(tituloB[j] + "			" + generoB[j] + "			" + subB[j]);
				}
			}
			System.out.println("\n");
		}else if(idFilme == 3) {
			System.out.println("---------------Filmes de 2016------------- \n");
			for(int j = 1; j < interB; j++) {
				String teste3 = anoB[j];
				String teste32 = teste3.substring(0, 4);
				if(teste32.equalsIgnoreCase("2016")) {
					System.out.println(tituloB[j] + "			" + generoB[j] + "			" + subB[j]);
				}
			}
			System.out.println("\n");
		}else if(idFilme == 4) {
			System.out.println("---------------Filmes de 2017------------- \n");
			for(int j = 1; j < interB; j++) {
				String teste4 = anoB[j];
				String teste42 = teste4.substring(0, 4);
				if(teste42.equalsIgnoreCase("2017")) {
					System.out.println(tituloB[j] + "			" + generoB[j] + "			" + subB[j]);
				}
			}
			System.out.println("\n");
		}
	}
	
}
