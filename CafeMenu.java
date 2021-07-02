import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CafeMenu extends JFrame {
	public CafeMenu() {
		JPanel pnlMenu = new JPanel(); // 메뉴용 패널 생성
		pnlMenu.setLayout(new BoxLayout(pnlMenu, BoxLayout.Y_AXIS)); // 세로 정렬
		ButtonGroup groupMenu = new ButtonGroup(); // 라디오 메뉴 3개 묶기 위함
		JRadioButton menu1 = new JRadioButton("아메리카노 : 4100원");
		JRadioButton menu2 = new JRadioButton("콜드브루 : 4500원");
		JRadioButton menu3 = new JRadioButton("에스프레소 : 3400원");
		JLabel lbPrice = new JLabel("총액 : "); // 가격 표시용 레이블

		JPanel pnlSize = new JPanel(); // 사이즈 선택용 패널 생성
		pnlSize.setLayout(new BoxLayout(pnlSize, BoxLayout.Y_AXIS)); // 세로 정렬
		ButtonGroup groupSize = new ButtonGroup(); // 라디오 사이즈 3개 묶기 위함
		JRadioButton size0 = new JRadioButton("Tall : 0원");
		JRadioButton size1 = new JRadioButton("Grande : 600원");
		JRadioButton size2 = new JRadioButton("Venti : 1000원");

		groupMenu.add(menu1); // 라디오 버튼 그룹화
		groupMenu.add(menu2);
		groupMenu.add(menu3);
		
		groupSize.add(size0); // 라디오 버튼 그룹화
		groupSize.add(size1);
		groupSize.add(size2);

		JPanel pnlChknCal = new JPanel(); // 추가 선택 및 계산용 패널 생성
		pnlChknCal.setLayout(new BoxLayout(pnlChknCal, BoxLayout.Y_AXIS)); // 세로 정렬
		JCheckBox chkIce = new JCheckBox("아이스 : 300원"); // 체크박스로 생성
		JCheckBox chkAddShot = new JCheckBox("샷추가 : 600원");
		JButton btnSell = new JButton("계산"); // 계산 버튼
		chkIce.setAlignmentX(JCheckBox.RIGHT_ALIGNMENT); // 우측정렬 시킴
		chkAddShot.setAlignmentX(JCheckBox.RIGHT_ALIGNMENT);
		btnSell.setAlignmentX(JButton.RIGHT_ALIGNMENT);
		
		btnSell.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int price = 0;
				price += (menu1.isSelected()) ? 4100 : 0; // 선택한 가격을 모두 합침
				price += (menu2.isSelected()) ? 4500 : 0;
				price += (menu3.isSelected()) ? 3400 : 0;
				price += (size1.isSelected()) ? 600 : 0;
				price += (size2.isSelected()) ? 1000 : 0;
				price += (chkIce.isSelected()) ? 300 : 0;
				price += (chkAddShot.isSelected()) ? 600 : 0;
				lbPrice.setText("총액 : " + price + "원"); // 결과용 레이블에 가격 표시
			}
		});
		
		// 각각의 패널에 element 추가
		pnlMenu.add(menu1);
		pnlMenu.add(menu2);
		pnlMenu.add(menu3);
		pnlMenu.add(lbPrice);

		pnlSize.add(size0);
		pnlSize.add(size1);
		pnlSize.add(size2);

		pnlChknCal.add(chkIce);
		pnlChknCal.add(chkAddShot);
		pnlChknCal.add(btnSell);

		add(pnlMenu, "West"); // 커피메뉴는 왼쪽
		add(pnlSize, BorderLayout.CENTER); // 사이즈 메뉴는 중앙
		add(pnlChknCal, "East"); // 추가 선택 및 계산은 오른쪽

		showGUI();
	}

	private void showGUI() {
		setTitle("카페 메뉴");
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CafeMenu();
	}

}
