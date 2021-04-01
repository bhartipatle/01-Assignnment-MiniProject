package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import in.ashokit.domain.ContactInfo;
import in.ashokit.service.ContactIService;

@Controller
public class ContactInfoController {
	
	private ContactIService service;
	
	public ContactInfoController(ContactIService service) {
		this.service = service;
	}
	
	/**
	 * This method is used to display contact form
	 * 
	 * @return
	 */
	@GetMapping("/load-form")
	public String loadForm(Model model) {
		ContactInfo cobj = new ContactInfo();

		// sending data from controller to ui
		model.addAttribute("contact", cobj);

		// returning logical view name
		return "contact";
	}
	
	@PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact") ContactInfo contact, Model model) {
		String status="";
		if(contact.getContactId() == null) {
			status = "save";
		}
		boolean isSaved = service.addContact(contact);
		if (isSaved) {
			if("save".equals(status)) {				
				model.addAttribute("succMsg", "Contact saved");
			 }
		    else{
				model.addAttribute("succMsg", "Contact Updated Successfully");
			}
		}
		else {
			model.addAttribute("failMsg", "Failed to save contact");
		}
		return "contact";
	}

	@GetMapping( "/view-contacts")
	public String handleViewsContactHyperLink(Model model) {
		List<ContactInfo> contactList = service.viewContact();
		model.addAttribute("contacts", contactList);
		return "contactDisplay";
	}
}
