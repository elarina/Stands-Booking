package com.larina.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.larina.model.Stand;
import com.larina.model.StandsGroup;
import com.larina.model.StandsGroupRelation;
import com.larina.repositories.StandGroupRepository;
import com.larina.repositories.StandsGroupRelationRepository;
import com.larina.repositories.StandsRepository;
import com.larina.ui.BookingStandButton;
import com.larina.ui.BookingStandGroup;

@Controller
public class BookingController {
	private StandsRepository standsRepository;
	private StandGroupRepository standGroupRepository;
	private StandsGroupRelationRepository standGroupRelationRepository;

	public BookingController(StandsRepository standsRepository, StandGroupRepository standGroupRepository,
			StandsGroupRelationRepository standGroupRelationRepository) {
		this.standsRepository = standsRepository;
		this.standGroupRepository = standGroupRepository;
		this.standGroupRelationRepository = standGroupRelationRepository;
	}

	@GetMapping("/booking")
	public String openBooking(@RequestParam(value = "groupId", required = false) Long parentGroupId,
								@RequestParam(required = true) String source,
			Model model) {
		
		
		List<BookingStandButton> bookingEntities = standsRepository.findAll().stream()
				.filter(sr -> parentGroupId == null ? source.contains("stands") : sr.getGroup() != null && sr.getGroup().getId().equals(parentGroupId))
				.map((Stand s) -> new BookingStandButton(s.getName(), s.getId(), "/bookingStand")).toList();

		List<StandsGroupRelation> sgrs = standGroupRelationRepository.findAll().stream()
				.filter(sgr -> parentGroupId == null ? source.contains("groups")  : sgr.getParentGroupId().equals(parentGroupId)).toList();

		List<StandsGroup> rootGroups = standGroupRepository.findAll().stream()
				.filter(sg -> !sgrs.stream().map(sgr -> sgr.getChildGroupId()).toList().contains(sg.getId())).toList();

		List<BookingStandGroup> groups = standGroupRepository.findAll().stream()
				.filter(sr -> source.contains("groups") && parentGroupId == null ? rootGroups.contains(sr)
						: sgrs.stream().anyMatch(sgr -> sgr.getChildGroupId().equals(sr.getId())))
				.map((StandsGroup sg) -> new BookingStandGroup(sg.getName(), sg.getId(), "/booking?source=groups&groupId="))
				.toList();

		model.addAttribute("source", source);
		model.addAttribute("groups", groups);
		model.addAttribute("buttons", bookingEntities);
		return "booking";
	}

}
