package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Subscription;
import com.example.demo.service.SubscriptionService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class SubscriptionController {

	@Autowired
	SubscriptionService subscriptionService;
	 
	@GetMapping(path="/subscription")
    public List<Subscription>  getBookDetails() {
		return subscriptionService.fetchAllbook();  
    }
	
	@GetMapping("/subscription/{subscriptionId}")
	public Subscription getSubscriptionbyName(@PathVariable int  subscriptionId ) {
		return subscriptionService.get(subscriptionId);
	}
	
	@RequestMapping(value = "/subscription/subscriptionServiceSave", method = RequestMethod.POST)
	@ResponseBody
	public int createSubscription(@RequestBody Subscription subscription)  
	{  
		subscriptionService.Save(subscription);
		 return subscription.getSubscriptionId();
	}  
	
	@DeleteMapping("/subscription/{subscriptionId}")  
	private void deletesubscriptio(@PathVariable("subscriptionId") int subscriptionId)   
	{  
		subscriptionService.delete(subscriptionId);  
	}  
}
