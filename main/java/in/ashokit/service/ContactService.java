package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.ashokit.domain.ContactInfo;
import in.ashokit.resource.ContactRepository;

@Service
public class ContactService implements ContactIService {
	
	private ContactRepository contactRepo;
	
	public ContactService(ContactRepository contactRepo) {
		// TODO Auto-generated constructor stub
		this.contactRepo = contactRepo;
	}
	
	@Override
	public Boolean addContact(ContactInfo contactInfo) {
		// TODO Auto-generated method stub
		ContactInfo contactSaved = contactRepo.save(contactInfo);
		return contactSaved.getContactId() !=null;
	}
	@Override
		public List<ContactInfo> viewContact() {
			// TODO Auto-generated method stub
			return contactRepo.findAll();
		}
	@Override
		public ContactInfo getContactById(Integer id) {
			// TODO Auto-generated method stub
			Optional<ContactInfo> contact = contactRepo.findById(id);
			if(contact.isPresent()) {
				return contact.get();
			}
			return null;
		}
	@Override
		public Boolean deleteContact(Integer id) {
		 	try {
		 		contactRepo.deleteById(id);
		 		return true;
		 	}
		 	catch (Exception e) {
				// TODO: handle exception
		 		e.printStackTrace();
			} 	
			return false;
		}
}
