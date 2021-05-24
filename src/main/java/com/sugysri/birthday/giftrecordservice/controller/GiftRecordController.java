package com.sugysri.birthday.giftrecordservice.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sugysri.birthday.giftrecordservice.models.GiftRecord;
import com.sugysri.birthday.giftrecordservice.service.GiftRecordService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/giftRecord")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class GiftRecordController {
	@Autowired
	private GiftRecordService giftRecordService;

	@RequestMapping("/get")
	@CircuitBreaker(name="giftRecordService", fallbackMethod = "giftRecordFallback")
	public GiftRecord getGiftRecord() {
		return giftRecordService.getGiftRecord();
	}
	
	public GiftRecord giftRecordFallback(Exception e) {
		return giftRecordService.getGiftRecord();
	}

	/*
	 * @RequestMapping("/add") public GiftRecord addGiftRecord() {
	 * 
	 * }
	 * 
	 * @RequestMapping("/edit") public GiftRecord editGiftRecord() {
	 * 
	 * }
	 * 
	 * @RequestMapping("/delete") public GiftRecord deleteGiftRecord() {
	 * 
	 * }
	 */

}
