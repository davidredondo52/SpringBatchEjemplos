package profe.springbatch.products.batch;

import org.springframework.batch.item.file.transform.FieldExtractor;

import profe.springbatch.products.model.Product;

public class ProductoFieldExtractor implements FieldExtractor<Product> {


	int c=0;
	@Override
	public Object[] extract(Product producto) {
		c++;
		Object[] objetos = {"Producto "+producto.getId(),producto.getNombre(),producto.getDescripcion(),
				producto.getPrecio(),"Producto "+c};
		
		return objetos;
	}



	

}
