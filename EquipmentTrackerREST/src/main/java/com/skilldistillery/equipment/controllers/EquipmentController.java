package com.skilldistillery.equipment.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.equipment.entities.Equipment;
import com.skilldistillery.equipment.services.EquipmentService;

@RestController
@RequestMapping("api")
public class EquipmentController {
	
	@Autowired
	EquipmentService eSvc;
	
	// this is just to test whether I can access my entity in post man for testing purposes
	@GetMapping("ping")
	public String ping() {
		return "pong";
		
	}
	
	// shows the list of item/entity
	@GetMapping("equipment")
	public List<Equipment> showAllEquipment(){
		return eSvc.index();
		
	}
	
	// shows a specific item/entity based on the id provided
	@GetMapping("equipment/{id}")
	public Equipment showEquipmentById(@PathVariable("id") int id, HttpServletResponse resp) {
		Equipment equip =  eSvc.show(id);
		if (equip == null) {
			resp.setStatus(404);
		}	
		return equip;
		
	}
	
	// add an item/entity to the list through a create method
	@PostMapping("equipment")
	public Equipment createEquipment(@RequestBody Equipment equipment, HttpServletResponse resp) {	
		Equipment equip = eSvc.create(equipment);
		if (equip != null) {
			resp.setStatus(201);
		}else {
			resp.setStatus(400);
		}
		return equip;
		
	}
	
	// able to edit a specific item/entity based on the id provided
	@PutMapping("equipment/{id}")
	public Equipment updateEquipment(@RequestBody Equipment equipment, @PathVariable("id") int id) {
		equipment = eSvc.update(equipment, id);		
		return equipment;
		
	}
	
	// able to delete a specific item/entity based on the id provided
	@DeleteMapping("equipment/{id}")
	public Boolean deleteEquipment(@PathVariable("id") int id, HttpServletResponse resp) {
		Boolean result = eSvc.delete(id);
		if(result) {
			resp.setStatus(204);
			result = null;
		}else {
			resp.setStatus(404);
		}
		return result;
		
	}
	

}
