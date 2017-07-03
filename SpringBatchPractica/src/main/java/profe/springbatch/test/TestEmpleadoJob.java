package profe.springbatch.test;

import java.text.SimpleDateFormat;
import java.util.Date;

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

		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "job-context.xml" });

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

	public void ficherosEmpleados() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String stringFechaConHora = "2014-09-15 15:03:23";
		Date fechaConHora = sdf.parse(stringFechaConHora);
		jobLauncher.run(job,
				new JobParametersBuilder().addString("targetDir", "./data/input/")
						.addString("targetFile", "empleados-delimited.txt")
						.addString("targetFile2", "empleados.json")
						.addLong("timestamp", System.currentTimeMillis()).toJobParameters());
						//.addLong("timestamp", fechaConHora.getTime()).toJobParameters());
	}

}
