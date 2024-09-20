package com.jt.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.jt.backend.models.History;
import com.jt.backend.models.InternalMessages;
import com.jt.backend.services.HistoryServices;

import utils.SecurityUtils;

@RestController
@CrossOrigin(origins = "*")
public class HistoryController {

	private HistoryServices historyServices;

	@Autowired
	public HistoryController(HistoryServices historyServices) {
		this.historyServices=historyServices;
	}

	@PostMapping("/history")
	public ResponseEntity<?> addHistory(@RequestBody History history){
		
		
		InternalMessages response = this.historyServices.createHistory(history);

		if (response.getId()==0) {
			return ResponseEntity.internalServerError().body(response.getMessage());
		}else {
			return ResponseEntity.ok().body(response.getMessage());     
		}

	}

	@GetMapping("/history")
	public ResponseEntity<?> getHistorys(){
		InternalMessages response = this.historyServices.getHistory(SecurityUtils.getCurrentUser().getId());

		if (response.getId()==0) {
			return ResponseEntity.internalServerError().body(response.getMessage());
		}else {
			try {
				//return ResponseEntity.ok().body(response.getAdditionalInfo());
				List parsedList = (List)(response.getAdditionalInfo()) ;
				return ResponseEntity.ok().body(parsedList);
			}catch (Exception e) {
				return ResponseEntity.ok().body(response.getAdditionalInfo().toString());
			}

		}
	}
}
