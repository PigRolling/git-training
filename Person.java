public class Person {
	private String name;
	private int age;
	private String sex;
	private Date birthday;
	private String address;

	public Person(){
		
	}

	public Person(String name,int age,String sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birthday = null;
		this.address = null;
	}
}