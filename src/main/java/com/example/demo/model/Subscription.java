package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="SUBSCRIPTION") 
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subscriptionId;

    
    @Column(name = "SUBSCRIPTION_NAME")
	private String subscriptionName;
	
    @Column(name = "DATE_SUBSCRIPTION")
	private String dateSubscription;
	
	@Column(name = "DATE_RETRUNED")
	private String dateRetuned;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", referencedColumnName = "bookId")
    @JsonIgnoreProperties("storyList")
    private Book book;

    public int getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(int subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

	public String getSubscriptionName() {
		return subscriptionName;
	}

	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}

	public String getDateSubscription() {
		return dateSubscription;
	}

	public void setDateSubscription(String dateSubscription) {
		this.dateSubscription = dateSubscription;
	}

	public String getDateRetuned() {
		return dateRetuned;
	}

	public void setDateRetuned(String dateRetuned) {
		this.dateRetuned = dateRetuned;
	}

}