package com.fenast.ibextube.repository;

import com.fenast.ibextube.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

/*    @Query("SELECT  DISTINCT user FROM User user "+
            "INNER JOIN FETCH user.authorities AS authorities " +
            "WHERE user.username = :username")*/
    @Query(value = "Select * from User u WHERE u.user_name = :username",nativeQuery = true)
    User findByUsername(@Param("username") String username);
}
