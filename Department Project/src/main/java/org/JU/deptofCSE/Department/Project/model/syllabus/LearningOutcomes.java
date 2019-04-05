package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "LearningOutcomes")
public class LearningOutcomes {

    List<String>learningOutcome;

    @XmlElement(name = "LearningOutcome")
    public List<String> getLearningOutcome() {
        return learningOutcome;
    }

    public void setLearningOutcome(List<String> learningOutcome) {
        this.learningOutcome = learningOutcome;
    }
}
