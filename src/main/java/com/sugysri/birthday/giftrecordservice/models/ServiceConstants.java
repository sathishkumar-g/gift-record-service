package com.sugysri.birthday.giftrecordservice.models;

import org.springframework.beans.factory.annotation.Value;

public class ServiceConstants {
	@Value("${user.authenticate.url}")
	public String authUrl;
	
	@Value("${user.register.url}")
	public String registerUrl;
	
	@Value("${gift.record.get.url}")
	public String getUrl;

	@Value("${gift.record.add.url}")
	public String addUrl;

	@Value("${gift.record.edit.url}")
	public String updateUrl;

	@Value("${gift.record.delete.url}")
	public String deleteUrl;

	@Value("${gift.record.delete.multiple.url}")
	public String deleteMultipleUrl;
}
