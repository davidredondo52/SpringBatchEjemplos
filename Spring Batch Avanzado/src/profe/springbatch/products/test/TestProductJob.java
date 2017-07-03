package profe.springbatch.products.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestProductJob {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "job-context.xml" });
	//	"job-product-bbdd-consola.xml" 
	//	"job-product-xml-context.xml"
		TestProductJob test = (TestProductJob) context.getBean("testProductJob");
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
		
		params();
		
	}
	private void params()throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "14-06-2018 01:00:00";
		Date date = sdf.parse(dateInString);
		jobLauncher.run(job,
				new JobParametersBuilder().addString("inputResource", "file:data/input/products.zip")
						.addString("targetDir", "./data/target/")
						// .addString("targetFile", "products-fixed.txt")
						.addString("targetFile", "products-delimited-two-lines.txt")
						 .addLong("timestamp", date.getTime())
					//	.addLong("timestamp", System.currentTimeMillis())
						 .toJobParameters());
	}
	private void paramsXML() throws Exception 
	{
		jobLauncher.run(job,
				new JobParametersBuilder()
						.addString("targetDir", "./data/input/")						
						.addString("targetFile", "products.xml")
						.addString("productsMappingFile", "mapping.xml")
						.addLong("timestamp", System.currentTimeMillis()).toJobParameters());
	}
	
	private void paramsJSON() throws Exception 
	{
		jobLauncher.run(job,
				new JobParametersBuilder()
						.addString("targetDir", "./data/input/")						
						.addString("targetFile", "products.xml")
						.addString("productsMappingFile", "mapping.xml")
						.addLong("timestamp", System.currentTimeMillis()).toJobParameters());
	}
	
	private void paramsBBDDConsola() throws Exception 
	{
		jobLauncher.run(job,
				new JobParametersBuilder()
						.addLong("timestamp", System.currentTimeMillis()).toJobParameters());
	}

}
