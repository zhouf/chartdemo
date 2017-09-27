package com.zhouf.chart;

import java.util.ArrayList;
import java.util.List;

public class PieDataBean {
	
	class DataPair{
		private String name;
		private Number value;
		
		public DataPair(String name, Number value) {
			super();
			this.name = name;
			this.value = value;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Number getValue() {
			return value;
		}
		public void setValue(Number value) {
			this.value = value;
		}
	}

	private List<DataPair> data;
	private List<String> legend;

	public PieDataBean() {
		super();
		data = new ArrayList<DataPair>();
		legend = new ArrayList<String>();
	}
	
	void addData(String str,Number val){
		data.add(new DataPair(str,val));
		legend.add(str);
	}

}
