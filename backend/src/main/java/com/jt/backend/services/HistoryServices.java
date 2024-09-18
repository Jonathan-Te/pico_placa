package com.jt.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.backend.dto_models.HistoryDto;
import com.jt.backend.models.Car;
import com.jt.backend.models.History;
import com.jt.backend.models.InternalMessages;
import com.jt.backend.models.User;
import com.jt.backend.repositories.HistoryRepository;

@Service
public class HistoryServices {

	@Autowired
	private HistoryRepository historyRepository;
	
	public HistoryServices(HistoryRepository historyRepository) {
		this.historyRepository=historyRepository;
	}
	
	public InternalMessages createHistory(HistoryDto historyDto, User user) {
		
		History history= new History();
		history.setPlate(historyDto.getPlate());
		history.setQueryDate(historyDto.getQueryDate());
		history.setQueriedDate(historyDto.getQueriedDate());
		history.setAllowed(historyDto.isAllowed());
		history.setUser(user);
		
		
		try {
			this.historyRepository.save(history);
			return new InternalMessages();
		}catch (Exception e) {
			return new InternalMessages(0,"Error",e.toString());
		}
	}
	
	public InternalMessages getHistory(Long userId) {
		InternalMessages internalMessages = new InternalMessages();
				
		try {
			internalMessages.setAdditionalInfo(this.historyRepository.findByUserId(userId));
			return internalMessages;
		}catch (Exception e) {
			return new InternalMessages(0,"Error",e.toString());
		}
	}
}