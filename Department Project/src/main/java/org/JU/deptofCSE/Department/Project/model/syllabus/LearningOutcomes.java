package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "LearningOutcomes")
public class LearningOutcomes {

    private List<LearningOutcome> learningOutcome;

    public LearningOutcomes() {
    }

    public LearningOutcomes(List<LearningOutcome> learningOutcome) {
        this.learningOutcome = learningOutcome;
    }

    @XmlElement(name = "LearningOutcome")
    public List<LearningOutcome> getLearningOutcome() {
        return learningOutcome;
    }

    public void setLearningOutcome(List<LearningOutcome> learningOutcome) {
        this.learningOutcome = learningOutcome;
    }

    public void addLearningOutcome(LearningOutcome learningOutcome) {
        if(this.learningOutcome == null) {
            this.learningOutcome = new ArrayList<LearningOutcome>();
        }
        this.learningOutcome.add(learningOutcome);
    }

    @Override
    public String toString() {
        return "LearningOutcomes{" +
                "learningOutcome=" + learningOutcome +
                '}';
    }
}
