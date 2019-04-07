package org.JU.deptofCSE.Department.Project.controller.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.Syllabus;
import org.JU.deptofCSE.Department.Project.service.syllabus.SyllabusServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(value = "/addSems", method = RequestMethod.POST)
    public ModelAndView addSemesters(@ModelAttribute("syllabusForm") Syllabus syllabus) throws JAXBException {
        syllabus = syllabusServices.checkExistance(syllabus);
        syllabus.populateSemestes(8);
        ModelAndView addSemestersPage = new ModelAndView("syllabus/AddSemesters");
        addSemestersPage.addObject("syllabusForm", syllabus);
        return addSemestersPage;
    }
}
