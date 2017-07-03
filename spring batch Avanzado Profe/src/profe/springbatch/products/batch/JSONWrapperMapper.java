package profe.springbatch.products.batch;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.JsonLineMapper;
import org.springframework.beans.factory.annotation.Autowired;

import profe.springbatch.products.model.Product;

public class JSONWrapperMapper implements LineMapper<Product> {

	@Autowired
	private JsonLineMapper jsonLineMapper;
	
	@Override
	public Product mapLine(String line, int numLine) throws Exception {
		Map<String, Object> productAsMap = jsonLineMapper.mapLine(line, numLine);
		Product product = new Product();
		product.setId((String) productAsMap.get("id"));
		product.setNombre((String) productAsMap.get("name"));
		product.setDescripcion((String) productAsMap.get("description"));
		product.setPrecio(new BigDecimal((Double) productAsMap.get("price")));
		
		return product;
	}

}
