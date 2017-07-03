package profe.springbatch.empleado.batch;

import org.springframework.batch.item.file.transform.FieldExtractor;

import profe.springbatch.empleado.model.Empleado;

public class EmpleadoFieldExtractor implements FieldExtractor<Empleado> {


	int c=0;
	@Override
	public Object[] extract(Empleado empleado) {
		c++;
		Object[] objetos = {"Empleado "+empleado.getCif(),empleado.getNombre(),empleado.getApellidos(),
				empleado.getEdad(),"Empleado  "+(empleado.getEdad()<18?"Menor de edad":"Mayor de edad")};
		
		return objetos;
	}



	

}
