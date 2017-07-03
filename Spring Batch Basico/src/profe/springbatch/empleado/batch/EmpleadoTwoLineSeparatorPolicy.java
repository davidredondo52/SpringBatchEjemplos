package profe.springbatch.empleado.batch;

import org.springframework.batch.item.file.separator.RecordSeparatorPolicy;

public class EmpleadoTwoLineSeparatorPolicy implements RecordSeparatorPolicy {

	  @Override
	    public boolean isEndOfRecord(String lineAcumulada) {
		
		  
		 
		  return (lineAcumulada.indexOf(';') != - 1 ? true : false);
	    }
	    @Override
	    public String postProcess(String record) {
	    	
	    	return record.substring(0, record.length() - 1);
	    }
	    @Override
	    public String preProcess(String line) {
	    
	        return line;
	    }
	   

}
