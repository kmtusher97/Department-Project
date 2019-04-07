package org.JU.deptofCSE.Department.Project.service.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.Syllabus;
import org.JU.deptofCSE.Department.Project.repository.syllabus.SyllabusRepository;

import javax.xml.bind.JAXBException;

public class SyllabusServices {

    SyllabusRepository syllabusRepository = new SyllabusRepository();

    public Syllabus getSyllabus(String fileName) throws JAXBException {
        return syllabusRepository.getSyllabus(fileName);
    }

    public void saveSyllabus(Syllabus syllabus, String fileName) throws JAXBException {
        syllabusRepository.addSyllabus(syllabus, fileName);
    }

    public Syllabus checkExistance(Syllabus syllabus) throws JAXBException {
        String fileName = "syllabus" + Integer.toString(syllabus.getEffictiveFrom()) + Integer.toString(syllabus.getEffictiveTo());
        Syllabus syllabusStored = syllabusRepository.getSyllabus(fileName);
        if(syllabusStored != null) {
            syllabus = syllabusStored;
        }

        return syllabus;
    }
}
