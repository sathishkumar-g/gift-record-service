package com.sugysri.birthday.giftrecordservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sugysri.birthday.giftrecordservice.models.GiftRecord;
import com.sugysri.birthday.giftrecordservice.models.GiftRecordItem;

@Service
public class GiftRecordService {

	@Autowired
	private RestTemplate restTemplate;

	@Cacheable(value = "giftRecordsCache")
	public GiftRecord getGiftRecord() {
		GiftRecord giftRecord = null;
		// giftRecord =
		// restTemplate.getForObject("https://get-gift-record-service.herokuapp.com/gift/get",
		// GiftRecord.class);
		giftRecord = restTemplate.getForObject("https://get-gift-record-service.herokuapp.com/gift/get", GiftRecord.class);
		return giftRecord;
	}

	public GiftRecordItem editGiftRecord(GiftRecordItem giftRecordItem) {
		// return
		// restTemplate.getForObject("https://get-gift-record-service.herokuapp.com/gift/edit",
		// GiftRecordItem.class);
		return restTemplate.postForObject("https://get-gift-record-service.herokuapp.com/gift/edit", giftRecordItem,
				GiftRecordItem.class);
	}

	public void deleteGiftRecord(GiftRecordItem giftRecordItem) {
		restTemplate.postForObject("https://get-gift-record-service.herokuapp.com/gift/delete", giftRecordItem,
				GiftRecordItem.class);
	}

	public void deleteGiftRecords(GiftRecord giftRecord) {
		restTemplate.postForObject("https://get-gift-record-service.herokuapp.com/gift/selectiveDelete", giftRecord,
				GiftRecordItem.class);
	}

	public GiftRecordItem addGiftRecord(GiftRecordItem giftRecordItem) {
		return restTemplate.postForObject("https://get-gift-record-service.herokuapp.com/gift/add", giftRecordItem,
				GiftRecordItem.class);
	}

}
