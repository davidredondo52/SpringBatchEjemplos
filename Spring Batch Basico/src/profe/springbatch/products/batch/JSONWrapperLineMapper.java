package profe.springbatch.products.batch;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.JsonLineMapper;
import org.springframework.beans.factory.annotation.Autowired;

import profe.springbatch.products.model.Product;

public class JSONWrapperLineMapper implements LineMapper<Product>
{
	@Autowired
	private JsonLineMapper jsonLineMapper;
	@Override
	public Product mapLine(String line, int numline) throws Exception {
		
		Map<String,Object> productAsMap=jsonLineMapper.mapLine(line, numline);
		Product producto=new Product();
		producto.setId((String)productAsMap.get("id"));
		producto.setNombre((String)productAsMap.get("name"));
		producto.setDescripcion((String)productAsMap.get("description"));
		producto.setPrecio(new BigDecimal((Double)productAsMap.get("price")));
		return producto;
	}

}
