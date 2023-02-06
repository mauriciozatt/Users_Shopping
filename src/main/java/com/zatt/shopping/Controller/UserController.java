package com.zatt.shopping.Controller;


import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zatt.shopping.DTO.UserDTO;
import com.zatt.shopping.Service.UserService;


@RestController
public class UserController {

	private UserService services;

	// faço injeção de dependência atráves do meu construtor
	public UserController(UserService services) {
		this.services = services;
	}

	@GetMapping(value = "/users")
	public List<UserDTO> getUsers() {
		return services.getAll();
	};

	@GetMapping(value = "/users/{id}")
	public UserDTO getUserById(@PathVariable Long id) {
		return services.findByID(id);
	}

	@GetMapping(value = "/users/cpf/{cpf}")
	public UserDTO getUserByCPF(@PathVariable String cpf) {
		return services.findByCpf(cpf);

	};

	@GetMapping(value = "/users/search")
	public List<UserDTO> queryByName(@RequestParam(name = "nome", required = true) String nome) {
		return services.queryByName(nome);
	};

	@PostMapping(value = "/users")
	public UserDTO newUser(@RequestBody UserDTO userdto) {
		services.salvar(userdto);
		return userdto;
	};

	@DeleteMapping(value = "/user/{id}")
	public Boolean delete(@PathVariable Long id) {
		return services.deletar(id);

	};

}
