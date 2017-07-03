package profe.springbatch.products.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import profe.springbatch.products.model.Product;

public class ProductConsoleItemWriter implements ItemWriter<Product> {

	@Override
	public void write(List<? extends Product> prods) throws Exception {
		for(Product p:prods){
			System.out.println(p);
			
		}
		
	}

}
