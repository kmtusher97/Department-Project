package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "LearningOutcomes")
public class LearningOutcomes {

    @XmlElement(name = "LearningOutcome")
    List<String>learningOutcome;

    public List<String> get_LearningOutcome() {
        return learningOutcome;
    }

    public void setLearningOutcome(List<String> learningOutcome) {
        this.learningOutcome = learningOutcome;
    }
}
