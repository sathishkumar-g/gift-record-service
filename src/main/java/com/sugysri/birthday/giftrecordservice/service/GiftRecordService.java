package com.sugysri.birthday.giftrecordservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sugysri.birthday.giftrecordservice.models.GiftRecord;

@Service
public class GiftRecordService {

	@Autowired
	private RestTemplate restTemplate;

	@Cacheable(value="giftRecordsCache")
	public GiftRecord getGiftRecord() {
		GiftRecord giftRecord = null;
		giftRecord = restTemplate.getForObject("https://get-gift-record-service.herokuapp.com/get/", GiftRecord.class);
		return giftRecord;
	}

	/*
	 * public GiftRecord addGiftRecord() {
	 * 
	 * }
	 * 
	 * public GiftRecord editGiftRecord() {
	 * 
	 * }
	 * 
	 * public GiftRecord deleteGiftRecord() {
	 * 
	 * }
	 */

}
