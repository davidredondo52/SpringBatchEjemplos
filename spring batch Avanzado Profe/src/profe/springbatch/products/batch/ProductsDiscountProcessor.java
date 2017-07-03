package profe.springbatch.products.batch;

import java.math.BigDecimal;

import org.springframework.batch.item.ItemProcessor;

import profe.springbatch.products.model.Product;

public class ProductsDiscountProcessor implements ItemProcessor<Product, Product> {

	private int descuento;
	
	@Override
	public Product process(Product product) throws Exception {
		float pvp = product.getPrecio().floatValue();
		product.setPrecio(product.getPrecio().multiply(new BigDecimal(100 - descuento)).divide(new BigDecimal (100)));
		return product;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

}
