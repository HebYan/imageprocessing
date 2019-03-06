/**
 *
 */
package com.zjnu.frame;


import com.zjnu.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author herbertyang
 *
 */
public class MainFrame extends JFrame {

	private static int WIDTH = 888;
	private static int HEIGHT = 666;
	private Flag flag;

	public MainFrame() {

		flag = new Flag();

		Toolkit toolkit = this.getToolkit();
		Dimension screenDimension = new Dimension(toolkit.getScreenSize().width, toolkit.getScreenSize().height);
		setBounds((screenDimension.width - WIDTH) / 2, (screenDimension.height - HEIGHT) / 2, WIDTH, HEIGHT);

		setIconImage(Toolkit.getDefaultToolkit().getImage("img/logo.png"));
		setTitle("图像识别");
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(12, 27, 864, 588);
		try {
			lblNewLabel.setIcon(new ImageIcon("img/th1.jpg"));
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		getContentPane().add(lblNewLabel);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("首选项");
		menu.setIcon(new ImageIcon("img/设置.png"));
		menuBar.add(menu);

		JMenuItem menuItem = new JMenuItem("人脸检测");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.this.setVisible(false);
				new FaceFrame();
			}
		});
		menuItem.setIcon(new ImageIcon("img/人脸识别.png"));
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("灰度图");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RgbToGray.toGray();
			}
		});
		menuItem_1.setIcon(new ImageIcon("img/灰度图.png"));
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("畸形化");
		menuItem_2.setIcon(new ImageIcon("img/畸形.png"));
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deform.useDeform();
			}
		});
		menu.add(menuItem_2);

		JMenu menu_1 = new JMenu("打开文件并识别图像");
		menu_1.setIcon(new ImageIcon("img/打开.png"));
		menuBar.add(menu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("打开文件");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser jfc = new JFileChooser();
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				jfc.showDialog(new JLabel(), "选择");
				File file = jfc.getSelectedFile();
				try {
					lblNewLabel.setIcon(
							new ImageIcon(file.getAbsolutePath()));
					flag.setImgRL(file.getAbsolutePath());
				} catch (Exception ee) {
					// TODO 自动生成的 catch 块
					ee.printStackTrace();
				}

			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon("img/文件.png"));
		menu_1.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("菜品识别");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			/**
			 * 调用百度api
			 */
			@Override
			public void actionPerformed(ActionEvent e) {

				if (flag.getMODEL() == 1) {
					try {
						DealUtuil.dishes(Key.CLIENT, flag.getImgRL());
					} catch (Exception ee) {
						// TODO 自动生成的 catch 块
						ee.printStackTrace();
					}
				} else if (flag.getMODEL() == 0) {
					JOptionPane.showMessageDialog(null, "请设置识别模式", "提示", 1);
				} else {
					JOptionPane.showMessageDialog(null, "识别模式设置不正确", "提示", 1);
				}
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon("img/菜品.png"));
		menu_1.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("汽车识别");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (flag.getMODEL() == 3) {
					try {
						DealUtuil.car(Key.CLIENT, flag.getImgRL());
					} catch (Exception ee) {
						// TODO 自动生成的 catch 块
						ee.printStackTrace();
					}
				} else if (flag.getMODEL() == 0) {
					JOptionPane.showMessageDialog(null, "请设置识别模式", "提示", 1);
				} else {
					JOptionPane.showMessageDialog(null, "识别模式设置不正确", "提示", 1);
				}
			}
		});
		mntmNewMenuItem_2.setIcon(new ImageIcon("img/汽车.png"));
		menu_1.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("动物识别");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (flag.getMODEL() == 2) {
					try {
						DealUtuil.animal(Key.CLIENT, flag.getImgRL());
					} catch (Exception ee) {
						// TODO 自动生成的 catch 块
						ee.printStackTrace();
					}
				} else if (flag.getMODEL() == 0) {
					JOptionPane.showMessageDialog(null, "请设置识别模式", "提示", 1);
				} else {
					JOptionPane.showMessageDialog(null, "识别模式设置不正确", "提示", 1);
				}

			}
		});
		mntmNewMenuItem_3.setIcon(new ImageIcon("img/动物园.png"));
		menu_1.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("植物识别");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (flag.getMODEL() == 4) {
					try {
						DealUtuil.plant(Key.CLIENT, flag.getImgRL());
					} catch (Exception ee) {
						// TODO 自动生成的 catch 块
						ee.printStackTrace();
					}
				} else if (flag.getMODEL() == 0) {
					JOptionPane.showMessageDialog(null, "请设置识别模式", "提示", 1);
				} else {
					JOptionPane.showMessageDialog(null, "识别模式设置不正确", "提示", 1);
				}

			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon("img/植物.png"));
		menu_1.add(mntmNewMenuItem_4);

		JMenuItem mntmNewMenuItem_10 = new JMenuItem("logo识别");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (flag.getMODEL() == 5) {
					try {
						DealUtuil.trade(Key.CLIENT, flag.getImgRL());
					} catch (Exception ee) {
						// TODO 自动生成的 catch 块
						ee.printStackTrace();
					}
				} else if (flag.getMODEL() == 0) {
					JOptionPane.showMessageDialog(null, "请设置识别模式", "提示", 1);
				} else {
					JOptionPane.showMessageDialog(null, "识别模式设置不正确", "提示", 1);
				}
			}
		});
		mntmNewMenuItem_10.setIcon(new ImageIcon("img/商标.png"));
		menu_1.add(mntmNewMenuItem_10);

		JMenu menu_2 = new JMenu("设置识别模式");
		menu_2.setIcon(new ImageIcon("img/模式.png"));
		menuBar.add(menu_2);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("设置为菜品识别模式");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			/**
			 * 设置模式为 1 也就是菜品识别
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				flag.setMODEL(1);
			}
		});
		mntmNewMenuItem_5.setIcon(new ImageIcon("img/菜品.png"));
		menu_2.add(mntmNewMenuItem_5);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("设置为汽车识别模式");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {

			/**
			 * 设置模式为 3 也就是汽车识别
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				flag.setMODEL(3);
			}
		});
		mntmNewMenuItem_6.setIcon(new ImageIcon("img/汽车.png"));
		menu_2.add(mntmNewMenuItem_6);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("设置为植物识别模式");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			/**
			 * 设置模式为 4 也就是植物识别
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				flag.setMODEL(4);
			}
		});
		mntmNewMenuItem_7.setIcon(new ImageIcon("img/植物.png"));
		menu_2.add(mntmNewMenuItem_7);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("设置为动物识别模式");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {

			/**
			 * 设置模式为 2 也就是动物识别
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				flag.setMODEL(2);
			}
		});
		mntmNewMenuItem_8.setIcon(new ImageIcon("img/动物园.png"));
		menu_2.add(mntmNewMenuItem_8);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("设置为logo识别模式");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				flag.setMODEL(5);
			}
		});
		mntmNewMenuItem_9.setIcon(new ImageIcon("img/商标.png"));
		menu_2.add(mntmNewMenuItem_9);

		JMenu mnNewMenu = new JMenu("帮助");
		mnNewMenu.setIcon(new ImageIcon("img/帮助.png"));
		menuBar.add(mnNewMenu);

		setVisible(true);
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -6559402997960531722L;
}
