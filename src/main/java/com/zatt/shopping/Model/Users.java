package com.zatt.shopping.Model;

import java.sql.Timestamp;

import com.zatt.shopping.DTO.UserDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users_id")
	@SequenceGenerator(name = "seq_users_id", sequenceName = "seq_users_id", allocationSize = 1)
	private Long id;
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	private Timestamp data_cadastro;

	// Converto um usuário para usuárioDto
	public UserDTO convertToDto(Users user) {
		UserDTO userdto = new UserDTO();
		userdto.setNome(user.getNome());
		userdto.setCpf(user.getCpf());
		userdto.setEndereco(user.getEndereco());
		userdto.setEmail(user.getEmail());
		userdto.setTelefone(user.getTelefone());
		userdto.setData_cadastro(user.getData_cadastro());
		return userdto;
	};

}
