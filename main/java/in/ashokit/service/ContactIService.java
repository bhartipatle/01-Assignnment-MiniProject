package in.ashokit.service;

import java.util.*;

import in.ashokit.domain.ContactInfo;

public interface ContactIService {
	
	public Boolean addContact(ContactInfo contactInfo);
	public List<ContactInfo> viewContact();
	public ContactInfo getContactById(Integer id);
	public Boolean deleteContact(Integer id);
}
