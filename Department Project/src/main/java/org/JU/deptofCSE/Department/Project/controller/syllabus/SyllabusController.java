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

    public ModelAndView viewSyllabus() {
        return null;
    }

    @RequestMapping(value = "/addNewSyll", method = RequestMethod.GET)                        // request to add a new syllabus
    public ModelAndView addNewSyllabus() {
        Syllabus syllabus = new Syllabus();
        ModelAndView addSyllabusPage = new ModelAndView("syllabus/AddNewSyllabus");
        addSyllabusPage.addObject("syllabusForm", syllabus);                     // send an object of syllabus class and get the
        return addSyllabusPage;                                                               // category and session of the syllabus, then go to edit syllabus page
    }

    @RequestMapping(value = "/editSyll/{fileName}", method = RequestMethod.GET)                // request to edit a syllabus
    public ModelAndView editSyllabus(@PathVariable("fileName") String fileName) throws JAXBException {
        if(!syllabusServices.isTheSyllabusExists(fileName)) {                                  // if the requested syllabus does not exists
            syllabusServices.saveSyllabus(new Syllabus(fileName), fileName);                   // add this syllabus to xml repository
        }

        Syllabus syllabusFrom = syllabusServices.getSyllabus(fileName);                        // find the syllabus using the file name

        ModelAndView syllabusEditPage = new ModelAndView("syllabus/EditSyllabus");
        syllabusEditPage.addObject("fileName", fileName);
        syllabusEditPage.addObject("syllabus", syllabusFrom);

        return syllabusEditPage;
    }

    @RequestMapping(value = "/addNewSemester/{fileName}", method = RequestMethod.GET)                       // request to add a semester to a particular syllabus
    public ModelAndView addNewSemester(@PathVariable("fileName") String fileName) throws JAXBException {
        Syllabus syllabus = syllabusServices.getSyllabus(fileName);                                         // open the syllabus using the file name
        Semester semester = new Semester();

        semester.setName("Semester " + syllabus.getSemesters().getFirstMissingSemesterId());                // set the semester name, while adding semesters add the first missing one
        syllabus.addNewSemester(semester);
        syllabusServices.saveSyllabus(syllabus, fileName);                                                  // store the changes

        return new ModelAndView("redirect:/syl/editSyll/" + fileName);                            // return to the edit syllabus page
    }

    @RequestMapping(value = "/deleteSemester/{semesterName}/{fileName}", method = RequestMethod.GET)        // request to delete a semester using the semester name & file name
    public ModelAndView deleteSemester(@PathVariable("semesterName") String semesterName,
                                       @PathVariable("fileName") String fileName) throws JAXBException {
        Syllabus syllabus = syllabusServices.getSyllabus(fileName);                                         // get the syllabus using the file name
        syllabus = syllabusServices.removeSemester(semesterName, syllabus);                                 // remove the requested semester
        syllabusServices.saveSyllabus(syllabus, fileName);                                                  // save the changes

        return new ModelAndView("redirect:/syl/editSyll/" + fileName);                            // return to the edit syllabus page
    }
}
