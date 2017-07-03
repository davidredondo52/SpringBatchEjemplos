package profe.springbatch.products.batch;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

public class CabeceraFileProducto implements FlatFileHeaderCallback {

	public CabeceraFileProducto() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void writeHeader(Writer writter) throws IOException {
		writter.append("CABECERA PRODUCTOS");
		writter.flush();
	}

}
