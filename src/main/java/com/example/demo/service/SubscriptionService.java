package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Subscription;
import com.example.demo.repository.SubscriptionRepository;

@Service
public class SubscriptionService {
	
	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	public List<Subscription> fetchAllbook() {
		return subscriptionRepository.findAll();
	}

	public void Save(Subscription subscription) {
		// TODO Auto-generated method stub	
	subscriptionRepository.save(subscription);
	}

	public Subscription get(int  subscriptionId) {
		// TODO Auto-generated method stub
		 return subscriptionRepository.findById(subscriptionId).get();
		
	}

	public void delete(int subscriptionId) {
		// TODO Auto-generated method stub
		subscriptionRepository.deleteById(subscriptionId);  
	}
}
