package ontrack;

public class TaskSubmissionValidator {
    
    public ValidationResult validate(TaskSubmission submission) {
        ValidationResult result = new ValidationResult();
        
        if (submission.isEmpty()) {
            result.setValid(false);
            result.addError("Submission cannot be empty");
        } else {
            result.setValid(true);
        }
        
        return result;
    }
}