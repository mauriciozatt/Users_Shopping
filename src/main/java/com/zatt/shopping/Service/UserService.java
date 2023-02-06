package com.zatt.shopping.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zatt.shopping.DTO.UserDTO;
import com.zatt.shopping.Model.Users;
import com.zatt.shopping.Repository.UserRepository;

//Service - Usado para add a regras de negócio, essa será responsável por chamar o meu reposiory...

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	};

	public List<UserDTO> getAll() {

		List<Users> vListaDeUsuarios = userRepository.findAll();

		List<UserDTO> vListaUsuarioDto = new ArrayList<UserDTO>();

		// Percoro minha lista de usuários e converto para usuáriosDto... Pois DTO e
		// minha classe de transferência de dados Data tranfer Object...
		for (Users user : vListaDeUsuarios) {
			vListaUsuarioDto.add(user.convertToDto(user));
		}

		return vListaUsuarioDto;
	};

	// findByID
	public UserDTO findByID(Long id) {

		// Optional, pois pode ser que o Id passado não exista e dassa forma o retorno
		// do FindById pode ser null...
		Optional<Users> user = userRepository.findById(id);

		if (user.isPresent()) {
			return user.get().convertToDto(user.get());
		} else
			return null;
	};

	// findByCpf

	public UserDTO findByCpf(String cpf) {

		Optional<Users> user = userRepository.findByCpf(cpf);

		if (user.isPresent()) {
			return user.get().convertToDto(user.get());
		} else
			return null;

	};

	// queryByName

	public List<UserDTO> queryByName(String nome) {

		List<Users> vListaUsuarios = userRepository.queryByNomeLike(nome);

		List<UserDTO> vListaUsariosDto = new ArrayList<UserDTO>();

		// vou percorrer minha lista de usuários e converter para UserDTO
		for (Users user : vListaUsuarios) {
			vListaUsariosDto.add(user.convertToDto(user));
		};

		return vListaUsariosDto;
	};

	// Salvar
	public UserDTO salvar(UserDTO userDto) {
		Users user = userDto.convertDtoToUser(userDto);
		userRepository.save(user);

		return user.convertToDto(user);
	};

	// Deletar
	public Boolean deletar(UserDTO userdto) {
		Users user = userdto.convertDtoToUser(userdto);

		if (userRepository.findById(user.getId()).isPresent()) {
			userRepository.delete(user);
			return true;
		} else
			return false;
	};

	public Boolean deletar(Long id) {
		Optional<Users> user = userRepository.findById(id);

		if (user.isPresent()) {
			userRepository.delete(user.get());
			return true;
		} else {
			return false;
		}

	}

}
