package controller;

import java.io.IOException;

public interface IArquivosController{

	public void readFile(String path, String name) throws IOException;
	public void separacao() throws IOException;
	
}
