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
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
		
	}
	
	@GetMapping("equipment")
	public List<Equipment> showAllEquipment(){
		return eSvc.index();
		
	}
	
	@GetMapping("equipment/{id}")
	public Equipment showEquipmentById(@PathVariable("id") int id, HttpServletResponse resp) {
		Equipment equip =  eSvc.show(id);
		if (equip == null) {
			resp.setStatus(404);
		}	
		return equip;
		
	}
	
	@PostMapping("equipment")
	public Equipment createEquipment(@RequestBody Equipment equipment) {
		Equipment equip = eSvc.create(equipment);
		return equip;
		
	}
	
	@PutMapping("equipment/{id}")
	public Equipment updateEquipment(@RequestBody Equipment equipment, @PathVariable("id") int id) {
		equipment = eSvc.update(equipment, id);		
		return equipment;
		
	}
	
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
