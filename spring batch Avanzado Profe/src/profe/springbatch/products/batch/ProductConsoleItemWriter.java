package profe.springbatch.products.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import profe.springbatch.products.model.Product;

public class ProductConsoleItemWriter implements ItemWriter<Product> {

	@Override
	public void write(List<? extends Product> products) throws Exception {
		for (Product product : products) {
			System.out.println(product);
		}
		
	}

}
