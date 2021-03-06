package com.java.window;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JFrame frame;

	private JMenuBar menuBar;
	private JMenu menu_info_manage;
	private JMenu menu_rentback;
	private JMenu menu_info_query;
	private JMenu menu_client_manage;
	private JMenu menu_car_manage;
	private JMenuItem mi_car_add;
	private JMenuItem mi_car_del;
	private JMenuItem mi_car_update;
	private JMenuItem mi_client_add;
	private JMenuItem mi_client_del;
	private JMenuItem mi_client_update;
	private JMenuItem mi_car_rent;
	private JMenuItem mi_car_back;
	private JMenuItem mi_car_info;
	private JMenuItem mi_client_info;
	private JMenuItem mi_orders_info;
	private JPanel panel_userquery;
	private JLabel label;
	private JTextField tf_userquery_input;
	private JLabel lblNewLabel_1;
	private JLabel label_1;
	private JLabel label_2;
	private JPanel panel_welcome;
	private JLabel label_3;
	protected JLabel lbl_relogin2;
	protected JLabel lbl_relogin1;	
	private ManageUser manageCar = null;
	private ManageUser manageUser = null;
	private ManageRent manageRent=null;
	private JLabel label_5;

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/app\u56FE\u6807.png")));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.setTitle("\u79DF\u8F66\u7CFB\u7EDF");
		frame.setBounds(100, 100, 748, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setForeground(Color.WHITE);
		menuBar.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
		frame.setJMenuBar(menuBar);

		menu_info_manage = new JMenu("\u4FE1\u606F\u7BA1\u7406");
		menu_info_manage.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		menuBar.add(menu_info_manage);

		menu_car_manage = new JMenu("\u8F66\u578B\u7BA1\u7406");
		menu_car_manage.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menu_info_manage.add(menu_car_manage);
		// 车型管理
		mi_car_add = new JMenuItem("\u8F66\u578B\u589E\u52A0");
		mi_car_add.setIcon(new ImageIcon("C:\\Users\\Garin\\Desktop\\hehe\u79DF\u8F66\\image\\16x\\add_car.ico"));
		mi_car_add.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		mi_car_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mi_car_addActionPerformed(e);
			}
		});

		menu_car_manage.add(mi_car_add);

		mi_car_del = new JMenuItem("\u8F66\u578B\u5220\u9664");
		mi_car_del.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		mi_car_del.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					mi_car_delActionPerformed(e);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});
		menu_car_manage.add(mi_car_del);

		mi_car_update = new JMenuItem("\u8F66\u578B\u4FEE\u6539");
		mi_car_update.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		mi_car_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mi_car_updateActionPerformed(e);
				
			}
		});
		menu_car_manage.add(mi_car_update);

		menu_client_manage = new JMenu("\u5BA2\u6237\u7BA1\u7406");
		menu_client_manage.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menu_info_manage.add(menu_client_manage);
		// 客户管理
		mi_client_add = new JMenuItem("\u5BA2\u6237\u589E\u52A0");
		mi_client_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manageUser == null) {
					manageUser = new ManageUser();
				}
				manageUser.panel_adduser.setVisible(true);
				manageUser.panel_updateuser.setVisible(false);
				manageUser.panel_deleteuser.setVisible(false);
				manageUser.panel_queryall.setVisible(false);
				manageUser.panel_querybykey.setVisible(false);
				// todo
				manageUser.setVisible(true);
				frame.setVisible(false);
			}
		});
		mi_client_add.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menu_client_manage.add(mi_client_add);

		mi_client_del = new JMenuItem("\u5BA2\u6237\u5220\u9664");
		mi_client_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manageUser == null) {
					manageUser = new ManageUser();
				}
				manageUser.panel_deleteuser.setVisible(true);
				manageUser.panel_adduser.setVisible(false);
				manageUser.panel_queryall.setVisible(false);
				manageUser.panel_querybykey.setVisible(false);
				manageUser.panel_updateuser.setVisible(false);
				manageUser.loadUserInfoInDel();
				manageUser.setVisible(true);
				frame.setVisible(false);
			}
		});
		mi_client_del.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menu_client_manage.add(mi_client_del);

		mi_client_update = new JMenuItem("\u5BA2\u6237\u4FEE\u6539");
		mi_client_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manageUser == null) {
					manageUser = new ManageUser();
				}
				manageUser.panel_updateuser.setVisible(true);
				manageUser.panel_adduser.setVisible(false);
				manageUser.panel_deleteuser.setVisible(false);
				manageUser.panel_queryall.setVisible(false);
				manageUser.panel_querybykey.setVisible(false);
				manageUser.loadUserInfoInUpd();
				manageUser.setVisible(true);
				frame.setVisible(false);
			}
		});
		mi_client_update.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
		menu_client_manage.add(mi_client_update);

		menu_rentback = new JMenu("\u79DF\u8FD8\u7BA1\u7406");
		menu_rentback.setHorizontalAlignment(SwingConstants.CENTER);
		menu_rentback.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		menuBar.add(menu_rentback);

		mi_car_rent = new JMenuItem("\u79DF\u8F66");
		mi_car_rent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (manageRent==null) {
					manageRent=new ManageRent();
				}
				manageRent.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		mi_car_rent.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menu_rentback.add(mi_car_rent);
		

		mi_car_back = new JMenuItem("\u8FD8\u8F66");
		mi_car_back.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		mi_car_back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mi_car_backActionPerformed(e);
			}
		});
		menu_rentback.add(mi_car_back);

		menu_info_query = new JMenu("\u4FE1\u606F\u67E5\u8BE2");
		menu_info_query.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		menuBar.add(menu_info_query);

		mi_car_info = new JMenuItem("\u8F66\u578B\u67E5\u8BE2");
		mi_car_info.setIcon(new ImageIcon("E:\\ChromeDownload\\Add_16.382252559727px_1130653_easyicon.net.png"));
		mi_car_info.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		mi_car_info.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mi_car_infoActionPerformed(e);
				
			}
		});
		menu_info_query.add(mi_car_info);

		/**
		 * 信息查询 -》客户查询
		 */
		mi_client_info = new JMenuItem("\u5BA2\u6237\u67E5\u8BE2");
		mi_client_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_welcome.setVisible(false);
				panel_userquery.setVisible(true);
			}
		});
		mi_client_info.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menu_info_query.add(mi_client_info);

		mi_orders_info = new JMenuItem("\u67E5\u770B\u6240\u6709\u8BA2\u5355");
		mi_orders_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageRent manageRent=new ManageRent();
				manageRent.setVisible(true);
				manageRent.showAllContract();
				frame.setVisible(false);
				
			}
		});
		mi_orders_info.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		menu_info_query.add(mi_orders_info);

		lbl_relogin1 = new JLabel("");
		lbl_relogin1.setIcon(new ImageIcon(Main.class.getResource("/image/app/\u8FD4\u56DE\u767B\u5F551.png")));
		menuBar.add(lbl_relogin1);

		/**
		 * 
		 * 返回登录
		 */
		lbl_relogin2 = new JLabel("");
		lbl_relogin2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new loginFrm().setVisible(true);
				frame.dispose();
			}
		});
		lbl_relogin2.setIcon(new ImageIcon(Main.class.getResource("/image/app/\u8FD4\u56DE\u767B\u5F552.png")));
		menuBar.add(lbl_relogin2);
		frame.getContentPane().setLayout(null);
		/**
		 * 客户查询 -》 重置按钮
		 */

		label_5 = new JLabel("");
		label_5.setBounds(572, 209, 160, 139);
		frame.getContentPane().add(label_5);
		label_5.setIcon(new ImageIcon(Main.class.getResource("/images/gif.gif")));

		panel_userquery = new JPanel();
		panel_userquery.setBackground(Color.WHITE);
		panel_userquery.setBounds(157, 181, 416, 263);
		frame.getContentPane().add(panel_userquery);
		panel_userquery.setLayout(null);

		label = new JLabel("");
		label.setBounds(10, 0, 149, 257);
		label.setIcon(new ImageIcon(Main.class.getResource("/image/app/123.png")));
