package jdbc_person;

import java.util.Scanner;

public class personMain {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome!!! \n1.Signup \n2.Login \n3.exit");
		int choice = scanner.nextInt();
		
		personCRUD crud = new personCRUD();

		switch(choice) {
		
		case 1:{
		System.out.println("Enter the person id");
		int id = scanner.nextInt();
		System.out.println("Enter the person name");
		String name = scanner.next();
		System.out.println("Enter the person phno");
		long phno = scanner.nextLong();
		System.out.println("Enter the person email");
		String email=scanner.next();
		System.out.println("Enter the pass");
		String pass= scanner.next();
		person person=new person();
		person.setId(id);
		person.setName("Name:" +name);
		person.setPhno(phno);
		person.setEmail("Email:"+email);
		person.setPass(pass);
		
		int count = crud.signUpPerson(person);
		if(count!=0) {
			System.out.println("signup Successfully!!!");
		}
		else {
			System.out.println("Failed to Signup");
		}
		
		}
		
		 break;
		
		
		case 2:{
			System.out.println("Enter the person Email");
			String email=scanner.next();
			System.out.println("Enter the password");
			String pass= scanner.next();
			
			String dbPass = crud.getPass(email);
				if(dbPass!=null) {
					if(dbPass.equals(pass)) {
					System.out.println("Login Successful!!");
					System.out.println(
							"Welcome!!! \n1.Display Info \n2.Change Password \n3.Delete \n4.Logout");
					switch(scanner.nextInt()) {
					case 1:{
					person person = crud.getInfo(email); 
					System.out.println("Id : " +person.getId());
					System.out.println("Name : " +person.getName());
					System.out.println("phno : " +person.getPhno());
					System.out.println("email : " +person.getEmail());
					System.out.println("pass : " +person.getPass());
					}
					break;
					case 2:
					{
						System.out.println("Enter the new password");
						String newPass = scanner.next();
						
						int result = crud.updatePassword(email,newPass);
						if(result!=0) {
							System.out.println("password Updated Successfully");
						}
						else {
							System.out.println("Failed to update Password");
						}
					}
					break;
					case 3:{
						int result = crud.deletePerson(email);
						if(result !=0) {
							System.out.println("Account Deleted Successfully");
						}
						else {
							System.out.println("Failed to delete Account");
						}
					}
					break;
					
					
					
				
				
				
					}
					
				}
				else {
					System.out.println("Innvalid Password");
				}
			}
				else {
				System.out.println("person not registered with the given email" +email);
				}
				
		}	
		break;
			
		}	
	}
}

