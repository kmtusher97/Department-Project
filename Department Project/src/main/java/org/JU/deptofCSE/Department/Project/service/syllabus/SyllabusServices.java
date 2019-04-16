package org.JU.deptofCSE.Department.Project.service.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.*;
import org.JU.deptofCSE.Department.Project.repository.syllabus.SyllabusRepository;

import javax.xml.bind.JAXBException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SyllabusServices {

    SyllabusRepository syllabusRepository = new SyllabusRepository();

    public Syllabus getSyllabus(String fileName) throws JAXBException {
        return syllabusRepository.getSyllabus(fileName);
    }

    public void saveSyllabus(Syllabus syllabus, String fileName) throws JAXBException {
        syllabusRepository.addSyllabus(syllabus, fileName);
    }

    public boolean isTheSyllabusExists(String fileName) throws JAXBException {
        return (syllabusRepository.getSyllabus(fileName) != null);
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

    public SortedSet<String> getAllSyllabusFileNames() {                     // get all the names of the stored syllabuses
        return syllabusRepository.getAllSyllabusNames();
    }

    public void deleteSyllabus(String fileName) {                            // delete a syllabus from xml repository
        syllabusRepository.deleteSyllabus(fileName);
    }

    /**
     * @param from session
     * @param to session
     * @return the syllabus of the requested session
     */
    public String getSyllabusNameBySession(Integer from, Integer to) throws JAXBException {
        SortedSet<String> syllabusNames = syllabusRepository.getAllSyllabusNames();
        for(String syllabusName : syllabusNames) {
            SyllabusQuery temporarySyllabus = new SyllabusQuery(syllabusName);

            if(from >= temporarySyllabus.getFrom() && to <= temporarySyllabus.getTo()) {
                return syllabusName;
            }
        }
        return null;
    }
}
