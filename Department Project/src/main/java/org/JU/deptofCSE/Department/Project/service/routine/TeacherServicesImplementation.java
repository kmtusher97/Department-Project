package org.JU.deptofCSE.Department.Project.service.routine;

import org.JU.deptofCSE.Department.Project.model.routine.Teacher;
import org.JU.deptofCSE.Department.Project.repository.routine.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServicesImplementation implements TeacherServices {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeacher() {
        return (List<Teacher>) teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return teacherRepository.getOne(id);
    }

    @Override
    public void saveOrUpdate(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void delete(Integer id) {
        teacherRepository.deleteById(id);
    }

    /**
     * Update the old object with newly edited data
     *
     * @param oldTeacherData
     * @param newTeacherData
     * @return updated Teacher Object
     */
    @Override
    public Teacher updateTeacherWithEditedData(Teacher oldTeacherData, Teacher newTeacherData) {
        oldTeacherData.setFullName(newTeacherData.getFullName());
        oldTeacherData.setDesignation(newTeacherData.getDesignation());
        oldTeacherData.setMobileNo1(newTeacherData.getMobileNo1());
        oldTeacherData.setMobileNo2(newTeacherData.getMobileNo2());
        oldTeacherData.setCampusResident(newTeacherData.isCampusResident());

        return oldTeacherData;
    }


}
