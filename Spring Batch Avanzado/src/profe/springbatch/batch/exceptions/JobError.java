package profe.springbatch.batch.exceptions;

import org.springframework.oxm.XmlMappingException;

public class JobError extends XmlMappingException {

	public JobError(String msg) {
		super(msg);
		System.out.println(msg);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	
}
