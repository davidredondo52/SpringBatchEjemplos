package profe.springbatch.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import profe.springbatch.model.Empleado;

public class EmpleadoJdbcItemWriter implements ItemWriter<Empleado> {

	private interface ConstantesSQL{
		String INSERTA_EMPLEADO="insert into empleados values(?,?,?,?)";
		String UPDATE_EMPLEADO="Update empleados set nombre=?,apellidos=?,edad=?  where cif=?";
	}
	

	private JdbcTemplate jdbcTemplate;
	
	public EmpleadoJdbcItemWriter(DataSource ds) {
		jdbcTemplate=new JdbcTemplate(ds);
	}

	public void write(List<? extends Empleado> empleados) throws Exception {
		for(Empleado e:empleados){
			
			int updated=jdbcTemplate.update(ConstantesSQL.UPDATE_EMPLEADO,
					e.getNombre(),e.getApellidos(),e.getEdad(),e.getCif());
			
			if(updated==0){
				
				jdbcTemplate.update(ConstantesSQL.INSERTA_EMPLEADO,e.getCif(),
						e.getNombre(),e.getApellidos(),e.getEdad());
				
			}
			else
			{
				System.out.println("Empleado actualizado"+e);
			}
			
		}
		
	}
}
