package be.steven.d.dog.contactlistbackend.security.repository;

import be.steven.d.dog.contactlistbackend.security.model.Role;
import be.steven.d.dog.contactlistbackend.security.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleType name);
}