package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.domain.ContactInfo;
import in.ashokit.service.ContactService;

@Controller
public class ContactOperationController {
	
	private ContactService service;
	
	public ContactOperationController(ContactService service) {
		super();
		this.service = service;
	}

	@GetMapping("/edit")
	public String editContact(@RequestParam("cid") Integer contactId, Model model) {
	ContactInfo contactObj = service.getContactById(contactId);
	model.addAttribute("contact", contactObj);
	 return "contact";
	}
	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("cid") Integer contactId, Model model) {
	 boolean isdeleted = service.deleteContact(contactId);
	 if(isdeleted) {
		 model.addAttribute("succMsg", "Contact deleted successfully");
	 }
	 else {
		 model.addAttribute("failMsg", "Failed to  delete contact");
	 }
	 return "redirect:view-contacts";
	}
}

