package br.com.gabengcdev.logoattacher.controller;

import br.com.gabengcdev.logoattacher.view.ViewFactory;

public abstract class BaseController {
	
	protected static ViewFactory viewFactory;
	private String fxmlName;
	
	public BaseController(ViewFactory viewFactory, String fxmlName) {
		BaseController.viewFactory = viewFactory;
		this.fxmlName = fxmlName;
	}

	public String getFxmlName() {
		return fxmlName;
	}
	
	
}
