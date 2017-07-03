package profe.springbatch.empleados.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestEmpleadosJob {

	@Autowired
	private JobLauncher jobLauncher;
	
	@Resource(name="importMultiItems")
	private Job jobMI;
	
	@Resource(name="importEmpleados")
	private Job jobEmps;
	
	@Resource(name="muestraEmpleadosFromDb")
	private Job jobEmpsBdConsole;
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new
				ClassPathXmlApplicationContext(new String[] {"job-context.xml"});
		TestEmpleadosJob test = (TestEmpleadosJob) context.getBean("testEmpleadosJob");
		test.go();
	}
	
	private void go() throws Exception {
		this.importEmpleados();
	}
	
	private void muestraEmpleadosFromDb() throws Exception {
		jobLauncher.run(jobEmpsBdConsole, new JobParametersBuilder()
				.addLong("timestamp", System.currentTimeMillis())
				.toJobParameters());
	}

	private void importMultiItems() throws Exception {
		jobLauncher.run(jobMI, new JobParametersBuilder()
				.addString("inputDir", "./data/empleados-input/")
				.addString("inputMultiItemsFileDelOneLine", "empleprods.txt")
				.addLong("timestamp", System.currentTimeMillis())
				.toJobParameters());
	}

	private void importEmpleados() throws Exception {
		jobLauncher.run(jobEmps, new JobParametersBuilder()
				.addString("inputDir", "./data/empleados-input/")
				.addString("inputFileDelOneLine", "empleados-delimited.txt")
				.addString("inputFileDelMultiLine", "empleados-delimited-multiline.txt")
				.addString("inputFileJson", "empleados.json")
				.addLong("timestamp", System.currentTimeMillis())
				.toJobParameters());
	}

}
