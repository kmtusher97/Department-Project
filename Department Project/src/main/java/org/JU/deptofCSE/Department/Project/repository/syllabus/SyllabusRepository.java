package org.JU.deptofCSE.Department.Project.repository.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.Syllabus;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.SortedSet;
import java.util.TreeSet;

public class SyllabusRepository {

    public void addSyllabus(Syllabus syllabus, String fileName) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Syllabus.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(syllabus, new File("Syllabus_Repository/" + fileName + ".xml"));
        marshaller.marshal(syllabus, System.out);
    }

    public Syllabus getSyllabus(String fileName) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Syllabus.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File file = new File("Syllabus_Repository/" + fileName + ".xml");
        if(!file.exists()) {
            return null;
        }
        Syllabus syllabus = (Syllabus) unmarshaller.unmarshal(file);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        return syllabus;
    }

    /**
     * Get all the names of the syllabuses previously added
     * @return SortedSet<String> xml file names
     */
    public SortedSet<String> getAllSyllabusNames() {                        // get the list of names of all stored syllabuses
        File folder = new File("Syllabus_Repository");
        File[] listOfSyllabus = folder.listFiles();
        SortedSet<String> fileNames = new TreeSet<String>();

        for (int i = 0; i < listOfSyllabus.length; i++) {
            if(listOfSyllabus[i].isFile()) {
                String nameOfFile = listOfSyllabus[i].getName();
                String[] parsedName = nameOfFile.split(".xml");
                fileNames.add(parsedName[0]);
            }
        }
        return fileNames;
    }

    public void deleteSyllabus(String fileName) {
        File file = new File("Syllabus_Repository/" + fileName + ".xml");
        if(file.delete()) {
            System.out.println(fileName + ".xml deleted succesfully!");
        }
        else {
            System.err.println("No such file!!!");
        }
    }
}
