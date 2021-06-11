package be.steven.d.dog.contactlistbackend.repository;

import be.steven.d.dog.contactlistbackend.model.Role;
import be.steven.d.dog.contactlistbackend.model.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType name);
}