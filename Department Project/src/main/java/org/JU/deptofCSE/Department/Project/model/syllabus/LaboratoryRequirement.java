package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "LaboratoryRequirement")
public class LaboratoryRequirement {

    private String title;

    private String requirement;

    public LaboratoryRequirement() {
        this.title = "";
        this.requirement = "";
    }

    public LaboratoryRequirement(String title, String requirement) {
        this.title = title;
        this.requirement = requirement;
    }

    @XmlElement(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "Requirement")
    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    @Override
    public String toString() {
        return "LaboratoryRequirement{" +
                "requirement='" + requirement + '\'' +
                '}';
    }
}
