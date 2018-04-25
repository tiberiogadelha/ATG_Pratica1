package arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArquivoController {
	
	public ArquivoController() {
		
	}
	
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
