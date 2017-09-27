package com.zhouf.chart;

import java.util.ArrayList;
import java.util.List;

public class BarDataBean {

	private List<String> categories;
	private List<Number> data;

	public BarDataBean() {
		super();
		categories = new ArrayList<String>();
		data = new ArrayList<Number>();
	}

	public void addData(String name, Number value) {
		categories.add(name);
		data.add(value);
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<Number> getData() {
		return data;
	}

	public void setData(List<Number> data) {
		this.data = data;
	}
}
