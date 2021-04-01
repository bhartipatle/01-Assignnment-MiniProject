package in.ashokit.resource;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.domain.ContactInfo;

public interface ContactRepository extends JpaRepository<ContactInfo, Serializable> {

}
