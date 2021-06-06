package com.sugysri.birthday.giftrecordservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sugysri.birthday.giftrecordservice.models.GiftRecord;
import com.sugysri.birthday.giftrecordservice.models.GiftRecordItem;
import com.sugysri.birthday.giftrecordservice.models.ServiceConstants;

@Service
@CacheConfig
public class GiftRecordService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ServiceConstants serviceConstants;
	
	public GiftRecord getGiftRecord() {
		GiftRecord giftRecord = null;
		// giftRecord =
		// restTemplate.getForObject("https://get-gift-record-service.herokuapp.com/gift/get",
		// GiftRecord.class);
		giftRecord = restTemplate.getForObject(serviceConstants.getGetUrl(), GiftRecord.class);
		return giftRecord;
	}

	public GiftRecordItem editGiftRecord(GiftRecordItem giftRecordItem) {
		// return
		// restTemplate.getForObject("https://get-gift-record-service.herokuapp.com/gift/edit",
		// GiftRecordItem.class);
		return restTemplate.postForObject(serviceConstants.getUpdateUrl(), giftRecordItem, GiftRecordItem.class);
	}

	public void deleteGiftRecord(GiftRecordItem giftRecordItem) {
		restTemplate.postForObject(serviceConstants.getDeleteUrl(), giftRecordItem, GiftRecordItem.class);
	}

	public void deleteGiftRecords(GiftRecord giftRecord) {
		restTemplate.postForObject(serviceConstants.getDeleteMultipleUrl(), giftRecord, GiftRecordItem.class);
	}

	public GiftRecordItem addGiftRecord(GiftRecordItem giftRecordItem) {
		return restTemplate.postForObject(serviceConstants.getAddUrl(), giftRecordItem, GiftRecordItem.class);
	}

}
