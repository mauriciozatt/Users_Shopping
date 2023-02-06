package com.zatt.shopping.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.zatt.shopping.Model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByCpf(String cpf);

	List<Users> queryByNomeLike(String nome);

}
