package com.sugysri.birthday.giftrecordservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sugysri.birthday.giftrecordservice.models.GiftRecord;
import com.sugysri.birthday.giftrecordservice.models.GiftRecordItem;
import com.sugysri.birthday.giftrecordservice.service.GiftRecordService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/giftRecord")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GiftRecordController {
	@Autowired
	private GiftRecordService giftRecordService;

	@RequestMapping("/get")
	@CircuitBreaker(name = "giftRecordService", fallbackMethod = "giftRecordFallback")
	public GiftRecord getGiftRecord() {
		return giftRecordService.getGiftRecord();
	}

	public GiftRecord giftRecordFallback(Exception e) {
		return giftRecordService.getGiftRecord();
	}

	@PostMapping(path = "/edit", consumes = "application/json", produces = "application/json")
	public GiftRecordItem editGiftRecord(@RequestBody GiftRecordItem giftRecordItem) {
		return giftRecordService.editGiftRecord(giftRecordItem);
	}

	@PostMapping(path = "/delete", consumes = "application/json", produces = "application/json")
	public @ResponseBody String deleteGiftRecord(@RequestBody GiftRecordItem giftRecordItem) {
		giftRecordService.deleteGiftRecord(giftRecordItem);	
		return "SUCCESS";
	}
	
	@PostMapping(path = "/selectiveDelete", consumes = "application/json", produces = "application/json")
	public @ResponseBody String deleteGiftRecords(@RequestBody GiftRecord giftRecord) {
		giftRecordService.deleteGiftRecords(giftRecord);	
		return "SUCCESS";
	}
	
	@PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
	public GiftRecordItem addGiftRecord(@RequestBody GiftRecordItem giftRecordItem) {
		return giftRecordService.addGiftRecord(giftRecordItem);
	}

}
