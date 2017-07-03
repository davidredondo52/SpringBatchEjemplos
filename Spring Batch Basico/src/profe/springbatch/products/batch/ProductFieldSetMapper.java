package profe.springbatch.products.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import profe.springbatch.products.model.Product;

public class ProductFieldSetMapper implements FieldSetMapper<Product>{

	@Override
	public Product mapFieldSet(FieldSet fieldSet) throws BindException {
		Product producto=new Product();
		producto.setId(fieldSet.readString("PRODUCT_ID"));
		producto.setNombre(fieldSet.readString("NAME"));
		producto.setDescripcion(fieldSet.readString("DESCRIPTION"));
		producto.setPrecio(fieldSet.readBigDecimal ("PRICE"));
		return producto;
	}

}
