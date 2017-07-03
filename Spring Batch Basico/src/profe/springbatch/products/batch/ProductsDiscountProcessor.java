package profe.springbatch.products.batch;

import java.math.BigDecimal;

import org.springframework.batch.item.ItemProcessor;

import profe.springbatch.products.model.Product;

public class ProductsDiscountProcessor implements ItemProcessor<Product, Product> {

    int descuento;
	@Override
	public Product process(Product product) throws Exception {
		double precio=product.getPrecio().doubleValue();
		precio=precio*(1-(descuento/100));
		product.setPrecio(new BigDecimal(precio));
		return product;
	}
	
	public void setDescuento(int descuento){
		this.descuento=descuento;
	}

}
