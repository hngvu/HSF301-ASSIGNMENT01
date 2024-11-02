package fall24.hsf301.slot1.pojo;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table (name = "Students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
		
	@Column(name="firstName", nullable = false)
	private String firstName;
	
	@Column(name="lastName", nullable = false)
	private String lastName;
	
	@Column(name="marks")
	@ColumnDefault("0")
	private double mark;
	
	
	public Student() {
		this.firstName = "";
		this.lastName = "";
		this.mark = 0;
	}
	
	
	public Student(String firstName, String lastName, double mark) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mark = mark;
	}
	
	public Student(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	

	public Student(int id, String firstName, String lastName, double mark) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mark = mark;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName, mark);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName)
				&& mark == other.mark;
	}




	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mark=" + mark + "]";
	}
	
	
}
