package profe.springbatch.empleados.batch;

import org.springframework.classify.annotation.Classifier;

import profe.empleados.model.Empleado;

public class EmpleadoRouterClassifier {

	@Classifier
	public String classify(Empleado emp) {
		if (emp.getEdad() < 18) {
			return "M";
		} else {
			return "A";
		}
	}
}
