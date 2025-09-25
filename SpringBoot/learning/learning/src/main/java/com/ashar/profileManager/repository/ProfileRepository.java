package com.ashar.profileManager.repository;

import com.ashar.profileManager.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Integer> {


//    public List<Profile> findAllByName(@Param("name") String name);
//
//    @Transactional
//    @Modifying
//    @Query("delete from Profile p where p.name= :Pname")
//    void deleteByName(@Param("Pname") String name);


//    @Query(value = "select p from Profile p where p.username = :name")
    Optional<Profile> findByUsername(String name);

    @Modifying
    @Transactional
    @Query("update Profile p set p.username = :name, p.password = :password where p.id = :id")
    int updateUsernameAndPasswordById(int id,String name,String password);

}
