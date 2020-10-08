package bank.api.user.UI.Mapper;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateBankUserRequest {
	
	@NotNull(message="firstName Cannot be Empty")
	@Size(min = 4,  message = "firstName can not be less than 4 charcters ")
	private String firstName;
	@NotNull(message="lastName Cannot be Empty")
	private String lastName;
	@NotNull(message="email Cannot be Empty")
	@Email()
	private String email;
	@NotNull(message ="Password Cannot be empty")
	private String password;
	
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
