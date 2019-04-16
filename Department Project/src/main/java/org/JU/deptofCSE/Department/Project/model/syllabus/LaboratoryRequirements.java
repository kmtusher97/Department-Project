package org.JU.deptofCSE.Department.Project.model.syllabus;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "LaboratoryRequirements")
public class LaboratoryRequirements {

    private List<LaboratoryRequirement> laboratoryRequirement;

    public LaboratoryRequirements() {
        this.laboratoryRequirement = new ArrayList<LaboratoryRequirement>();
    }

    public LaboratoryRequirements(List<LaboratoryRequirement> laboratoryRequirement) {
        this.laboratoryRequirement = laboratoryRequirement;
    }

    @XmlElement(name = "LaboratoryRequirement")
    public List<LaboratoryRequirement> getLaboratoryRequirement() {
        return laboratoryRequirement;
    }

    public void setLaboratoryRequirement(List<LaboratoryRequirement> laboratoryRequirement) {
        this.laboratoryRequirement = laboratoryRequirement;
    }

    @Override
    public String toString() {
        return "laboratoryRequirement{" +
                "laboratoryRequirement=" + laboratoryRequirement +
                '}';
    }

    public void addLaboratoryRequirement(LaboratoryRequirement laboratoryRequirement) {
        if(this.laboratoryRequirement == null) {
            this.laboratoryRequirement = new ArrayList<LaboratoryRequirement>();
        }
        this.laboratoryRequirement.add(laboratoryRequirement);
    }

    public Integer getCount() {
        return this.laboratoryRequirement.size();
    }
}
