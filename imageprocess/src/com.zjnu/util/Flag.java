/**
 * 
 */
package com.zjnu.util;

/**
 * @author herbertyang
 *
 */
public class Flag {
	/**
	 *  识别模式的确定 
	 *  规定 1 ： 菜品
	 *     2 ： 动物
	 *     3 ： 汽车
	 *     4 ： 植物
	 *     5 ： 商标
	 * @return  识别模式
	 */
	public int getMODEL() {
		return MODEL;
	}

	public void setMODEL(int mODEL) {
		MODEL = mODEL;
	}

	private int MODEL = 0;
	
	private String imgRL = "C:\\Users\\CTF1\\eclipse-workspace\\cn.examples.baidu.hebyan\\img\\TEST_IMG\\th1.jpg";

	public String getImgRL() {
		return imgRL;
	}

	public void setImgRL(String imgRL) {
		this.imgRL = imgRL;
	}

}
