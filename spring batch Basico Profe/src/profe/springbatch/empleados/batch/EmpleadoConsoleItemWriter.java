package profe.springbatch.empleados.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import profe.empleados.model.Empleado;

public class EmpleadoConsoleItemWriter implements ItemWriter<Empleado> {

	@Override
	public void write(List<? extends Empleado> empleados) throws Exception {
		for (Empleado empleado : empleados) {
			System.out.println(empleado);
		}
		
	}

}
