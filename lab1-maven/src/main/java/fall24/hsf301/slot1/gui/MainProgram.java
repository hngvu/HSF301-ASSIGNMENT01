package fall24.hsf301.slot1.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fall24.hsf301.slot1.pojo.Student;
import fall24.hsf301.slot1.service.AccountService;
import fall24.hsf301.slot1.service.IAccountService;
import fall24.hsf301.slot1.service.IStudentService;
import fall24.hsf301.slot1.service.StudentService;

public class MainProgram {

	public static void main(String[] args) {
		
		IAccountService service = new AccountService("hibernate.cfg.xml");
		
		System.out.println(service.findByUserName("admin"));
	}

}
