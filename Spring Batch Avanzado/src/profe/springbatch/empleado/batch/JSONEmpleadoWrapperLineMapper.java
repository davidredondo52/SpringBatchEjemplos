package profe.springbatch.empleado.batch;

import java.util.Map;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.JsonLineMapper;
import org.springframework.beans.factory.annotation.Autowired;

import profe.springbatch.empleado.model.Empleado;

public class JSONEmpleadoWrapperLineMapper implements LineMapper<Empleado>
{
	@Autowired
	private JsonLineMapper jsonLineMapper;
	@Override
	public Empleado mapLine(String line, int numline) throws Exception {
		
		
		Map<String,Object> productAsMap=jsonLineMapper.mapLine(line, numline);
		
		Empleado empleado=new Empleado();
		empleado.setCif((String)productAsMap.get("cif"));
		empleado.setNombre((String)productAsMap.get("nombre"));
		empleado.setApellidos((String)productAsMap.get("apellidos"));
		empleado.setEdad((int)productAsMap.get("edad"));
		return empleado;
		
	}

}
