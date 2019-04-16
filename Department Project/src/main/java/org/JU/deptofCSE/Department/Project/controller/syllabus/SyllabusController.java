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

    /**
     * Add New Syllabus
     * This method responses for the url request "/addNewSyll".
     * This request comes from the Admin Dashboard Page after clicking on Syllabus button.
     *
     * @return ModelAndView This returns the AddNewSyllabus.html Page
     */
    @RequestMapping(value = "/addNewSyll", method = RequestMethod.GET)
    public ModelAndView addNewSyllabus() {
        Syllabus syllabus = new Syllabus();
        SortedSet<String> syllabusNames = syllabusServices.getAllSyllabusFileNames();
        List<Syllabus> syllabusList = new ArrayList<Syllabus>();

        for (String syllabusName : syllabusNames) {
            syllabusList.add(new Syllabus(syllabusName));
        }

        ModelAndView addSyllabusPage = new ModelAndView("syllabus/AddNewSyllabus");
        addSyllabusPage.addObject("syllabusList", syllabusList);                 // basic information of the existing syllabuses
        addSyllabusPage.addObject("syllabusForm", syllabus);                     // send an object of syllabus class and get the
        return addSyllabusPage;                                                               // category and session of the syllabus, then go to edit syllabus page
    }


    /**
     * Allow to edit syllabus by admin
     *
     * @param fileName
     * @return Edit Syllabus Page
     * @throws JAXBException
     */
    @RequestMapping(value = "/editSyll/{fileName}", method = RequestMethod.GET)
    public ModelAndView editSyllabus(@PathVariable("fileName") String fileName) throws JAXBException {
        if (!syllabusServices.isTheSyllabusExists(fileName)) {                                  // if the requested syllabus does not exists
            syllabusServices.saveSyllabus(new Syllabus(fileName), fileName);                   // add this syllabus to xml repository
        }

        Syllabus syllabusFrom = syllabusServices.getSyllabus(fileName);                        // find the syllabus using the file name

        ModelAndView syllabusEditPage = new ModelAndView("syllabus/EditSyllabus");
        syllabusEditPage.addObject("fileName", fileName);
        syllabusEditPage.addObject("syllabus", syllabusFrom);

        return syllabusEditPage;
    }


    /**
     * Add a new semester to the syllabus.
     *
     * @param fileName
     * @return redirect to Edit Syllabus Page.
     * @throws JAXBException
     */
    @RequestMapping(value = "/addNewSemester/{fileName}", method = RequestMethod.GET)
    public ModelAndView addNewSemester(@PathVariable("fileName") String fileName) throws JAXBException {
        Syllabus syllabus = syllabusServices.getSyllabus(fileName);                                         // open the syllabus using the file name
        Semester semester = new Semester();

        semester.setName("Semester " + syllabus.getSemesters().getFirstMissingSemesterId());                // set the semester name, while adding semesters add the first missing one
        syllabus.addNewSemester(semester);
        syllabusServices.saveSyllabus(syllabus, fileName);                                                  // store the changes

        return new ModelAndView("redirect:/syl/editSyll/" + fileName);                            // return to the edit syllabus page
    }


    /**
     * Search a syllabus with session
     *
     * @param error
     * @return Syllabus Search form
     */
    @RequestMapping(value = "/search/{error}", method = RequestMethod.GET)
    public ModelAndView searchSyllabus(@PathVariable("error") String error) {
        SyllabusQuery syllabusQuery = new SyllabusQuery();

        ModelAndView searchSyllabusPage = new ModelAndView("syllabus/SyllabusQueryPage");
        searchSyllabusPage.addObject("syllabusQuery", syllabusQuery);
        searchSyllabusPage.addObject("message", error);

        return searchSyllabusPage;
    }


    /**
     * If the requested session is invalid redirect to Syllabus Search page.
     * If the session is found in some syllabus the redirect to Show Syllabus Page
     *
     * @param syllabusQuery
     * @param message
     * @return Syllabus Search page or Show Syllabus Page
     * @throws JAXBException
     */
    @RequestMapping(value = "/viewSyll", method = RequestMethod.POST)
    public ModelAndView viewSyllabus(@ModelAttribute("syllabusQuery") SyllabusQuery syllabusQuery,
                                     @ModelAttribute("message") String message) throws JAXBException {
        String syllabusName = syllabusServices.getSyllabusNameBySession(syllabusQuery.getFrom(), syllabusQuery.getTo());

        if (syllabusName == null) {                                               // if the requested syllabus does not exist or the parameters are invalid
            return new ModelAndView("redirect:/syl/search/" + "error");
        }

        return new ModelAndView("redirect:/syl/showSyll/" + syllabusName);
    }


    /**
     * Shows the syllabus in a table
     *
     * @param fileName
     * @return Show Syllabus page
     * @throws JAXBException
     */
    @RequestMapping(value = "/showSyll/{fileName}", method = RequestMethod.GET)
    public ModelAndView showSyllabus(@PathVariable("fileName") String fileName) throws JAXBException {
        Syllabus syllabus = syllabusServices.getSyllabus(fileName);

        ModelAndView syllabusView = new ModelAndView("syllabus/SyllabusView");
        syllabusView.addObject("syllabus", syllabus);
        syllabusView.addObject("fileName", syllabus.makeXmlFileName());

        return syllabusView;
    }


    /**
     * Delete a semester by semester name.
     *
     * @param semesterName
     * @param fileName
     * @return redirect to Edit Syllabus Page.
     * @throws JAXBException
     */
    @RequestMapping(value = "/deleteSemester/{semesterName}/{fileName}", method = RequestMethod.GET)
    public ModelAndView deleteSemester(@PathVariable("semesterName") String semesterName,
                                       @PathVariable("fileName") String fileName) throws JAXBException {
        Syllabus syllabus = syllabusServices.getSyllabus(fileName);                                         // get the syllabus using the file name
        syllabus = syllabusServices.removeSemester(semesterName, syllabus);                                 // remove the requested semester
        syllabusServices.saveSyllabus(syllabus, fileName);                                                  // save the changes

        return new ModelAndView("redirect:/syl/editSyll/" + fileName);                            // return to the edit syllabus page
    }


    /**
     * Delete the syllabus
     *
     * @param fileName
     * @return redirect to Add Syllabus Page.
     */
    @RequestMapping(value = "/deleteSyll/{fileName}", method = RequestMethod.GET)
    public ModelAndView deleteSyllabus(@PathVariable("fileName") String fileName) {
        syllabusServices.deleteSyllabus(fileName);
        return new ModelAndView("redirect:/admin/addSyll");
    }
}
