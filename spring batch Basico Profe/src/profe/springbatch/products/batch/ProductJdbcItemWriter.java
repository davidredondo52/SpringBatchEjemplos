package profe.springbatch.products.batch;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import profe.springbatch.products.model.Product;

public class ProductJdbcItemWriter implements ItemWriter<Product> {

	private interface ConstantesSQL {
		
		String INSERTA_PRODUCTO = 
				"INSERT INTO products (id, name, description, price) VALUES(?,?,?,?)";
		
		String MODIFICA_PRODUCTO = 
				"UPDATE products SET name=?, description=?, price=? "
				+ "WHERE id=?";
		
	}
	
	private JdbcTemplate jdbcTemplate;
	
	public ProductJdbcItemWriter(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public void write(List<? extends Product> products) throws Exception {
		for (Product product : products) {
			int updated = jdbcTemplate.update(ConstantesSQL.MODIFICA_PRODUCTO,
					product.getNombre(), product.getDescripcion(), 
					product.getPrecio(), product.getId());
			if (updated==0) {
				jdbcTemplate.update(ConstantesSQL.INSERTA_PRODUCTO,
						product.getId(),
						product.getNombre(), product.getDescripcion(), 
						product.getPrecio());
				System.out.println("Producto insertado");
			} else {
				System.out.println("Producto actualizado");

			}
		}
		
	}

}
