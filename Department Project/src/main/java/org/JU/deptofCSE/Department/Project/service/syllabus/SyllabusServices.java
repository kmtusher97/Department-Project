package org.JU.deptofCSE.Department.Project.service.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.Semester;
import org.JU.deptofCSE.Department.Project.model.syllabus.Semesters;
import org.JU.deptofCSE.Department.Project.model.syllabus.Syllabus;
import org.JU.deptofCSE.Department.Project.repository.syllabus.SyllabusRepository;

import javax.xml.bind.JAXBException;
import java.util.Set;
import java.util.TreeSet;

public class SyllabusServices {

    SyllabusRepository syllabusRepository = new SyllabusRepository();

    public Syllabus getSyllabus(String fileName) throws JAXBException {
        return syllabusRepository.getSyllabus(fileName);
    }

    public void saveSyllabus(Syllabus syllabus, String fileName) throws JAXBException {
        syllabusRepository.addSyllabus(syllabus, fileName);
    }

    public Syllabus checkExistance(Syllabus syllabus) throws JAXBException {
        Syllabus syllabusStored = syllabusRepository.getSyllabus(syllabus.makeXmlFileName());

        if(syllabusStored != null) {
            syllabus = syllabusStored;
        }

        return syllabus;
    }

    public Syllabus removeSemester(String semesterName, Syllabus syllabus) {
        Set<Semester> semesterSet = syllabus.getSemesters().getSemesters();
        for(Semester semester : semesterSet) {
            if(!semester.getName().equals(semesterName)) {
                continue;
            }
            semesterSet.remove(semester);
            break;
        }
        Semesters semesters = syllabus.getSemesters();
        semesters.setSemesters((TreeSet<Semester>) semesterSet);
        syllabus.setSemesters(semesters);
        return syllabus;
    }
}
