package profe.springbatch.products.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import profe.springbatch.products.model.Product;

public class ProductFieldSetMapper implements FieldSetMapper<Product> {

	@Override
	public Product mapFieldSet(FieldSet fieldSet) throws BindException {
		Product producto = new Product();
		producto.setId(fieldSet.readString("id_producto"));
		producto.setNombre(fieldSet.readString("name"));
		producto.setDescripcion(fieldSet.readString("desc"));
		producto.setPrecio(fieldSet.readBigDecimal("pvp"));
		return producto;
	}

}
