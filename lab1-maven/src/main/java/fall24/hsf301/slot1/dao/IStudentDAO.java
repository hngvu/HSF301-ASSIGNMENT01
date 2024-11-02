package fall24.hsf301.slot1.dao;

import java.util.List;

import fall24.hsf301.slot1.pojo.Student;

public interface IStudentDAO {
	void save(Student student);

	List<Student> getStudents();

	void delete(int studentId);

	Student findById(int studentId);

	void update(Student student);

	Student findByFirstName(String firstName);
	
	List<Student> search(String value);
}
