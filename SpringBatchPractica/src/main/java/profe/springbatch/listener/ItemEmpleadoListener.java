package profe.springbatch.listener;

import org.springframework.batch.core.ItemProcessListener;

import profe.springbatch.model.Empleado;

public class ItemEmpleadoListener implements ItemProcessListener<Empleado,Empleado> {

	public void afterProcess(Empleado arg0, Empleado arg1) {
		System.out.println("afterProcess Empleado 0"+arg0+" Empleado 1"+arg1);
		
	}

	public void beforeProcess(Empleado arg0) {
		System.out.println("beforeProcess Empleado 0"+arg0);
	}

	public void onProcessError(Empleado arg0, Exception arg1) {
		System.out.println("onProcessError Empleado 0"+arg0+" exception "+arg0);
		
	}

}
