package bank.api.user.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.api.user.DTO.UserDTO;
import bank.api.user.model.UserModel;
import bank.api.user.model.UserRepository;


@Service
public class UserService {
	UserRepository userrepository;
	@Autowired
	public UserService(UserRepository userrepository) {
		this.userrepository=userrepository;	
	}
	public UserDTO createUser(UserDTO userDTO) {
		
		userDTO.setUserId(UUID.randomUUID().toString());
		userDTO.setEncryptedPassword("Test123");	
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserModel usermodel=  modelMapper.map(userDTO, UserModel.class);
		userrepository.save(usermodel);
		UserDTO returnValue=  modelMapper.map(usermodel, UserDTO.class);
		return returnValue;		
	}

}
