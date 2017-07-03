package profe.springbatch.products.batch;

import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import profe.springbatch.products.model.Product;

public class ProductJdbcItemWriter implements ItemWriter<Product> {

	private interface ConstantesSQL{
		String INSERTA_PRODUCTO="insert into products values(?,?,?,?,?)";
		String UPDATE_PRODUCTO="Update products set name=?,description=?,price=?,update_timestamp=? where id=?";
	}
	

	private JdbcTemplate jdbcTemplate;
	
	public ProductJdbcItemWriter(DataSource ds) {
		jdbcTemplate=new JdbcTemplate(ds);
	}
	@Override
	public void write(List<? extends Product> prods) throws Exception {
		System.out.println("prods length=>"+prods.size()+"prods=>"+prods.toString());
		for(Product p:prods){
			System.out.println("Producto p=>"+p);
			int updated=jdbcTemplate.update(ConstantesSQL.UPDATE_PRODUCTO,
					p.getNombre(),p.getDescripcion(),p.getPrecio(),
					new Timestamp(System.currentTimeMillis()),p.getId());
			
			if(updated==0){
				
				jdbcTemplate.update(ConstantesSQL.INSERTA_PRODUCTO,p.getId(),
						p.getNombre(),p.getDescripcion(),p.getPrecio(),
						new Timestamp(System.currentTimeMillis()));
				System.out.println("Producto insertado");
			}
			else
			{
				System.out.println("Producto actualizado");
			}
			
		}
		
	}
}
