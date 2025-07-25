package com.larina.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.larina.model.Stand;
import com.larina.repositories.StandsRepository;
import com.larina.ui.BookingStandButton;

@Controller
public class BookingController {
	private StandsRepository standsRepository;

	public BookingController(StandsRepository standsRepository) {
		this.standsRepository = standsRepository;
	}

	@GetMapping("/booking")
	public String openBooking(Model model) {
		List<BookingStandButton> bookingButtons = standsRepository
				.findAll()
				.stream()
				.map((Stand s) -> new BookingStandButton(s.getName(), s.getId(), "/bookingStand"))
				.toList();
		model.addAttribute("buttons", bookingButtons);
		return "booking";
	}
	
	
}
