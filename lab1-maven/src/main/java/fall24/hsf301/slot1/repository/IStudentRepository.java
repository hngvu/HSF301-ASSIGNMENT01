package fall24.hsf301.slot1.repository;

import java.util.List;

import fall24.hsf301.slot1.pojo.Student;

public interface IStudentRepository {
	List<Student> findAll();
	
	void save(Student student);
	
	void delete(int StudentID);
	
	Student findById(int studentID);
	
	Student findByFirstName(String firstName);
	
	void update (Student student);
	
	List<Student> search(String value);
}
