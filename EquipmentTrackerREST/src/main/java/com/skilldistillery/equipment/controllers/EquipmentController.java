package com.skilldistillery.equipment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.equipment.entities.Equipment;
import com.skilldistillery.equipment.services.EquipmentService;

@RestController
@RequestMapping("api")
public class EquipmentController {
	
	@Autowired
	EquipmentService eSvc;
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
		
	}
	
	@GetMapping("equipment")
	public List<Equipment> showAllEquipment(){
		return eSvc.index();
		
	}
	

}
