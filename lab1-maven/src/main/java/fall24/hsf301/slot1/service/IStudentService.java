package fall24.hsf301.slot1.service;

import java.util.List;

import fall24.hsf301.slot1.pojo.Student;

public interface IStudentService {
	List<Student> findAll();
	
	void save(Student student);
	
	void delete(int StudentID);
	
	Student findById(int studentID);
	
	Student findByFirstName(String firstName);
	
	void update (Student student);
	
	List<Student> search(String value);
}