//		panel_userquery.add(label);
		panel_userquery.setVisible(false);

		tf_userquery_input = new JTextField();
		tf_userquery_input.setBounds(103, 63, 225, 27);
		panel_userquery.add(tf_userquery_input);
		tf_userquery_input.setColumns(16);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Main.class.getResource("/image/app/125.png")));
		lblNewLabel_1.setBounds(10, 20, 229, 33);
		panel_userquery.add(lblNewLabel_1);

		/**
		 * 查询客户->确定
		 */
		label_1 = new JLabel("");
		label_1.setToolTipText("\u786E\u5B9A");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (manageUser == null) {
					manageUser = new ManageUser();
				}
				manageUser.panel_querybykey.setVisible(true);
				manageUser.queryUsersInfo(tf_userquery_input.getText());
				manageUser.setVisible(true);
				frame.setVisible(false);
			}
		});
		label_1.setIcon(new ImageIcon(Main.class.getResource("/image/app/userquery_ok.png")));
		label_1.setBounds(169, 133, 48, 48);
		panel_userquery.add(label_1);
		label_2 = new JLabel("");
		label_2.setToolTipText("\u91CD\u7F6E");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tf_userquery_input.setText("");
			}
		});
		label_2.setIcon(new ImageIcon(Main.class.getResource("/image/app/userquery_reset.png")));
		label_2.setBounds(227, 133, 48, 48);
		panel_userquery.add(label_2);

		/**
		 * 查询客户-》返回标签
		 */
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tf_userquery_input.setText("");
				panel_welcome.setVisible(true);
				panel_userquery.setVisible(false);
			}
		});
		label_4.setIcon(new ImageIcon(Main.class.getResource("/image/app/return.png")));
		label_4.setToolTipText("\u8FD4\u56DE");
		label_4.setBounds(333, 198, 61, 55);
		panel_userquery.add(label_4);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/image/app/\u79DF\u8F66.png")));
		lblNewLabel.setBounds(102, 25, 538, 146);
		frame.getContentPane().add(lblNewLabel);

		panel_welcome = new JPanel();
		panel_welcome.setBackground(SystemColor.textHighlightText);
		panel_welcome.setBounds(10, 161, 722, 283);
		frame.getContentPane().add(panel_welcome);

		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Main.class.getResource("/image/app/welcome.png")));
		panel_welcome.add(label_3);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	protected void mi_car_backActionPerformed(ActionEvent e) {
		
		try {
			(new CarBack()).setVisible(true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		frame.setVisible(false);
		
	}

	protected void mi_car_updateActionPerformed(ActionEvent e) {
		try {
			(new CarUpdate()).setVisible(true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		frame.setVisible(false);
		
	}

	protected void mi_car_delActionPerformed(ActionEvent e) throws Exception {
		(new CarDelete()).setVisible(true);
		frame.setVisible(false);
	}

	protected void mi_car_infoActionPerformed(ActionEvent e) {
		try {
			(new CarQuery()).setVisible(true);
		} catch (Exception e1) {
		
			e1.printStackTrace();
		}
		frame.setVisible(false);
		
	}

	private void mi_car_addActionPerformed(ActionEvent e) {

		(new CarAdd()).setVisible(true);
		frame.setVisible(false);
	}

	public void visterlogin(int flag) {
		switch (flag) {
		// 一般用户登录
		case 0:
			menu_info_manage.setEnabled(false);
			menu_rentback.setEnabled(false);
			mi_orders_info.setEnabled(false);
			break;
		// 管理员登录
		case 1:
			break;

		default:
			break;
		}
	}
}
