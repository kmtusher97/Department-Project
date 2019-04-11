package org.JU.deptofCSE.Department.Project.controller.syllabus;

import org.JU.deptofCSE.Department.Project.model.syllabus.*;
import org.JU.deptofCSE.Department.Project.service.syllabus.SyllabusServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

@Controller
@RequestMapping(value = "syl")
public class SyllabusController {

    SyllabusServices syllabusServices = new SyllabusServices();

    @RequestMapping(value = "/addNewSyll", method = RequestMethod.GET)                        // request to add a new syllabus
    public ModelAndView addNewSyllabus() {
        Syllabus syllabus = new Syllabus();
        SortedSet<String> syllabusNames = syllabusServices.getAllSyllabusFileNames();
        List<Syllabus> syllabusList = new ArrayList<Syllabus>();

        for(String syllabusName : syllabusNames) {
            syllabusList.add(new Syllabus(syllabusName));
        }

        ModelAndView addSyllabusPage = new ModelAndView("syllabus/AddNewSyllabus");
        addSyllabusPage.addObject("syllabusList", syllabusList);                 // basic information of the existing syllabuses
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



    @RequestMapping(value = "/search/{error}", method = RequestMethod.GET)                            // request to search syllabus
    public ModelAndView searchSyllabus(@PathVariable("error") String error) {
        SyllabusQuery syllabusQuery = new SyllabusQuery();

        ModelAndView searchSyllabusPage = new ModelAndView("syllabus/SyllabusQueryPage");
        searchSyllabusPage.addObject("syllabusQuery", syllabusQuery);
        searchSyllabusPage.addObject("message", error);

        return searchSyllabusPage;
    }


    @RequestMapping(value = "/viewSyll", method = RequestMethod.POST)                         // request to view a particular syllabus
    public ModelAndView viewSyllabus(@ModelAttribute("syllabusQuery") SyllabusQuery syllabusQuery,
                                     @ModelAttribute("message") String message) throws JAXBException {
        Syllabus syllabus = new Syllabus();
        syllabus.setCategory(syllabusQuery.getCategory());
        syllabus.setEffictiveFrom(syllabusQuery.getFrom());
        syllabus.setEffictiveTo(syllabusQuery.getTo());

        String fileName = syllabus.makeXmlFileName();                       // get the xml file name

        if(!syllabusServices.isTheSyllabusExists(fileName)) {               // if the requested syllabus does not exist or the parameters are invalid
            return new ModelAndView("redirect:/syl/search/" + "error");
        }

        String semseterName = "Semester " + Integer.toString(syllabusQuery.getSemesterNoByYearAndSemester()); // get semester name

        if(syllabusQuery.getCourseCode().length() == 0) {
            return new ModelAndView("redirect:/syl/viewSylBy/" + semseterName + "/" + fileName);    // view the whole semester
        }

        return null;
    }



    @RequestMapping(value = "/viewSylBy/{semseterName}/{fileName}", method = RequestMethod.GET)              // request to view the syllabus of a semester
    public ModelAndView viewSyllabusBySemester(@PathVariable("semesterName") String semesterName,
                                               @PathVariable("fileName") String fileName) throws JAXBException {
        Courses courses = syllabusServices.getCoursesOfASemesterBy(semesterName, fileName);                  // get the courses

        ModelAndView viewSemester = new ModelAndView("syllabus/ViewSemester");
        viewSemester.addObject("courses", courses);                                             // send the courses to view semester page

        return viewSemester;
    }



    @RequestMapping(value = "/deleteSemester/{semesterName}/{fileName}", method = RequestMethod.GET)        // request to delete a semester using the semester name & file name
    public ModelAndView deleteSemester(@PathVariable("semesterName") String semesterName,
                                       @PathVariable("fileName") String fileName) throws JAXBException {
        Syllabus syllabus = syllabusServices.getSyllabus(fileName);                                         // get the syllabus using the file name
        syllabus = syllabusServices.removeSemester(semesterName, syllabus);                                 // remove the requested semester
        syllabusServices.saveSyllabus(syllabus, fileName);                                                  // save the changes

        return new ModelAndView("redirect:/syl/editSyll/" + fileName);                            // return to the edit syllabus page
    }



    @RequestMapping(value = "/deleteSyll/{fileName}", method = RequestMethod.GET)                           // request to delete a stored syllabus form xml repository
    public ModelAndView deleteSyllabus(@PathVariable("fileName") String fileName) {
        syllabusServices.deleteSyllabus(fileName);
        return new ModelAndView("redirect:/admin/addSyll");
    }
}
