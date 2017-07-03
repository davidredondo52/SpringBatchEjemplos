package profe.springbatch.listener;

import org.springframework.batch.core.SkipListener;

import profe.springbatch.model.Empleado;

public class EmpleadoSkipListener implements SkipListener<Empleado,Exception> {

	public void onSkipInRead(Throwable t) {
		System.out.println("onSkipInRead Throwable"+t);
		
	}

	public void onSkipInWrite(Exception item, Throwable t) {
		System.out.println("onSkipInWrite exception"+item+" throwable "+t);
		
	}

	public void onSkipInProcess(Empleado item, Throwable t) {
		System.out.println("onSkipInProcess Empleado"+item+" throwable "+t);
		
	}

}
