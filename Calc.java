import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calc extends JFrame {
	public Calc() {
		setTitle("계산기");
		
		JPanel pnlInput = new JPanel(); // 보기편하게 하려고 숫자필드용 패널 생성
		JTextField firstNum = new JTextField(5); // 숫자 받을 필드
		JTextField secondNum = new JTextField(5); // 숫자 받을 필드
		
		JPanel pnlBtn =new JPanel(); // 버튼용 패널
		JButton addButton = new JButton("+"); // 사칙연산 버튼 생성
		JButton subButton = new JButton("-");
		JButton mulButton = new JButton("x");
		JButton divButton = new JButton("/");
		
		JPanel pnlResult = new JPanel(); // 결과용 패널
		JLabel result = new JLabel("결과"); // 결과 라벨 생성
		
		addButton.addActionListener(new ActionListener() { // 더하기버튼 누르면 결과라벨에 더하기값 넣기
			@Override
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(firstNum.getText());
				int b = Integer.parseInt(secondNum.getText());
				int res = a + b;
				result.setText(String.valueOf(res));
			}
		});
		subButton.addActionListener(new ActionListener() { // 빼기버튼 누르면 결과라벨에 빼기값 넣기
			@Override
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(firstNum.getText());
				int b = Integer.parseInt(secondNum.getText());
				int res = a - b;
				result.setText(String.valueOf(res));
			}
		});
		mulButton.addActionListener(new ActionListener() { // 곱하기버튼 누르면 결과라벨에 곱하기값 넣기
			@Override
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(firstNum.getText());
				int b = Integer.parseInt(secondNum.getText());
				int res = a * b;
				result.setText(String.valueOf(res));
			}
		});
		divButton.addActionListener(new ActionListener() { // 나누기버튼 누르면 결과라벨에 나누기값 넣기
			@Override
			public void actionPerformed(ActionEvent e) {
				int a = Integer.parseInt(firstNum.getText());
				int b = Integer.parseInt(secondNum.getText());
				try {
				double res = (double)a / b;
				result.setText(String.valueOf(res));
				} catch(ArithmeticException e1) { // 0으로 나눌때 생기는 exception 예외처리 해줌
					JOptionPane.showMessageDialog(null, "0으로 나눌수 없습니다", "나누기 에러", 0);
				}
			}
		});
		
		pnlInput.add(firstNum); // 숫자용 패널에 숫자 필드 추가
		pnlInput.add(secondNum);
		
		pnlBtn.add(addButton); // 버튼용 패널에 사칙연산 버튼 추가
		pnlBtn.add(subButton);
		pnlBtn.add(mulButton);
		pnlBtn.add(divButton);
		
		pnlResult.add(result); // 결과용 패널에 결과 라벨 추가
		
		add(pnlInput, "North"); // 숫자용 패널은 상단배치
		add(pnlBtn, BorderLayout.CENTER); // 버튼용 패널은 중간 배치
		add(pnlResult, "South"); // 결과용 패널은 하단배치

		pack(); // element 사이즈에 맞게 알아서 창 크기 조절
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Calc();
	}
}
