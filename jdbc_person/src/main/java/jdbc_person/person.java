package jdbc_person;

public class person {   
	private static int id;
	private static String name;
	private static Long phno;
	private  static String email;
	private static String pass;
	
	public static int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	public static String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	 
	
	
}