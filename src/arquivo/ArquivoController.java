package arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoController {
	
	public ArquivoController() {
		
	}
	
	/**
	 * O metodo le um arquivo e o separa cada linha em uma posicao diferente no ArrayList.
	 * @param path O caminho do arquivo
	 * @return Um arrayList com os dados lidos no arquivo.
	 * @throws IOException
	 */
	public ArrayList<String> readFile(String path) throws IOException {
		ArrayList<String> readout = new ArrayList<>();
		BufferedReader in = new BufferedReader(new FileReader(path));
		String line;

		while ((line = in.readLine()) != null) {
			if (!line.isEmpty()) {
				readout.add(line);
			}

		}
		
		in.close();
		
		return readout;
	}

}
