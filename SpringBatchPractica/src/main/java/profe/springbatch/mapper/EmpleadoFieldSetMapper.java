package profe.springbatch.mapper;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import profe.springbatch.model.Empleado;

public class EmpleadoFieldSetMapper implements FieldSetMapper<Empleado>
{

	public Empleado mapFieldSet(FieldSet fieldSet) throws BindException {
		Empleado empleado=new Empleado();
		empleado.setCif(fieldSet.readString("ID"));
		empleado.setNombre(fieldSet.readString("NOMBRE"));
		empleado.setApellidos(fieldSet.readString("APELLIDOS"));
		empleado.setEdad(fieldSet.readInt("EDAD"));
		return empleado;
	}

}
