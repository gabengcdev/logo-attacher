module logoAttacherModule {
	
	requires javafx.fxml;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.web;
	requires java.desktop;
	
	opens br.com.gabengcdev.logoattacher;
	opens br.com.gabengcdev.logoattacher.view;
	opens br.com.gabengcdev.logoattacher.model;
	opens br.com.gabengcdev.logoattacher.controller;
}