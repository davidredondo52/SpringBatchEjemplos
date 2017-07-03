package profe.springbatch.empleado.batch;

import org.springframework.batch.core.ItemReadListener;

import profe.springbatch.empleado.model.Empleado;

public class ItemEmpleadoListener implements ItemReadListener<Empleado> {

	@Override
	public void afterRead(Empleado empleado) {
		System.out.println("****afterRead=>"+empleado);
		
	}

	@Override
	public void beforeRead() {
		System.out.println("****beforeRead=>"+this.toString());
	}

	@Override
	public void onReadError(Exception exception) {
		System.out.println("*****onReadError=>"+exception);
		
	}

}
