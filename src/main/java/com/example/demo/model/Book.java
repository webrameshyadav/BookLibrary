package com.example.demo.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;

    @Column(name = "BOOK_NAME")
    private String bookName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("book")
    private List<Subscription> subscriptionList = new ArrayList<>();
    
    
    
    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "AVAILABLE_COPIES")
    private Integer availableCopies;
    
    @Column(name = "TOTAL_COPIES")
    private Integer totalCopies;
    
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Subscription> getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(List<Subscription> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

	public String getAUTHOR() {
		return author;
	}

	public void setAUTHOR(String author) {
		this.author = author;
	}

	public Integer getAVAILABLE_COPIES() {
		return availableCopies;
	}

	public void setAVAILABLE_COPIES(Integer availableCopies) {
		this.availableCopies = availableCopies;
	}

	public Integer getTOTAL_COPIES() {
		return totalCopies;
	}

	public void setTOTAL_COPIES(Integer totalCopies) {
		this.totalCopies = totalCopies;
	}
	

}
