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