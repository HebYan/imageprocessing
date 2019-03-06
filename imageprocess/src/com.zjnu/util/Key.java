/**
 * 
 */
package com.zjnu.util;

import com.baidu.aip.imageclassify.AipImageClassify;

/**
 * @author herbertyang
 *
 */
public class Key {
     
	public static final String APP_ID = "13966224";
    public static final String API_KEY = "mpG8QF2jYFXplfCSoa8Y1bd0";
    public static final String SECRET_KEY = "olTwAHxxHziMe4dkaHZu6MZFCRR2HfSc";
    public static final AipImageClassify CLIENT = new AipImageClassify(Key.APP_ID, Key.API_KEY,Key.SECRET_KEY);
    
	private Key() {
		super();		
	}
    
    
	 
}
