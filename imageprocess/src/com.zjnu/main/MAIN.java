/**
 *
 */
package com.zjnu.main;


import com.zjnu.frame.LoginFrame;

import javax.swing.*;
import java.awt.*;

/**
 *
 * 毕业设计，调用百度API实现的图像识别 /**
 * 
 * @author herbertyang
 *
 */
public class MAIN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根


		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		try {
			new LoginFrame();
		} catch (HeadlessException | ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

}
