package profe.springbatch.products.batch;

import org.springframework.batch.item.file.separator.RecordSeparatorPolicy;

public class ProductTwoLineSeparatorPolicy implements RecordSeparatorPolicy {

	  @Override
	    public boolean isEndOfRecord(String lineAcumulada) {
	        return this.getCommaCount(lineAcumulada) == 3;
	    }
	    @Override
	    public String postProcess(String record) {
	        return record;
	    }
	    @Override
	    public String preProcess(String line) {
	        return line;
	    }
	    private int getCommaCount(String s) {
	        String tmp = s;
	        int index = -1;
	        int count = 0;
	        while ((index = tmp.indexOf(",")) != -1) {
	            tmp = tmp.substring(index + 1);
	            count++;
	        }
	        return count;
	    }

}
