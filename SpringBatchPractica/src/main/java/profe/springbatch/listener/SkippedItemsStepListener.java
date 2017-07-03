package profe.springbatch.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class SkippedItemsStepListener implements StepExecutionListener {

	public void beforeStep(StepExecution stepExecution) {
		System.out.println("SkippedItemsStepListener beforeStep"+stepExecution);

	}

	public ExitStatus afterStep(StepExecution stepExecution) {
		 if (!ExitStatus.FAILED.equals(
	                stepExecution.getExitStatus()) && stepExecution.getSkipCount() > 0) {
	            return new ExitStatus("COMPLETED WITH SKIPS");
	        } else {
	            return stepExecution.getExitStatus();
	        }
	    }
	}


