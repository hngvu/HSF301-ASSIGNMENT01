package fall24.hsf301.slot1.repository;

import java.util.List;

import fall24.hsf301.slot1.dao.StudentDAO;
import fall24.hsf301.slot1.dao.IStudentDAO;
import fall24.hsf301.slot1.pojo.Student;

public class StudentRepository implements IStudentRepository {

	private IStudentDAO studentDAO;

	public StudentRepository(String fileConfig) {
		studentDAO = new StudentDAO(fileConfig);
	}

	@Override
	public List<Student> findAll() {
		return studentDAO.getStudents();
	}

	@Override
	public void save(Student student) {
		studentDAO.save(student);
	}

	@Override
	public void delete(int StudentID) {
		studentDAO.delete(StudentID);
	}

	@Override
	public Student findById(int studentID) {
		return studentDAO.findById(studentID);
	}

	@Override
	public void update(Student student) {
		studentDAO.update(student);
	}

	@Override
	public Student findByFirstName(String firstName) {
		return studentDAO.findByFirstName(firstName);
	}

	@Override
	public List<Student> search(String value) {
		return studentDAO.search(value);
	}
}
