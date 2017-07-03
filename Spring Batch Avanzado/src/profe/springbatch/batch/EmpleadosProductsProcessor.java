package profe.springbatch.batch;

import java.math.BigDecimal;

import org.springframework.batch.item.ItemProcessor;

import profe.springbatch.empleado.model.Empleado;
import profe.springbatch.products.model.Product;

public class EmpleadosProductsProcessor implements ItemProcessor<Empleado, Product> {

	@Override
	public Product process(Empleado empleado) throws Exception {
		Product p = new Product();
		String id = empleado.getCif().substring(0, empleado.getCif().length() - 1);
		p.setId(id);
		p.setNombre(empleado.getNombre());
		p.setDescripcion(empleado.getApellidos());
		p.setPrecio(new BigDecimal((double) empleado.getEdad()));
		
		return p;
	}

}
