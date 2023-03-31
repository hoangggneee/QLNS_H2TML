package h2tml.qlns.web.dto;


public class UserRegistrationDto {

	//@NotEmpty(message = "First name can't be empty!")
	private String firstName;

	//@NotEmpty(message = "Last name can't be empty!")
	private String lastName;

	//@NotEmpty(message = "Email name can't be empty!")
	//@Email(message = "*Please provide a valid Email")
	private String userName;

	//@Length(min = 5, message = "*Your password must have at least 5 characters")
	//@NotEmpty(message = "*Please provide your password")
	private String password;

	private Boolean active;

	private String address;

	private String phone;

	public String photo;

	public UserRegistrationDto(){
	}

	public UserRegistrationDto(String firstName, String lastName, String userName, String password, Boolean active,
							   String address, String phone , String photo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.active = true;
		this.address = address;
		this.phone = phone;
		this.photo = photo;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String email) {
		this.userName = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
		System.out.print(this.address);
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
