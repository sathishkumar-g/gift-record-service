package com.sugysri.birthday.giftrecordservice.models;

import org.springframework.beans.factory.annotation.Value;

public final class ServiceConstants {
	@Value("${user.authenticate.url}")
	private String authUrl;

	@Value("${user.register.url}")
	private String registerUrl;

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
	
	@Value("${cors.dev.url}")
	private String corsDevUrl;
	
	@Value("${cors.prod.url}")
	private String corsProdUrl;

	public String getAuthUrl() {
		return authUrl;
	}

	public String getRegisterUrl() {
		return registerUrl;
	}

	public String getGetUrl() {
		return getUrl;
	}

	public String getAddUrl() {
		return addUrl;
	}

	public String getUpdateUrl() {
		return updateUrl;
	}

	public String getDeleteUrl() {
		return deleteUrl;
	}

	public String getDeleteMultipleUrl() {
		return deleteMultipleUrl;
	}

	public String getCorsDevUrl() {
		return corsDevUrl;
	}

	public String getCorsProdUrl() {
		return corsProdUrl;
	}
	
	
}
