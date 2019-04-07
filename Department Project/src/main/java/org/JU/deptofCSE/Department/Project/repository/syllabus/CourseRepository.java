package org.JU.deptofCSE.Department.Project.repository.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.Course;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class CourseRepository {

    public void addCourse(Course course) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Course.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(course, new File("courseRepo.xml"));
        marshaller.marshal(course, System.out);
    }

    public Course getCourse() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Course.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File file = new File("courseRepo.xml");
        Course course = (Course) unmarshaller.unmarshal(file);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        return course;
    }
}
