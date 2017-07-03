package profe.springbatch.test;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Qualifier("testJob")
public class TestJob {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "job-context.xml" });

		TestJob test = (TestJob) context.getBean("testJob");
		test.go();
	}

	private void go() throws Exception {
		ficherosEmpleados();
	}
	
	public void ficherosEmpleadosProductos() throws Exception
	{
		/*
		 * Solo se pueden lanzar instancias de job con distintos
		 * parametros(ejemplo:fecha) a no ser que de error y no se complete el
		 * job en ese caso si se puede volver a lanzar puedes consultar el
		 * estado del job q has lanzado con la siguiente sentencia de sql select
		 * * from batch
		 */
		
		jobLauncher.run(job,
				new JobParametersBuilder().addString("inputResource", "file:data/input/products.zip")
						.addString("targetDir", "./data/empleados-input/")						
						.addString("targetFile", "empleprods.txt")						
						.addLong("timestamp", System.currentTimeMillis()).toJobParameters());
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

}
