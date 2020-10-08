package bank.api.user.controller;


import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bank.api.user.DTO.UserDTO;
import bank.api.user.UI.Mapper.CreateBankUserRequest;
import bank.api.user.UI.Mapper.CreateUserResponse;
import bank.api.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService ;
	
	
	@RequestMapping ("/test") 
	public String test() {
		return "Working";
	}
	
	@PostMapping(path = "/createUser")
	public ResponseEntity<CreateUserResponse> createUser(@RequestBody  @Valid CreateBankUserRequest createBankUserRequest) {
		ModelMapper modelMapper = new ModelMapper(); 
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);		
		UserDTO userDTO= modelMapper.map(createBankUserRequest, UserDTO.class);
		UserDTO savedUser=  userService.createUser(userDTO);
		CreateUserResponse retrunValue= modelMapper.map(savedUser, CreateUserResponse.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(retrunValue);	
		}

}
