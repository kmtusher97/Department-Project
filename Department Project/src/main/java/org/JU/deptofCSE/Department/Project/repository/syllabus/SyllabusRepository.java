package org.JU.deptofCSE.Department.Project.repository.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.Syllabus;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class SyllabusRepository {

    public void addSyllabus(Syllabus syllabus, String fileName) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Syllabus.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(syllabus, new File(fileName + ".xml"));
        marshaller.marshal(syllabus, System.out);
    }

    public Syllabus getSyllabus(String fileName) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Syllabus.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File file = new File(fileName + ".xml");
        if(!file.exists()) {
            return null;
        }
        Syllabus syllabus = (Syllabus) unmarshaller.unmarshal(file);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        return syllabus;
    }
}
