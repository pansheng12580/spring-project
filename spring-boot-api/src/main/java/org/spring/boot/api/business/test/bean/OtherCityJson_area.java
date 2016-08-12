package org.spring.boot.api.business.test.bean;

import java.util.List;

public class OtherCityJson_area {
	private String name;//城市
	private List<String> area;//城市代码
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getArea() {
		return area;
	}
	public void setArea(List<String> area) {
		this.area = area;
	}
}
