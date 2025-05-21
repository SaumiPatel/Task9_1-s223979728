package ontrack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskSubmissionValidatorTest {
    
    @Test
    public void testEmptySubmissionShouldFail() {
        TaskSubmission submission = new TaskSubmission();
        TaskSubmissionValidator validator = new TaskSubmissionValidator();
        
        ValidationResult result = validator.validate(submission);
        
        assertFalse(result.isValid());
        assertTrue(result.getErrors().contains("Submission cannot be empty"));
    }
}
@Test
public void testMinimumWordCountCheck() {
    TaskSubmission submission = new TaskSubmission();
    submission.setTextContent("This is only five words");
    TaskSubmissionValidator validator = new TaskSubmissionValidator();
    
    ValidationResult result = validator.validate(submission);
    
    assertFalse(result.isValid());
    assertTrue(result.getErrors().contains("Text submission must contain at least 50 words"));
}

@Test
public void testRequiredFileTypeCheck() {
    TaskSubmission submission = new TaskSubmission();
    submission.setTextContent("This is a valid submission with more than fifty words. It contains multiple sentences and covers the minimum word count requirement for a text submission in our system. We are making sure that the validation logic works correctly for text content length requirements.");
    submission.addAttachedFile("document.txt");
    
    TaskSubmissionValidator validator = new TaskSubmissionValidator();
    validator.addRequiredFileType("pdf");
    
    ValidationResult result = validator.validate(submission);
    
    assertFalse(result.isValid());
    assertTrue(result.getErrors().contains("Submission must include a .pdf file"));
}