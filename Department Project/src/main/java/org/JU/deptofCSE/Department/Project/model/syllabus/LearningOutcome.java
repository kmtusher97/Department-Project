package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "LearningOutcome")
public class LearningOutcome {

    private String outcome;

    public LearningOutcome() {
        this.outcome = "";
    }

    public LearningOutcome(String outcome) {
        this.outcome = outcome;
    }

    @XmlElement(name = "Outcome")
    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    @Override
    public String toString() {
        return "LearningOutcome{" +
                "outcome='" + outcome + '\'' +
                '}';
    }
}
