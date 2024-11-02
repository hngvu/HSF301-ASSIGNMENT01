package fall24.hsf301.slot1.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import fall24.hsf301.slot1.pojo.Student;

public class StudentDAO implements IStudentDAO {
	private SessionFactory sessionFactory;
	private Configuration cfg;

	public StudentDAO(String hibernateConfig) {
		cfg = new Configuration().configure(hibernateConfig);
		sessionFactory = cfg.buildSessionFactory();
	}

	public void save(Student student) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(student);
			t.commit();
		} catch (Exception ex) {
			t.rollback();
		} finally {
			session.close();
		}
	}

	public List<Student> getStudents() {
		Session session = sessionFactory.openSession();
		try {
			List<Student> students = session.createQuery("from Student", Student.class).list();
			return students;
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
	}

	public void delete(int studentId) {
		Session session = sessionFactory.openSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			Student student = session.find(Student.class, studentId);
			if (student == null) {
				System.out.println("Student không tồn tại");
				return;
			}
			session.delete(student);
			t.commit();
		} catch (RuntimeException e) {
			t.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public Student findById(int studentId) {
		Session session = sessionFactory.openSession();
		try {
			return (Student) session.get(Student.class, studentId);
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
	}

	public void update(Student student) {
		Session session = sessionFactory.openSession();
		Transaction t = session.getTransaction();
		try {
			t.begin();
			session.update(student);
			t.commit();
		} catch (Exception ex) {
			t.rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public Student findByFirstName(String firstName) {
		return null;
	}

	@Override
	public List<Student> search(String value) {
		Session session = sessionFactory.openSession();
		List<Student> students = new ArrayList<Student>();
		try {
			Query<Student> query = session.createQuery("FROM Student WHERE firstName LIKE :search", Student.class);
			query.setParameter("search", "%" + value + "%");
			students = query.list();
			return students;
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
	}

}
