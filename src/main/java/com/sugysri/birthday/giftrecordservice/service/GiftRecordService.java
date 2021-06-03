package com.sugysri.birthday.giftrecordservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sugysri.birthday.giftrecordservice.models.GiftRecord;
import com.sugysri.birthday.giftrecordservice.models.GiftRecordItem;

@Service
@CacheConfig
public class GiftRecordService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${gift.record.get.url}")
	private String getUrl;

	@Value("${gift.record.add.url}")
	private String addUrl;

	@Value("${gift.record.edit.url}")
	private String updateUrl;

	@Value("${gift.record.delete.url}")
	private String deleteUrl;

	@Value("${gift.record.delete.multiple.url}")
	private String deleteMultipleUrl;

	public GiftRecord getGiftRecord() {
		GiftRecord giftRecord = null;
		// giftRecord =
		// restTemplate.getForObject("https://get-gift-record-service.herokuapp.com/gift/get",
		// GiftRecord.class);
		giftRecord = restTemplate.getForObject(getUrl, GiftRecord.class);
		return giftRecord;
	}

	public GiftRecordItem editGiftRecord(GiftRecordItem giftRecordItem) {
		// return
		// restTemplate.getForObject("https://get-gift-record-service.herokuapp.com/gift/edit",
		// GiftRecordItem.class);
		return restTemplate.postForObject(updateUrl, giftRecordItem, GiftRecordItem.class);
	}

	public void deleteGiftRecord(GiftRecordItem giftRecordItem) {
		restTemplate.postForObject(deleteUrl, giftRecordItem, GiftRecordItem.class);
	}

	public void deleteGiftRecords(GiftRecord giftRecord) {
		restTemplate.postForObject(deleteMultipleUrl, giftRecord, GiftRecordItem.class);
	}

	public GiftRecordItem addGiftRecord(GiftRecordItem giftRecordItem) {
		return restTemplate.postForObject(addUrl, giftRecordItem, GiftRecordItem.class);
	}

}
