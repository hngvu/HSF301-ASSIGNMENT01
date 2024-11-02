package fall24.hsf301.slot1.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import fall24.hsf301.slot1.pojo.Account;
import fall24.hsf301.slot1.pojo.Account.Role;
import fall24.hsf301.slot1.pojo.Student;
import fall24.hsf301.slot1.service.AccountService;
import fall24.hsf301.slot1.service.IAccountService;
import fall24.hsf301.slot1.service.IStudentService;
import fall24.hsf301.slot1.service.StudentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class StudentManagementController implements Initializable {
	@FXML
	private TableView<Student> tblStudents;

	@FXML
	private TableColumn<Student, Integer> studentId;

	@FXML
	private TableColumn<Student, String> firstName;

	@FXML
	private TableColumn<Student, String> lastName;

	@FXML
	private TableColumn<Student, Double> mark;

	@FXML
	private TextField txtFirstName;

	@FXML
	private TextField txtLastName;

	@FXML
	private TextField txtTotalMark;

	@FXML
	private Button btnAddStudent;
	
	@FXML
	private Button btnDeleteStudent;
	
	@FXML
	private Text txtUsername;
	
	@FXML
	private TextField txtSearch;

	private IStudentService studentService;

	private ObservableList<Student> studentModel;

	private Role role;
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
		if (this.role == Role.USER) {
			this.btnAddStudent.setDisable(true);
			this.btnDeleteStudent.setDisable(true);
			
		}
	}
	
	private Account account;
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
		txtUsername.setText("Welcome, " + account.getUserName());
	}

	private int id;

	private String hibernateConfig = "hibernate.cfg.xml";
	
	public StudentManagementController() {
		studentService = new StudentService(hibernateConfig);
		studentModel = FXCollections.observableArrayList(studentService.findAll());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		studentId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
		lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
		mark.setCellValueFactory(new PropertyValueFactory<>("Mark"));
		tblStudents.setItems(studentModel);
	}

	public void btnCancleOnAction() {
		System.exit(0);
	}

	public void btnAddStudent() {
		String firstName = txtFirstName.getText();
		String lastName = txtLastName.getText();
		double mark = 0;
		try {
			mark = Double.parseDouble(txtTotalMark.getText());
		} catch(Exception e) {
			mark = 0;
		}
		
		
		Student student = new Student(firstName, lastName, mark);
		studentService.save(student);
		refreshData();
	}

	public void btnDeleteStudent() {
		studentService.delete(id);
		this.refreshInput();
		this.refreshData();
	}

	public void btnUpdateStudent() {
		Student student = studentService.findById(id);
		
		student.setFirstName(txtFirstName.getText());
		student.setLastName(txtLastName.getText());
		student.setMark(Double.parseDouble(txtTotalMark.getText()));
		studentService.update(student);
		
		this.refreshData();
		this.refreshInput();
	}

	public void tblStudentOnMouseClick() {
		int index = tblStudents.getSelectionModel().getSelectedIndex();
		id = studentId.getCellData(index);
		txtFirstName.setText(firstName.getCellData(index));
		txtLastName.setText(lastName.getCellData(index));
		txtTotalMark.setText(mark.getCellData(index).toString());
	}
	
	private void refreshData() {
		studentModel = FXCollections.observableArrayList(studentService.findAll());
		tblStudents.setItems(studentModel);
	}
	
	private void refreshInput() {
		txtFirstName.setText(null);
		txtLastName.setText(null);
		txtTotalMark.setText(null);
	}
	
	public void btnSearchOnAction() {
		studentModel = FXCollections.observableArrayList(studentService.search(txtSearch.getText()));
		tblStudents.setItems(studentModel);
	}

}