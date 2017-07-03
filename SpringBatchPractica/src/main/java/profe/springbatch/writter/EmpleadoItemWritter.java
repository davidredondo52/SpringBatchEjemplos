package profe.springbatch.writter;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import profe.springbatch.model.Empleado;

public class EmpleadoItemWritter implements ItemWriter<Empleado> {

	public void write(List<? extends Empleado> items) throws Exception {
		for(Empleado e:items)
		{
			System.out.println("EmpleadoItemWritter Imprimo empleado"+e);
		}
		
	}

}
