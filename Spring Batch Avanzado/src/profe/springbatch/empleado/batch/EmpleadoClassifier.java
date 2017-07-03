package profe.springbatch.empleado.batch;

import org.springframework.batch.support.annotation.Classifier;

import profe.springbatch.empleado.model.Empleado;

public class EmpleadoClassifier {

	public EmpleadoClassifier() {
		// TODO Auto-generated constructor stub
	}
	
	 @Classifier
     public String classify(Empleado classifiable) {
		 if(classifiable.getEdad()<18)
			 return "menor";
		 else return "mayor";
        
     }

}
