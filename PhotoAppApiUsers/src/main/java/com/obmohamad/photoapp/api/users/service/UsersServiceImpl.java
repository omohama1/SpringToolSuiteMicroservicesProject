package com.obmohamad.photoapp.api.users.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.obmohamad.photoapp.api.users.data.UserEntity;
import com.obmohamad.photoapp.api.users.data.UsersRepository;
import com.obmohamad.photoapp.api.users.shared.UsersDto;

@Service
public class UsersServiceImpl implements UsersService {

	UsersRepository userRepository;
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UsersServiceImpl(UsersRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder)
	
	{
		this.userRepository= usersRepository;
		this.bCryptPasswordEncoder= bCryptPasswordEncoder;
	}
	
	@Override
	public UsersDto createUser(UsersDto userDetails) {
		
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		userRepository.save(userEntity);
		UsersDto returnValue = modelMapper.map(userEntity,UsersDto.class);
		
		return returnValue;
	}

}
