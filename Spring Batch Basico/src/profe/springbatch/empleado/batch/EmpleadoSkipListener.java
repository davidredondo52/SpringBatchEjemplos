package profe.springbatch.empleado.batch;

import org.springframework.batch.core.SkipListener;

import profe.springbatch.empleado.model.Empleado;

public class EmpleadoSkipListener implements SkipListener<Empleado, Empleado> {

	@Override
	public void onSkipInProcess(Empleado empleado, Throwable exception) {
		System.out.println("EmpleadoSkipListener onSkipInProcess empleado=>"+empleado+" exception=>"+exception);
		
	}

	@Override
	public void onSkipInRead(Throwable arg0) {
		System.out.println("EmpleadoSkipListener onSkipInRead Throwable=>"+arg0);
		
	}

	@Override
	public void onSkipInWrite(Empleado empleado, Throwable exception) {
		System.out.println("EmpleadoSkipListener onSkipInProcess empleado=>"+empleado+" exception=>"+exception);
		
	}

}
