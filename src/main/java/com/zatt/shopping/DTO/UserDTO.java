package com.zatt.shopping.DTO;

import java.sql.Timestamp;

import com.zatt.shopping.Model.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	private Timestamp data_cadastro;

	// converto um usuárioDto para um usuário
	public Users convertDtoToUser(UserDTO userdto) {
		Users user = new Users();

		user.setNome(userdto.getNome());
		user.setCpf(userdto.getCpf());
		user.setEndereco(userdto.getEndereco());
		user.setEmail(userdto.getEmail());
		user.setTelefone(userdto.getTelefone());
		user.setData_cadastro(userdto.getData_cadastro());

		return user;
	};

}
