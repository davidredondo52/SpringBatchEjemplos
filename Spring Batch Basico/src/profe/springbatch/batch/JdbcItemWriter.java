package profe.springbatch.batch;

import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import profe.springbatch.empleado.model.Empleado;
import profe.springbatch.model.Item;
import profe.springbatch.products.model.Product;

public class JdbcItemWriter implements ItemWriter<Item> {

	private interface ConstantesSQL{
		String INSERTA_EMPLEADO="insert into empleados values(?,?,?,?)";
		String UPDATE_EMPLEADO="Update empleados set nombre=?,apellidos=?,edad=?  where cif=?";
		String INSERTA_PRODUCTO="insert into products values(?,?,?,?,?)";
		String UPDATE_PRODUCTO="Update products set name=?,description=?,price=?,update_timestamp=? where id=?";
	}
	

	private JdbcTemplate jdbcTemplate;
	
	public JdbcItemWriter(DataSource ds) {
		jdbcTemplate=new JdbcTemplate(ds);
	}
	@Override
	public void write(List<? extends Item> items) throws Exception {
		for(Item i:items){
			
			if(i instanceof Empleado){
			Empleado e=(Empleado)i;
			int updated=jdbcTemplate.update(ConstantesSQL.UPDATE_EMPLEADO,
					e.getNombre(),e.getApellidos(),e.getEdad(),e.getCif());
			
			if(updated==0){
				
				jdbcTemplate.update(ConstantesSQL.INSERTA_EMPLEADO,e.getCif(),
						e.getNombre(),e.getApellidos(),e.getEdad());
				System.out.println("Empleado insertado");
			}
			else
			{
				System.out.println("Empleado actualizado");
			}
			}
			
			if(i instanceof Product){
				Product p=(Product)i;
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
}
