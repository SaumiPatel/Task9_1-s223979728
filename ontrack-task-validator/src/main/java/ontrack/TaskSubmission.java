package ontrack;

import java.util.ArrayList;
import java.util.List;

public class TaskSubmission {
    private List<String> attachedFiles = new ArrayList<>();
    private String textContent = "";
    
    public List<String> getAttachedFiles() {
        return attachedFiles;
    }
    
    public void addAttachedFile(String filename) {
        attachedFiles.add(filename);
    }
    
    public String getTextContent() {
        return textContent;
    }
    
    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}