package ba.sum.fpmoz.mymath.repository;

import ba.sum.fpmoz.mymath.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository <User, Long> {}
