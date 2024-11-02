package fall24.hsf301.slot1.service;

import java.util.List;

import fall24.hsf301.slot1.pojo.Student;
import fall24.hsf301.slot1.repository.IStudentRepository;
import fall24.hsf301.slot1.repository.StudentRepository;

public class StudentService implements IStudentService{
	
	private IStudentRepository studentRepository = null;
	
	public StudentService(String fileName) {
		studentRepository = new StudentRepository(fileName);
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void delete(int StudentID) {
		studentRepository.delete(StudentID);
	}

	@Override
	public Student findById(int studentID) {
		return studentRepository.findById(studentID);
	}
	

	@Override
	public void update(Student student) {
		studentRepository.update(student);
	}

	@Override
	public Student findByFirstName(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}

	@Override
	public List<Student> search(String value) {
		return studentRepository.search(value);
	}

}
