package org.spring.boot.api.business.test.bean;

import java.util.List;

public class OtherCityJson_city {
	private String name;//省份
	private List<OtherCityJson_area> city;//城市列表
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<OtherCityJson_area> getCity() {
		return city;
	}
	public void setCity(List<OtherCityJson_area> city) {
		this.city = city;
	}
}
