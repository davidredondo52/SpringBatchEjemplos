package profe.springbatch.empleado.test;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Qualifier("testEmpleadoJob")
public class TestEmpleadoJob {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	public static void main(String[] args) throws Exception {
		
		/*
		 * 1º Ejercicio haremos uso del fichero job-context-empleado_3_pasos.xml compuesto a su vez por 
		 * import-empleado-job-context.xml y mysql-context.xml
		 * Se trata de procesar 
		 * a-Lectura de fichero plano de empleados
		 * b-Lectura Multilinea de empleados
		 * c-Lectura de Json de empleados
		 * 
		 * 	 * 2º Ejercicio haremos uso del fichero job-empleado-wrapper_context.xml compuesto a su vez por 
		 * import-empleado-job-wrapper-context.xml y mysql-context.xml
		 * Se trata de procesar los ficheros pero mapeando directamente los datos con una clase empleado
		 * 	 <bean id="empleadoFieldSetMapper"
            class="org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper">
              <property name="prototypeBeanName" value="empleado"/>
              </bean>
    
              <bean id="empleado"
            class="profe.springbatch.empleado.model.Empleado" scope="prototype"></bean>
		 * a-Lectura de fichero plano de empleados
		 * b-Lectura Multilinea de empleados
		 * c-Lectura de Json de empleados
		 * 
		 * 3ª Ejercicio mezcla de datos de empleados y productos en un mismo fichero
		 * job-context-emplprod.xml compuesto import-emplprods-job-context.xml y mysql-context.xml
		 * se trata de distinguir 
		 */
		
		
		//1º job-context-empleado_3_pasos.xml 2º job-empleado-wrapper_context.xml y 3ºjob-context-emplprod.xml
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "job-context-empleados.xml" });

		TestEmpleadoJob test = (TestEmpleadoJob) context.getBean("testEmpleadoJob");
		test.go();
	}

	private void go() throws Exception {
		/*
		 * Solo se pueden lanzar instancias de job con distintos
		 * parametros(ejemplo:fecha) a no ser que de error y no se complete el
		 * job en ese caso si se puede volver a lanzar puedes consultar el
		 * estado del job q has lanzado con la siguiente sentencia de sql select
		 * * from batch
		 */
		
		ficherosEmpleados();
	}

	public void ficherosEmpleados() throws Exception
	{
		jobLauncher.run(job,
				new JobParametersBuilder()
						.addString("targetDir", "./data/empleados-input/")						
						.addString("targetFile", "empleados-delimited.txt")
						.addString("targetFile2", "empleados-delimited-multiline.txt")
						.addString("targetFile3", "empleados.json")
						.addLong("timestamp", System.currentTimeMillis()).toJobParameters());
	}
	
	public void ficherosEmpleadosWrapper() throws Exception
	{
		jobLauncher.run(job,
				new JobParametersBuilder()
						.addString("targetDir", "./data/empleados-input/")						
						.addString("targetFile", "empleados-delimited.txt")
						.addString("targetFile2", "empleados-delimited-multiline.txt")
						.addString("targetFile3", "empleados.json")
						.addLong("timestamp", System.currentTimeMillis()).toJobParameters());
	}
	
	public void ficherosProductosEmpleadosWrapper() throws Exception
	{
		jobLauncher.run(job,
				new JobParametersBuilder()
						.addString("targetDir", "./data/empleados-input/")						
						.addString("targetFile", "empleprods.txt")						
						.addLong("timestamp", System.currentTimeMillis()).toJobParameters());
	}
}
