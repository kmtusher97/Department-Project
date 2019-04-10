package org.JU.deptofCSE.Department.Project.controller.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.Semester;
import org.JU.deptofCSE.Department.Project.model.syllabus.Syllabus;
import org.JU.deptofCSE.Department.Project.service.syllabus.SyllabusServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.bind.JAXBException;

@Controller
@RequestMapping(value = "syl")
public class SyllabusController {

    SyllabusServices syllabusServices = new SyllabusServices();

    @RequestMapping(value = "/addSyl", method = RequestMethod.GET)
    public ModelAndView addNewSyllabus() {
        Syllabus syllabus = new Syllabus();
        ModelAndView addSyllabusPage = new ModelAndView("syllabus/AddNewSyllabus");
        addSyllabusPage.addObject("syllabusForm", syllabus);
        return addSyllabusPage;
    }

    @RequestMapping(value = "/editSyl", method = RequestMethod.POST)
    public ModelAndView addSemesters(@ModelAttribute("syllabusForm") Syllabus syllabus) throws JAXBException {
        syllabus = syllabusServices.checkExistance(syllabus);
        syllabusServices.saveSyllabus(syllabus, syllabus.makeXmlFileName());

        ModelAndView editSyllabusPage = new ModelAndView("syllabus/EditSyllabus");
        editSyllabusPage.addObject("syllabus", syllabus);
        editSyllabusPage.addObject("fileName", syllabus.makeXmlFileName());

        return editSyllabusPage;
    }

    @RequestMapping(value = "/addNewSemester/{fileName}", method = RequestMethod.GET)
    public ModelAndView addNewSemester(@PathVariable("fileName") String fileName) throws JAXBException {
        Syllabus syllabus = syllabusServices.getSyllabus(fileName);
        Semester semester = new Semester();

        semester.setName("Semester " + syllabus.getSemesters().getFirstMissingSemesterId());
        syllabus.addNewSemester(semester);
        syllabusServices.saveSyllabus(syllabus, fileName);

        ModelAndView editSyllabusPage = new ModelAndView("syllabus/EditSyllabus");
        editSyllabusPage.addObject("syllabus", syllabus);
        editSyllabusPage.addObject("fileName", fileName);

        return editSyllabusPage;
    }

    @RequestMapping(value = "/deleteSemester/{semesterName}/{fileName}", method = RequestMethod.GET)
    public ModelAndView deleteSemester(@PathVariable("semesterName") String semesterName,
                                       @PathVariable("fileName") String fileName) throws JAXBException {
        Syllabus syllabus = syllabusServices.getSyllabus(fileName);
        syllabus = syllabusServices.removeSemester(semesterName, syllabus);
        syllabusServices.saveSyllabus(syllabus, fileName);

        ModelAndView editSyllabusPage = new ModelAndView("syllabus/EditSyllabus");
        editSyllabusPage.addObject("syllabus", syllabus);
        editSyllabusPage.addObject("fileName", fileName);

        return editSyllabusPage;

    }
}
