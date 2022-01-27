package com.github.keren.novais.demo.controller;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class HomeController implements Serializable {

	private static final long serialVersionUID = -617856396166969682L;

	private Date actualDate = new Date();
	
	public HomeController() {
		init();
	}

	@PostConstruct
	public void init() {

	}

	public Date getActualDate() {
		return actualDate;
	}

	public void setActualDate(Date actualDate) {
		this.actualDate = actualDate;
	}

	
	
}
