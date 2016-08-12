package org.spring.boot.api.business.test.bean;

import java.util.List;

public class CityJson_city {

	private String p;//省份
	private List<CityJson_area> c;//城市列表
	public String getP() {
		return p;
	}
	public void setP(String p) {
		this.p = p;
	}
	public List<CityJson_area> getC() {
		return c;
	}
	public void setC(List<CityJson_area> c) {
		this.c = c;
	}


}
