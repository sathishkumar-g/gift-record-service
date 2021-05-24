package com.sugysri.birthday.giftrecordservice.models;

import java.io.Serializable;

public class GiftRecordItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int serialNumber;
	private String name;
	private String area;
	private String city;
	private String job;
	private int amount;
	private String gift;
	private String gold;

	/**
	 * @return the serialNumber
	 */
	public int getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param serialNumber the serialNumber to set
	 */
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the gift
	 */
	public String getGift() {
		return gift;
	}

	/**
	 * @param gift the gift to set
	 */
	public void setGift(String gift) {
		this.gift = gift;
	}

	/**
	 * @return the gold
	 */
	public String getGold() {
		return gold;
	}

	/**
	 * @param gold the gold to set
	 */
	public void setGold(String gold) {
		this.gold = gold;
	}

	public GiftRecordItem(int serialNumber, String name, String area, String city, String job, int amount, String gift,
			String gold) {
		super();
		this.serialNumber = serialNumber;
		this.name = name;
		this.area = area;
		this.city = city;
		this.job = job;
		this.amount = amount;
		this.gift = gift;
		this.gold = gold;
	}

	public GiftRecordItem() {

	}
}
