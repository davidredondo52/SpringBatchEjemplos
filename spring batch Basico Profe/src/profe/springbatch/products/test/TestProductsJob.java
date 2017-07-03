package profe.springbatch.products.test;

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
public class TestProductsJob {

	@Autowired
	private JobLauncher jobLauncher;
	
	@Resource(name="importProducts")
	private Job job;
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new
				ClassPathXmlApplicationContext(new String[] {"job-context.xml"});
		TestProductsJob test = (TestProductsJob) context.getBean("testProductsJob");
		test.go();
	}
	
	private void go() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "14-06-2018 01:00:00";
		Date date = sdf.parse(dateInString);
		jobLauncher.run(job, new JobParametersBuilder()
				.addString("inputResource", "file:data/input/products.zip")
				.addString("targetDir", "./data/target/")
				.addString("xmlProductsFile", "products.xml")
				.addString("productsMappingFile", "mapping.xml")
//				.addLong("timestamp", date.getTime())
				.addLong("timestamp", System.currentTimeMillis())
				.toJobParameters());
	}

}
