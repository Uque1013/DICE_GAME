package Java_Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Timer;

import Java_Project.Server;

public class Program extends JFrame {
	JFrame Buy_F = new JFrame("구매");
	JFrame Rule_F = new JFrame("규칙");
	JFrame Airplane = new JFrame("어디로 모실까요 손님~~~??");

	int P1_cnt = 0; // 플레이어 땅 구매 개수 세기위함
	int AI_cnt = 0; // AI 땅 구매 개수 세기위함

	static JButton bt1 = new JButton(); // 주사위 굴리기 버튼
	static JButton bt2 = new JButton(); // 종료 버튼
	static JButton bt3 = new JButton(); // 시작 버튼
	static JButton bt4 = new JButton(); // 구매 버튼
	static JButton bt5 = new JButton(); // 구매 취소 버튼
	static JButton bt6 = new JButton(); // 구매프래임에서 구매 버튼 
	static JButton bt7 = new JButton(); // 규칙 확인 버튼
	static JButton bt9 = new JButton(); // 다시하기 버튼


	static JPanel page1 = new JPanel() { // 게임 시작 전 화면
		private Image background=new ImageIcon(Server.class.getResource("../image/background.png")).getImage();
		public void paint(Graphics g) { //그리는 함수
			g.drawImage(background, 0, 0, null); //photo를 그려줌		
		}
	};

	static JPanel page2 = new JPanel() { // 게임 시작 후 화면
		private Image background=new ImageIcon(Server.class.getResource("../image/background.png")).getImage();
		public void paint(Graphics g) { //그리는 함수
			g.drawImage(background, 0, 0, null); //photo를 그려줌		
		}
	};

	static JPanel page3 = new JPanel() { // 땅 구매 화면
		private Image b_background=new ImageIcon(Server.class.getResource("../image/buy_background.png")).getImage();
		public void paint(Graphics g) { //그리는 함수
			g.drawImage(b_background, 0, 0, null); //photo를 그려줌		
		}
	};
	
	static JPanel page4 = new JPanel() { // 규칙 설명 화면
		private Image Rule_background=new ImageIcon(Server.class.getResource("../image/Rule.png")).getImage();
		public void paint(Graphics g) { //그리는 함수
			g.drawImage(Rule_background, 0, 0, null); //photo를 그려줌		
		}
	};
	
	static JPanel page6 = new JPanel() { // 플레이어가 이긴 화면
		private Image Win_P1_background=new ImageIcon(Server.class.getResource("../image/Win_Player_background.png")).getImage();
		public void paint(Graphics g) { //그리는 함수
			g.drawImage(Win_P1_background, 0, 0, null); //photo를 그려줌		
		}
	};

	static JPanel page7 = new JPanel() { // AI가 이긴 화면
		private Image Win_AI_background=new ImageIcon(Server.class.getResource("../image/Win_AI_background.png")).getImage();
		public void paint(Graphics g) { //그리는 함수
			g.drawImage(Win_AI_background, 0, 0, null); //photo를 그려줌		
		}
	};
	
	static JPanel page8 = new JPanel() {};  // 비행기 화면
	


	/*라벨 이미지 설정*/
	private ImageIcon dice_1 = new ImageIcon(Server.class.getResource("../Lable_image/Dice_1.png"));
	private ImageIcon dice_2 = new ImageIcon(Server.class.getResource("../Lable_image/Dice_2.png"));
	private ImageIcon dice_3 = new ImageIcon(Server.class.getResource("../Lable_image/Dice_3.png"));
	private ImageIcon dice_4 = new ImageIcon(Server.class.getResource("../Lable_image/Dice_4.png"));
	private ImageIcon dice_5 = new ImageIcon(Server.class.getResource("../Lable_image/Dice_5.png"));
	private ImageIcon dice_6 = new ImageIcon(Server.class.getResource("../Lable_image/Dice_6.png"));
	private ImageIcon P1 = new ImageIcon(Server.class.getResource("../Lable_image/Player.png"));
	private ImageIcon AI = new ImageIcon(Server.class.getResource("../Lable_image/AI.png"));
	private ImageIcon P1_L = new ImageIcon(Server.class.getResource("../Lable_image/P1_Land.png")); 
	private ImageIcon AI_L = new ImageIcon(Server.class.getResource("../Lable_image/AI_Land.png"));

	/*라벨 이미지 선언*/
	JLabel D1 = new JLabel(dice_1); // 주사위 라벨, 라벨을 이용해서 이미지 출력
	JLabel D2 = new JLabel(dice_2);
	JLabel D3 = new JLabel(dice_3);
	JLabel D4 = new JLabel(dice_4);
	JLabel D5 = new JLabel(dice_5);
	JLabel D6 = new JLabel(dice_6);
	JLabel P1_img = new JLabel(P1); // 플레이어 아이콘 라벨
	JLabel AI_img = new JLabel(AI); // 컴퓨터 아이콘 라벨
	
	JLabel P1_Land = new JLabel(P1_L); // 플레이어 땅 라벨
	JLabel P1_Land2 = new JLabel(P1_L); // 배열로 바꿀 수 있으면 바꿀 예정 (땅 8개 구매 시 이겨서 8개까지만 생성)
	JLabel P1_Land3 = new JLabel(P1_L); // 플레이어 땅 라벨
	JLabel P1_Land4 = new JLabel(P1_L); // 플레이어 땅 라벨
	JLabel P1_Land5 = new JLabel(P1_L); // 플레이어 땅 라벨
	JLabel P1_Land6 = new JLabel(P1_L); // 플레이어 땅 라벨
	JLabel P1_Land7 = new JLabel(P1_L); // 플레이어 땅 라벨
	JLabel P1_Land8 = new JLabel(P1_L); // 플레이어 땅 라벨
	
	JLabel AI_Land = new JLabel(AI_L); // 컴퓨터 땅 라벨
	JLabel AI_Land2 = new JLabel(AI_L); // 컴퓨터 땅 라벨
	JLabel AI_Land3 = new JLabel(AI_L); // 컴퓨터 땅 라벨
	JLabel AI_Land4 = new JLabel(AI_L); // 컴퓨터 땅 라벨
	JLabel AI_Land5 = new JLabel(AI_L); // 컴퓨터 땅 라벨
	JLabel AI_Land6 = new JLabel(AI_L); // 컴퓨터 땅 라벨
	JLabel AI_Land7 = new JLabel(AI_L); // 컴퓨터 땅 라벨
	JLabel AI_Land8 = new JLabel(AI_L); // 컴퓨터 땅 라벨

	/*버튼 이미지 설정*/
	private ImageIcon img = new ImageIcon(Server.class.getResource("../Button_image/Button.png"));
	private ImageIcon img2 = new ImageIcon(Server.class.getResource("../Button_image/Button2.png"));
	private ImageIcon end = new ImageIcon(Server.class.getResource("../Button_image/End.png"));
	private ImageIcon end2 = new ImageIcon(Server.class.getResource("../Button_image/End2.png"));
	private ImageIcon start = new ImageIcon(Server.class.getResource("../Button_image/Start.png"));
	private ImageIcon start2 = new ImageIcon(Server.class.getResource("../Button_image/Start2.png"));
	private ImageIcon buy = new ImageIcon(Server.class.getResource("../Button_image/Buy.png"));
	private ImageIcon buy2 = new ImageIcon(Server.class.getResource("../Button_image/Buy2.png"));
	private ImageIcon X = new ImageIcon(Server.class.getResource("../Button_image/X.png"));
	private ImageIcon X1 = new ImageIcon(Server.class.getResource("../Button_image/X1.png"));
	private ImageIcon OK1 = new ImageIcon(Server.class.getResource("../Button_image/Ok1.png"));
	private ImageIcon OK2 = new ImageIcon(Server.class.getResource("../Button_image/Ok2.png"));
	private ImageIcon Restart1 = new ImageIcon(Server.class.getResource("../Button_image/Restart1.png"));
	private ImageIcon Restart2 = new ImageIcon(Server.class.getResource("../Button_image/Restart2.png"));

	/*생성자*/
	public Program() {
		homeframe(); // 프레임 함수
		RadioCB(); // 라디오 버튼 함수
		lab(); // 라벨 설정 함수
		bt(); // 버튼 함수
		setpanel(); // 패널 설정 함수
		start(); // 시작 버튼 마우스 이벤트
		OK_button(); // 규칙 확인 버튼 마우스 이벤트
		end(); // 종료 버튼 마우스 이벤트
		Dice_button(); // 주사위 굴리는 버튼 마우스 이벤트
		Turn(); // 턴넘기기 버튼 마우스 이벤트
		Buy_button(); // 구매 버튼 마우스 이벤트
		X_button(); // 구매 취소 버튼 마우스 이벤트
		Airplane(); // 비행기 이벤트
		B_button(); // 구매 버튼의 구매 마우스 이벤트 
		Restart_button(); // 다시하기 버튼의 마우스 이벤트
	}

	public void homeframe() {
		setTitle("Dice_Game");//타이틀 
		setSize(1300,760);//프레임의 크기
		setResizable(false);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게
		setLayout(null);//레이아웃을 내맘대로 설정가능하게 해줌.
		setVisible(true);//창이 보이게	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame이 정상적으로 종료되게
	}

	public void RadioCB() {
	
	Point point=P1_img.getLocation();
		
		ButtonGroup Group = new ButtonGroup();
		JRadioButton M = new JRadioButton("멕시코");
		JRadioButton d = new JRadioButton("독도");
		JRadioButton S = new JRadioButton("싱가포르");
		JRadioButton T = new JRadioButton("타이베이");
		JRadioButton D = new JRadioButton("도쿄");
		JRadioButton B = new JRadioButton("베이징");
		JRadioButton H = new JRadioButton("하노이");
		
		ButtonGroup Group2 = new ButtonGroup();
		JRadioButton Mol = new JRadioButton("몰디브");
		JRadioButton G = new JRadioButton("그리스");
		JRadioButton W = new JRadioButton("웨링턴");
		JRadioButton Bel = new JRadioButton("벨기에");
		JRadioButton O = new JRadioButton("오슬로");
		JRadioButton Bal = new JRadioButton("발리");
		JRadioButton K = new JRadioButton("카이로");
		
		ButtonGroup Group3 = new ButtonGroup();
		JRadioButton Ang = new JRadioButton("앙카라");
		JRadioButton Be = new JRadioButton("베른");
		JRadioButton St = new JRadioButton("스톡홀름");
		JRadioButton Hw = new JRadioButton("하와이");
		JRadioButton Mo = new JRadioButton("모스크바");
		JRadioButton R = new JRadioButton("로마");
		JRadioButton Run = new JRadioButton("런던");
		
		ButtonGroup Group4 = new ButtonGroup();
		JRadioButton P = new JRadioButton("파리");
		JRadioButton Ber = new JRadioButton("베를린");
		JRadioButton Ho = new JRadioButton("호주");
		JRadioButton Ben = new JRadioButton("벤쿠버");
		JRadioButton Seoul= new JRadioButton("서울");
		JRadioButton NewYork = new JRadioButton("뉴욕");
		
		Group.add(M);
		Group.add(d);
		Group.add(S);
		Group.add(T);
		Group.add(D);
		Group.add(B);
		Group.add(H);

		Group2.add(Mol);
		Group2.add(G);
		Group2.add(W);
		Group2.add(Bel);
		Group2.add(O);
		Group2.add(Bal);
		Group2.add(K);
		
		Group3.add(Ang);
		Group3.add(Be);
		Group3.add(St);
		Group3.add(Hw);
		Group3.add(Mo);
		Group3.add(R);
		Group3.add(Run);
		
		Group4.add(P);
		Group4.add(Ber);
		Group4.add(Ho);
		Group4.add(Ben);
		Group4.add(Seoul);
		Group4.add(NewYork);
		
		page8.add(M);
		page8.add(d);
		page8.add(S);
		page8.add(T);
		page8.add(D);
		page8.add(B);
		page8.add(H);
		
		page8.add(Mol);
		page8.add(G);
		page8.add(W);
		page8.add(Bel);
		page8.add(O);
		page8.add(Bal);
		page8.add(K);
		
		page8.add(Ang);
		page8.add(Be);
		page8.add(St);
		page8.add(Hw);
		page8.add(Mo);
		page8.add(R);
		page8.add(Run);
		
		page8.add(P);
		page8.add(Ber);
		page8.add(Ho);
		page8.add(Ben);
		page8.add(Seoul);
		page8.add(NewYork);
		
		Airplane.setSize(520, 430);
		Airplane.setLocation(650, 250);
		Airplane.add(page8);
		Airplane.setVisible(false); // 비행기 선택창이 뜸
		
		M.addMouseListener(new MouseAdapter() { // 멕시코 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(1065, 670); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});
		
		d.addMouseListener(new MouseAdapter() { // 독도 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(950, 670); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});
		
		S.addMouseListener(new MouseAdapter() { // 타이베이 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(835, 670); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});
		
		T.addMouseListener(new MouseAdapter() { // 타이베이 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(720, 670); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});
		
		D.addMouseListener(new MouseAdapter() { // 도쿄 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(605, 670); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});
		
		B.addMouseListener(new MouseAdapter() { // 베이징 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(490, 670); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});
		
		H.addMouseListener(new MouseAdapter() { // 하노이 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(375, 670); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});
		
		
		Mol.addMouseListener(new MouseAdapter() { // 몰디브 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(260, 670); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});

		G.addMouseListener(new MouseAdapter() { // 그리스 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(145, 670); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});

		W.addMouseListener(new MouseAdapter() { // 웨링턴 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(30, 550); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});

		Bel.addMouseListener(new MouseAdapter() { // 벨기에 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(30, 430); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});

		O.addMouseListener(new MouseAdapter() { // 오슬로 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(30, 310); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});

		Bal.addMouseListener(new MouseAdapter() { // 발리 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(30, 190); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});

		K.addMouseListener(new MouseAdapter() { // 카이로 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(30, 70); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});

		
		Ang.addMouseListener(new MouseAdapter() { // 앙카라 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(145, 70); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});

		Be.addMouseListener(new MouseAdapter() { // 베른 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(260, 70); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});

		St.addMouseListener(new MouseAdapter() { // 스톡홀름 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(375, 70); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});

		Hw.addMouseListener(new MouseAdapter() { // 하와이 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(490, 70); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});

		Mo.addMouseListener(new MouseAdapter() { // 모스크바 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(605, 70); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});

		R.addMouseListener(new MouseAdapter() { // 로마 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(720, 70); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});

		Run.addMouseListener(new MouseAdapter() { // 런던 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(835, 70); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});
		
		
		P.addMouseListener(new MouseAdapter() { // 파리 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(950, 70); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});

		Ber.addMouseListener(new MouseAdapter() { // 베를린 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(1065, 70); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});

		Ho.addMouseListener(new MouseAdapter() { // 호주 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(1180, 190); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});

		Ben.addMouseListener(new MouseAdapter() { // 벤쿠버 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(1180, 310); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});

		Seoul.addMouseListener(new MouseAdapter() { // 서울 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(1180, 430); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});

		NewYork.addMouseListener(new MouseAdapter() { // 뉴욕 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				P1_img.setLocation(1180, 550); // 출발점
				Airplane.dispose(); // 나라 선택 후 비행기 프레임 꺼짐
			}
		});


	}

	public void lab() {
		D1.setBounds(450, 100, 300, 300);
		D1.setVisible(false);
		D2.setBounds(450, 100, 300, 300);
		D2.setVisible(false);
		D3.setBounds(450, 100, 300, 300);
		D3.setVisible(false);
		D4.setBounds(450, 100, 300, 300);
		D4.setVisible(false);
		D5.setBounds(450, 100, 300, 300);
		D5.setVisible(false);
		D6.setBounds(450, 100, 300, 300);
		D6.setVisible(false);
		P1_img.setBounds(1180, 670, 50,50); // 플레이어 기본 위치
		P1_img.setVisible(false);
		AI_img.setBounds(1210, 670, 50,50); // 컴퓨터 기본 위치
		AI_img.setVisible(false);
		
		P1_Land.setBounds(0, 0, 115, 102); // 플레이어 땅 기본 위치
		P1_Land.setVisible(false);
		P1_Land2.setBounds(0, 0, 115, 102); // 플레이어 땅 기본 위치
		P1_Land2.setVisible(false);
		P1_Land3.setBounds(0, 0, 115, 102); // 플레이어 땅 기본 위치
		P1_Land3.setVisible(false);
		P1_Land4.setBounds(0, 0, 115, 102); // 플레이어 땅 기본 위치
		P1_Land4.setVisible(false);
		P1_Land5.setBounds(0, 0, 115, 102); // 플레이어 땅 기본 위치
		P1_Land5.setVisible(false);
		P1_Land6.setBounds(0, 0, 115, 102); // 플레이어 땅 기본 위치
		P1_Land6.setVisible(false);
		P1_Land7.setBounds(0, 0, 115, 102); // 플레이어 땅 기본 위치
		P1_Land7.setVisible(false);
		P1_Land8.setBounds(0, 0, 115, 102); // 플레이어 땅 기본 위치
		P1_Land8.setVisible(false);
		
		AI_Land.setBounds(0, 0, 115, 102); // 컴퓨터 땅 기본 위치
		AI_Land.setVisible(false);
		AI_Land2.setBounds(0, 0, 115, 102); // 컴퓨터 땅 기본 위치
		AI_Land2.setVisible(false);
		AI_Land3.setBounds(0, 0, 115, 102); // 컴퓨터 땅 기본 위치
		AI_Land3.setVisible(false);
		AI_Land4.setBounds(0, 0, 115, 102); // 컴퓨터 땅 기본 위치
		AI_Land4.setVisible(false);
		AI_Land5.setBounds(0, 0, 115, 102); // 컴퓨터 땅 기본 위치
		AI_Land5.setVisible(false);
		AI_Land6.setBounds(0, 0, 115, 102); // 컴퓨터 땅 기본 위치
		AI_Land6.setVisible(false);
		AI_Land7.setBounds(0, 0, 115, 102); // 컴퓨터 땅 기본 위치
		AI_Land7.setVisible(false);
		AI_Land8.setBounds(0, 0, 115, 102); // 컴퓨터 땅 기본 위치
		AI_Land8.setVisible(false);
		
		
		getContentPane().add(D1);
		getContentPane().add(D2);
		getContentPane().add(D3);
		getContentPane().add(D4);
		getContentPane().add(D5);
		getContentPane().add(D6);
		getContentPane().add(P1_img);
		getContentPane().add(AI_img);
		
		getContentPane().add(P1_Land);
		getContentPane().add(P1_Land2);
		getContentPane().add(P1_Land3);
		getContentPane().add(P1_Land4);
		getContentPane().add(P1_Land5);
		getContentPane().add(P1_Land6);
		getContentPane().add(P1_Land7);
		getContentPane().add(P1_Land8);
		
		getContentPane().add(AI_Land);
		getContentPane().add(AI_Land2);
		getContentPane().add(AI_Land3);
		getContentPane().add(AI_Land4);
		getContentPane().add(AI_Land5);
		getContentPane().add(AI_Land6);
		getContentPane().add(AI_Land7);
		getContentPane().add(AI_Land8);
		
	}

	public void bt() {
		bt1.setLayout(null);
		bt1.setRolloverIcon(img2); // 마우스 올리면 버튼색이 변함
		bt1.setBounds(430, 440, 120, 70);// 주사위 굴리는 버튼의 위치 설정
		bt1.setBorderPainted(false); // 버튼 테투리 해제
		bt1.setIcon(img); // 기본 버튼 이미지

		bt2.setLayout(null); // 종료 버튼
		bt2.setRolloverIcon(end2);
		bt2.setBounds(500, 450, 250, 150);
		bt2.setBorderPainted(false); // 버튼 테투리 해제
		bt2.setIcon(end); // 기본 버튼 이미지

		bt3.setLayout(null); // 시작 버튼
		bt3.setRolloverIcon(start2);
		bt3.setBounds(500, 200, 250, 150);
		bt3.setBorderPainted(false); // 버튼 테투리 해제
		bt3.setIcon(start); // 기본 버튼 이미지

		bt4.setLayout(null);
		bt4.setRolloverIcon(buy2);
		bt4.setBounds(670, 440, 120, 70);
		bt4.setBorderPainted(false);
		bt4.setIcon(buy);
		
		bt5.setLayout(null);
		bt5.setRolloverIcon(X);
		bt5.setBounds(280, 330, 120, 70);
		bt5.setBorderPainted(false);
		bt5.setIcon(X1);

		bt6.setLayout(null);
		bt6.setRolloverIcon(buy2);
		bt6.setBounds(70, 330, 120, 70);
		bt6.setBorderPainted(false);
		bt6.setIcon(buy);
		
		bt7.setLayout(null);
		bt7.setRolloverIcon(OK2);
		bt7.setBounds(275, 418, 120, 70);
		bt7.setBorderPainted(false);
		bt7.setIcon(OK1);
		
		bt9.setLayout(null);
		bt9.setRolloverIcon(Restart2);
		bt9.setBounds(670, 440, 120, 70);
		bt9.setBorderPainted(false);
		bt9.setIcon(Restart1);

		add(bt1);
		add(bt2);
		add(bt3);
		add(bt4);
		}

	public void setpanel() {
		/*위치 설정*/
		page1.setBounds(0, 0, 1920, 1080);//패널1의 위치 설정
		page2.setBounds(0, 0, 1920, 1080);//패널2의 위치 설정
		page3.setBounds(0, 0, 500, 500);
		page4.setBounds(0, 0, 515, 500);
		page6.setBounds(0, 0, 1920, 1080);
		page7.setBounds(0, 0, 1920, 1080);

		/*레이아웃 지정*/
		page1.setLayout(null);//레이아웃 설정
		page2.setLayout(null);//레이아웃 설정
		page3.setLayout(null);//레이아웃 설정
		page4.setLayout(null);//레이아웃 설정
		page6.setLayout(null);//레이아웃 설정
		page7.setLayout(null);//레이아웃 설정

		/*visible*/
		page2.setVisible(false);//창이 보이지 않게
		page3.setVisible(false);//창이 보이지 않게
		page4.setVisible(false);//창이 보이지 않게
		page6.setVisible(false);//창이 보이지 않게
		page7.setVisible(false);//창이 보이지 않게

		/*패널이나 프레임에 추가*/
		add(page1);//프레임에 패널을 추가
		add(page2);//프레임에 패널을 추가
		page2.add(bt1);//패널2에 주사위 굴리기 버튼 추가	
		page2.add(bt4);//패널2에 구매 버튼 추가
		
	}

	public void Turn() { // AI 자동 마우스 이벤트	
		bt1.addMouseListener(new MouseAdapter() { // 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 마우스 클릭했을때
				Random ran = new Random(); // 주사위가 6개 중 랜덤으로 나오도록 랜덤 함수 사용
				Timer timer1 = new Timer();
				int Dice2 =  ran.nextInt(6)+1;
				Point p =AI_img.getLocation();
				
				TimerTask task1 = new TimerTask() {
					@Override
					public void run() {
						if(Dice2==1) {
							D1.setVisible(true);
							D2.setVisible(false); // 이미지 초기화
							D3.setVisible(false); // 이미지 초기화
							D4.setVisible(false); // 이미지 초기화
							D5.setVisible(false); // 이미지 초기화
							D6.setVisible(false); // 이미지 초기화
							//AI_Land.setVisible(true); // AI 땅 이미지 소환
							AI_img.setLocation((p.x-115),(p.y)); // 출발점
							
							
							if(p.x==60 ) AI_img.setLocation((p.x),(p.y-120)); // 무인도에 도착했을 때

							if(p.y==70) {
								AI_img.setLocation((p.x+115),(p.y)); // 카이로에 도착했을 때
								if(p.x==1210) {
									AI_img.setLocation((p.x),(p.y+120)); // 비행기에 도착했을 때
								}
							}

							if(p.x==1210) {						
								if(p.y==190) AI_img.setLocation((p.x),(p.y+120)); // 호주에 도착했을 때

								else if(p.y==310) AI_img.setLocation((p.x),(p.y+120)); // 벤쿠버에 도착했을 때

								else if(p.y==430)AI_img.setLocation((p.x),(p.y+120)); // 서울에 도착했을 때

								else if(p.y==550) AI_img.setLocation((p.x),(p.y+120)); // 뉴욕에 도착했을 때
							}

						}


						if(Dice2==2) {
							D1.setVisible(false); // 이미지 초기화
							D2.setVisible(true); // 이미지 초기화
							D3.setVisible(false); // 이미지 초기화
							D4.setVisible(false); // 이미지 초기화
							D5.setVisible(false); // 이미지 초기화
							D6.setVisible(false); // 이미지 초기화
							AI_img.setLocation((p.x-230),(p.y)); // 출발점
							if(p.x==60) AI_img.setLocation((p.x),(p.y-240)); // 무인도에 도착했을 때 (오류나서 따로 빼줌)

							if(p.y==70) {
								AI_img.setLocation((p.x+230),(p.y)); // 카이로에 도착했을 때
								if(p.x==1210) AI_img.setLocation((p.x),(p.y+240)); // 비행기에 도착했을 때

								else if(p.x==1095) AI_img.setLocation((p.x+115),(p.y+120)); // 베를린 위치일 때 호주로 옮겨주기 위해
							}

							if(p.x==1210) {
								if(p.y==190) AI_img.setLocation((p.x),(p.y+240)); // 호주에 도착했을 때

								else if(p.y==310) AI_img.setLocation((p.x),(p.y+240)); // 벤쿠버에 도착했을 때

								else if(p.y==430) AI_img.setLocation((p.x),(p.y+240)); // 서울에 도착했을 때

								else if(p.y==550) AI_img.setLocation((p.x-115),(p.y+120)); // 뉴욕 위치일 때 멕시코로 옮겨주기 위해
							}

							if(p.x==60) {
								if(p.y==190)  AI_img.setLocation((p.x+115),(p.y-120)); // 발리 위치일 때 앙카라로 옮겨주기 위해
							}

							if(p.x==175&&p.y==670) AI_img.setLocation((p.x-115),(p.y-120)); // 그리스 위치일 때 웨링턴으로 옮겨주기 위해

						}


						if(Dice2==3) {
							D1.setVisible(false); // 이미지 초기화
							D2.setVisible(false); // 이미지 초기화
							D3.setVisible(true); // 이미지 초기화
							D4.setVisible(false); // 이미지 초기화
							D5.setVisible(false); // 이미지 초기화
							D6.setVisible(false); // 이미지 초기화
							AI_img.setLocation((p.x-345),(p.y));
							if(p.x==60) AI_img.setLocation((p.x),(p.y-360)); // 무인도에 도착했을 때

							if(p.y==70) {
								AI_img.setLocation((p.x+345),(p.y)); // 카이로에 도착했을 때
								if(p.x==980) AI_img.setLocation((p.x+230),(p.y+120)); // 파리 위치일 때 호주로 옮겨주기 위해

								else if(p.x==1095) AI_img.setLocation((p.x+115),(p.y+240)); // 베를린 위치일 때 벤쿠버로 옮겨주기 위해

								else if(p.x==1210) AI_img.setLocation((p.x),(p.y+360)); // 비행기에 도착했을 때
							}

							if(p.x==1210) {
								if(p.y==190) AI_img.setLocation((p.x),(p.y+360)); // 호주에 도착했을 때

								else if(p.y==310) AI_img.setLocation((p.x),(p.y+360)); // 벤쿠버에 도착했을 때

								else if(p.y==430) AI_img.setLocation((p.x-115),(p.y+240)); // 서울 위치일 때 멕시코로 옮겨주기 위해

								else if(p.y==550) AI_img.setLocation((p.x-230),(p.y+120)); // 뉴욕 위치일 때 독도로 옮겨주기 위해
							}

							if(p.y==670) {
								if(p.x==290)AI_img.setLocation((p.x-230),(p.y-120)); // 몰디브 위치일 때 웨링턴으로 옮겨주기 위해

								else if(p.x==175) AI_img.setLocation((p.x-115),(p.y-240)); // 그리스 위치일 때 벨기에로 옮겨주기 위해
							}

							if(p.x==60) {
								if(p.y==190)  AI_img.setLocation((p.x+230),(p.y-120)); // 발리 위치일 때 베른으로 옮겨주기 위해

								else if(p.y==310)  AI_img.setLocation((p.x+115),(p.y-240)); // 오슬로 위치일 때 앙카라로 옮겨주기 위해
							}

						}


						if(Dice2==4) {
							D1.setVisible(false); // 이미지 초기화
							D2.setVisible(false); // 이미지 초기화
							D3.setVisible(false); // 이미지 초기화
							D4.setVisible(true); 
							D5.setVisible(false); // 이미지 초기화
							D6.setVisible(false); // 이미지 초기화
							AI_img.setLocation((p.x-460),(p.y));
							if(p.x==60) AI_img.setLocation((p.x),(p.y-480)); // 무인도에 도착했을 때 (오류나서 따로 빼줌)

							if(p.y==70) {
								AI_img.setLocation((p.x+460),(p.y)); // 카이로에 도착했을 때
								if(p.x==1210) AI_img.setLocation((p.x),(p.y+480)); // 비행기에 도착했을 때

								else if(p.x==865) AI_img.setLocation((p.x+345),(p.y+120)); // 런던 위치일 때 호주로 옮겨주기 위해

								else if(p.x==980) AI_img.setLocation((p.x+230),(p.y+240)); // 파리 위치일 때 벤쿠버로 옮겨주기 위해

								else if(p.x==1095) AI_img.setLocation((p.x+115),(p.y+360)); // 베를린 위치일 때 서울로 옮겨주기 위해
							}

							if(p.x==1210) {
								if(p.y==190) AI_img.setLocation((p.x),(p.y+480)); // 호주에 도착했을 때

								else if(p.y==310) AI_img.setLocation((p.x-115),(p.y+360)); // 벤쿠버 위치일 때 멕시코로 옮겨주기 위해

								else if(p.y==430) AI_img.setLocation((p.x-230),(p.y+240)); // 서울 위치일 때 독도로 옮겨주기 위해

								else if(p.y==550) AI_img.setLocation((p.x-345),(p.y+120)); // 뉴욕 위치일 때 싱가폴로 옮겨주기 위해
							}

							if(p.x==60) {
								if(p.y==430) AI_img.setLocation((p.x+115),(p.y-360)); // 벨기에 위치일 때 앙카라로 옮겨주기 위해

								else if(p.y==310) AI_img.setLocation((p.x+230),(p.y-240)); // 오슬로 위치일 때 베른으로 옮겨주기 위해

								else if(p.y==190) AI_img.setLocation((p.x+345),(p.y-120)); // 발리 위치일 때 스톡홀름으로 옮겨주기 위해
							}

							if(p.y==670) {
								if(p.x==405) AI_img.setLocation((p.x-345),(p.y-120)); //하노이 위치일 때 웨링턴으로 옮겨주기 위해

								else if(p.x==290) AI_img.setLocation((p.x-230),(p.y-240)); //몰리브 위치일 때 벨기에로 옮겨주기 위해

								else if(p.x==175) AI_img.setLocation((p.x-115),(p.y-360)); //그리스 위치일 때 오슬로로 옮겨주기 위해			
							}

						}


						if(Dice2==5) {
							D1.setVisible(false); // 이미지 초기화
							D2.setVisible(false); // 이미지 초기화
							D3.setVisible(false); // 이미지 초기화
							D4.setVisible(false); // 이미지 초기화
							D5.setVisible(true);
							D6.setVisible(false); // 이미지 초기화
							AI_img.setLocation((p.x-575),(p.y));
							if(p.x==60) AI_img.setLocation((p.x),(p.y-600)); // 무인도에 도착했을 때 (오류나서 따로 빼줌)

							if(p.y==670) {
								if(p.x==520) AI_img.setLocation((p.x-460),(p.y-120)); // 베이징 위치일 때 웨링턴으로 옮겨주기 위해 

								else if(p.x==405) AI_img.setLocation((p.x-345),(p.y-240)); // 하노이 위치일 때 벨기에으로 옮겨주기 위해 

								else if(p.x==290) AI_img.setLocation((p.x-230),(p.y-360)); // 몰디브 위치일 때 오슬로로 옮겨주기 위해 

								else if(p.x==175) AI_img.setLocation((p.x-115),(p.y-480)); // 그리스 위치일 때 발리로 옮겨주기 위해 
							}

							if(p.x==60) {
								if(p.y==550) AI_img.setLocation((p.x+115),(p.y-480)); // 웨링턴 위치일 때 앙카라로 옮겨주기 위해 

								else if(p.y==430) AI_img.setLocation((p.x+230),(p.y-360)); // 벨기에 위치일 때 베른으로 옮겨주기 위해 

								else if(p.y==310) AI_img.setLocation((p.x+345),(p.y-240)); // 오슬로 위치일 때 스톡홀름으로 옮겨주기 위해 

								else if(p.y==190) AI_img.setLocation((p.x+460),(p.y-120)); // 발리 위치일 때 하와이로 옮겨주기 위해 
							}

							if(p.y==70) {
								AI_img.setLocation((p.x+575),(p.y)); // 카이로에 도착했을 때
								if(p.x==1210) AI_img.setLocation((p.x),(p.y+600)); // 비행기에 도착했을 때

								else if(p.x==750) AI_img.setLocation((p.x+460),(p.y+120)); // 로마 위치일 때 호주로 옮겨주기 위해 

								else if(p.x==865) AI_img.setLocation((p.x+345),(p.y+240)); // 런던 위치일 때 벤쿠버로 옮겨주기 위해

								else if(p.x==980) AI_img.setLocation((p.x+230),(p.y+360)); // 파리 위치일 때 서울로 옮겨주기 위해 

								else if(p.x==1095) AI_img.setLocation((p.x+115),(p.y+480)); // 베를린 위치일 때 뉴욕으로 옮겨주기 위해 
							}

							if(p.x==1210) {
								if(p.y==190) AI_img.setLocation((p.x-115),(p.y+480)); // 호주 위치일 때 멕시코로 옮겨주기 위해 

								else if(p.y==310) AI_img.setLocation((p.x-230),(p.y+360)); // 벤쿠버 위치일 때 독도로 옮겨주기 위해 

								else if(p.y==430) AI_img.setLocation((p.x-345),(p.y+240)); // 서울 위치일 때 싱가폴로 옮겨주기 위해 

								else if(p.y==550) AI_img.setLocation((p.x-460),(p.y+120)); // 뉴욕 위치일 때 싱가폴로 옮겨주기 위해 
							}
						}


						if(Dice2==6) {
							D1.setVisible(false); // 이미지 초기화
							D2.setVisible(false); // 이미지 초기화
							D3.setVisible(false); // 이미지 초기화
							D4.setVisible(false); // 이미지 초기화
							D5.setVisible(false); // 이미지 초기화
							D6.setVisible(true); 
							AI_img.setLocation((p.x-690),(p.y));

							if(p.y==670) {
								if(p.x==635) AI_img.setLocation((p.x-575),(p.y-120)); // 도쿄 위치일 때 웨링턴으로 옮겨주기 위해 

								else if(p.x==520) AI_img.setLocation((p.x-460),(p.y-240)); // 베이징 위치일 때 벨기에로 옮겨주기 위해 

								else if(p.x==405) AI_img.setLocation((p.x-345),(p.y-360)); // 하노이 위치일 때 오슬로로 옮겨주기 위해 

								else if(p.x==290) AI_img.setLocation((p.x-230),(p.y-480)); // 몰디브 위치일 때 발리로 옮겨주기 위해 

								else if(p.x==175) AI_img.setLocation((p.x-115),(p.y-600)); // 그리스 위치일 때 카이로로 옮겨주기 위해 
							}

							if(p.x==60) {
								if(p.y==670) AI_img.setLocation((p.x+115),(p.y-600)); // 무인도 위치일 때 앙카라로 옮겨주기 위해

								else if(p.y==550) AI_img.setLocation((p.x+230),(p.y-480)); // 웨링턴 위치일 때 베른으로 옮겨주기 위해

								else if(p.y==430) AI_img.setLocation((p.x+345),(p.y-360)); // 벨기에 위치일 때 스톡홀롬으로 옮겨주기 위해

								else if(p.y==310) AI_img.setLocation((p.x+460),(p.y-240)); // 오슬로 위치일 때 하와이로 옮겨주기 위해

								else if(p.y==190) AI_img.setLocation((p.x+575),(p.y-120)); // 발리 위치일 때 모스크바로 옮겨주기 위해
							}

							if(p.y==70) {
								AI_img.setLocation((p.x+690),(p.y)); // 카이로에 도착했을 때
								if(p.x==635) AI_img.setLocation((p.x+575),(p.y+120)); // 모스크바 위치일 때 호주로 옮겨주기 위해

								else if(p.x==750) AI_img.setLocation((p.x+460),(p.y+240)); // 로마 위치일 때 벤쿠버로 옮겨주기 위해

								else if(p.x==865) AI_img.setLocation((p.x+345),(p.y+360)); // 런던 위치일 때 서울로 옮겨주기 위해

								else if(p.x==980)AI_img.setLocation((p.x+230),(p.y+480)); // 파리 위치일 때 뉴욕로 옮겨주기 위해

								else if(p.x==1095) AI_img.setLocation((p.x+115),(p.y+600)); // 베를린 위치일 때 출발점으로 옮겨주기 위해

								else if(p.x==1210) AI_img.setLocation((p.x-115),(p.y+600)); // 비행기 위치일 때 멕시코로 옮겨주기 위해
							}

							if(p.x==1210) {
								if(p.y==190) AI_img.setLocation((p.x-230),(p.y+480)); // 호주 위치일 때 독도로 옮겨주기 위해 

								else if(p.y==310) AI_img.setLocation((p.x-345),(p.y+360)); // 벤쿠버 위치일 때 싱가폴로 옮겨주기 위해 

								else if(p.y==430) AI_img.setLocation((p.x-460),(p.y+240)); // 서울 위치일 때 타이베이로 옮겨주기 위해 

								else if(p.y==550) AI_img.setLocation((p.x-575),(p.y+120)); // 뉴욕 위치일 때 도쿄로 옮겨주기 위해 
							}
							
						}
						timer1.cancel(); // timer가 돌면 여기서 멈출 수 있도록
					}
				};
				timer1.schedule(task1, 1500); // 딜레이 시간을 1.5초로 해줌
			
				
			}
		});
	}

	public void start(){ // 시작 버튼 마우스 이벤트
		bt3.addMouseListener(new MouseAdapter() { // 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때 
				
				
				Rule_F.setVisible(true); // 규칙 창이 뜸
				Rule_F.setSize(515, 530);
				Rule_F.setLocation(650, 250);
				Rule_F.add(page4);
				page4.add(bt7);
				page4.setVisible(true);


				Rule_F.addWindowListener(new WindowAdapter() { // X 버튼을 누르면 창이 꺼짐
					public void windowClosing(WindowEvent e) {
						Rule_F.setVisible(true);
						Rule_F.dispose();
					}
				});
				
				page1.setVisible(false); //창이 보이지 않게
				page2.setVisible(true); // 창이 보이게
				bt2.setVisible(false); // 종료 버튼 보이지 않게
				bt3.setVisible(false); // 시작 버튼 보이지 않게
				
				D1.setVisible(true);
				D2.setVisible(false); // 이미지 초기화
				D3.setVisible(false); // 이미지 초기화
				D4.setVisible(false); // 이미지 초기화
				D5.setVisible(false); // 이미지 초기화
				D6.setVisible(false); // 이미지 초기화
				
				P1_Land.setVisible(false); //이미지 초기화
				P1_Land2.setVisible(false); //이미지 초기화
				P1_Land3.setVisible(false); //이미지 초기화
				P1_Land4.setVisible(false); //이미지 초기화
				P1_Land5.setVisible(false); //이미지 초기화
				P1_Land6.setVisible(false); //이미지 초기화
				P1_Land7.setVisible(false); //이미지 초기화
				P1_Land8.setVisible(false); //이미지 초기화
				
				AI_Land.setVisible(false); //이미지 초기화
				AI_Land2.setVisible(false); //이미지 초기화
				AI_Land3.setVisible(false); //이미지 초기화
				AI_Land4.setVisible(false); //이미지 초기화
				AI_Land5.setVisible(false); //이미지 초기화
				AI_Land6.setVisible(false); //이미지 초기화
				AI_Land7.setVisible(false); //이미지 초기화
				AI_Land8.setVisible(false); //이미지 초기화
				
				P1_img.setBounds(1180, 670, 50,50);
				AI_img.setBounds(1210, 670, 50,50); 
				P1_img.setVisible(true);
				AI_img.setVisible(true);
				
				P1_cnt = 0;
				AI_cnt = 0;
			} 
		});
	}

	public void OK_button() { // 규칙 확인 버튼 마우스 이벤트
		bt7.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				Rule_F.dispose(); // 확인 버튼 누르면 규칙 프레임이 종료
			}
		});
	}

	public void end(){ // 종료 버튼 마우스 이벤트
		bt2.addMouseListener(new MouseAdapter() { // 마우스 이벤트 
			@Override public void mousePressed(MouseEvent e) { // 마우스 클릭했을때
				System.exit(0); // 프로그램이 종료됨
			} 
		});
	}
	
	public void Dice_button() { // 주사위 굴리기 버튼 마우스 이벤트
		bt1.addMouseListener(new MouseAdapter() { // 마우스 이벤트
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				Random ran = new Random(); // 주사위가 6개 중 랜덤으로 나오도록 랜덤 함수 사용
				int Dice1 =  ran.nextInt(6)+1;
				Point point=P1_img.getLocation();
				D1.setVisible(false); // 이미지 초기화
				D2.setVisible(false); // 이미지 초기화
				D3.setVisible(false); // 이미지 초기화
				D4.setVisible(false); // 이미지 초기화
				D5.setVisible(false); // 이미지 초기화
				D6.setVisible(false); // 이미지 초기화
				
				if(point.x==1180&&point.y==70) { // 비행기 프레임
					Airplane.setVisible(true); // 비행기 선택창이 뜸
					//page5.setVisible(true);
				}
						
				
				if(Dice1==1) {
					D1.setVisible(true);
					P1_img.setLocation((point.x-115),(point.y)); // 출발점

					if(point.x==30 ) P1_img.setLocation((point.x),(point.y-120)); // 무인도에 도착했을 때

					if(point.y==70) {
						P1_img.setLocation((point.x+115),(point.y)); // 카이로에 도착했을 때
						if(point.x==1180) {
							P1_img.setLocation((point.x),(point.y+120)); // 비행기에 도착했을 때
						}
					}

					if(point.x==1180) {						
						if(point.y==190) P1_img.setLocation((point.x),(point.y+120)); // 호주에 도착했을 때

						else if(point.y==310) P1_img.setLocation((point.x),(point.y+120)); // 벤쿠버에 도착했을 때

						else if(point.y==430) P1_img.setLocation((point.x),(point.y+120)); // 서울에 도착했을 때

						else if(point.y==550) P1_img.setLocation((point.x),(point.y+120)); // 뉴욕에 도착했을 때
					}

				}


				if(Dice1==2) {
					D2.setVisible(true);
					P1_img.setLocation((point.x-230),(point.y)); // 출발점
					if(point.x==30) P1_img.setLocation((point.x),(point.y-240)); // 무인도에 도착했을 때 (오류나서 따로 빼줌)

					if(point.y==70) {
						P1_img.setLocation((point.x+230),(point.y)); // 카이로에 도착했을 때
						if(point.x==1180) P1_img.setLocation((point.x),(point.y+240)); // 비행기에 도착했을 때

						else if(point.x==1065) P1_img.setLocation((point.x+115),(point.y+120)); // 베를린 위치일 때 호주로 옮겨주기 위해
					}

					if(point.x==1180) {
						if(point.y==190) P1_img.setLocation((point.x),(point.y+240)); // 호주에 도착했을 때

						else if(point.y==310) P1_img.setLocation((point.x),(point.y+240)); // 벤쿠버에 도착했을 때

						else if(point.y==430) P1_img.setLocation((point.x),(point.y+240)); // 서울에 도착했을 때

						else if(point.y==550) P1_img.setLocation((point.x-115),(point.y+120)); // 뉴욕 위치일 때 멕시코로 옮겨주기 위해
					}

					if(point.x==30) {
						if(point.y==190)  P1_img.setLocation((point.x+115),(point.y-120)); // 발리 위치일 때 앙카라로 옮겨주기 위해
					}

					if(point.x==145&&point.y==670) P1_img.setLocation((point.x-115),(point.y-120)); // 그리스 위치일 때 웨링턴으로 옮겨주기 위해

				}


				if(Dice1==3) {
					D3.setVisible(true);
					P1_img.setLocation((point.x-345),(point.y));
					if(point.x==30) P1_img.setLocation((point.x),(point.y-360)); // 무인도에 도착했을 때

					if(point.y==70) {
						P1_img.setLocation((point.x+345),(point.y)); // 카이로에 도착했을 때
						if(point.x==950) P1_img.setLocation((point.x+230),(point.y+120)); // 파리 위치일 때 호주로 옮겨주기 위해

						else if(point.x==1065) P1_img.setLocation((point.x+115),(point.y+240)); // 베를린 위치일 때 벤쿠버로 옮겨주기 위해

						else if(point.x==1180) P1_img.setLocation((point.x),(point.y+360)); // 비행기에 도착했을 때
					}

					if(point.x==1180) {
						if(point.y==190) P1_img.setLocation((point.x),(point.y+360)); // 호주에 도착했을 때

						else if(point.y==310) P1_img.setLocation((point.x),(point.y+360)); // 벤쿠버에 도착했을 때

						else if(point.y==430) P1_img.setLocation((point.x-115),(point.y+240)); // 서울 위치일 때 멕시코로 옮겨주기 위해

						else if(point.y==550) P1_img.setLocation((point.x-230),(point.y+120)); // 뉴욕 위치일 때 독도로 옮겨주기 위해
					}

					if(point.y==670) {
						if(point.x==260) P1_img.setLocation((point.x-230),(point.y-120)); // 몰디브 위치일 때 웨링턴으로 옮겨주기 위해

						else if(point.x==145) P1_img.setLocation((point.x-115),(point.y-240)); // 그리스 위치일 때 벨기에로 옮겨주기 위해
					}

					if(point.x==30) {
						if(point.y==190)  P1_img.setLocation((point.x+230),(point.y-120)); // 발리 위치일 때 베른으로 옮겨주기 위해

						else if(point.y==310)  P1_img.setLocation((point.x+115),(point.y-240)); // 오슬로 위치일 때 앙카라로 옮겨주기 위해
					}

				}


				if(Dice1==4) {
					D4.setVisible(true);
					P1_img.setLocation((point.x-460),(point.y));
					if(point.x==30) P1_img.setLocation((point.x),(point.y-480)); // 무인도에 도착했을 때 (오류나서 따로 빼줌)

					if(point.y==70) {
						P1_img.setLocation((point.x+460),(point.y)); // 카이로에 도착했을 때
						if(point.x==1180) P1_img.setLocation((point.x),(point.y+480)); // 비행기에 도착했을 때

						else if(point.x==835) P1_img.setLocation((point.x+345),(point.y+120)); // 런던 위치일 때 호주로 옮겨주기 위해

						else if(point.x==950) P1_img.setLocation((point.x+230),(point.y+240)); // 파리 위치일 때 벤쿠버로 옮겨주기 위해

						else if(point.x==1065) P1_img.setLocation((point.x+115),(point.y+360)); // 베를린 위치일 때 서울로 옮겨주기 위해
					}

					if(point.x==1180) {
						if(point.y==190) P1_img.setLocation((point.x),(point.y+480)); // 호주에 도착했을 때

						else if(point.y==310) P1_img.setLocation((point.x-115),(point.y+360)); // 벤쿠버 위치일 때 멕시코로 옮겨주기 위해

						else if(point.y==430) P1_img.setLocation((point.x-230),(point.y+240)); // 서울 위치일 때 독도로 옮겨주기 위해

						else if(point.y==550) P1_img.setLocation((point.x-345),(point.y+120)); // 뉴욕 위치일 때 싱가폴로 옮겨주기 위해
					}

					if(point.x==30) {
						if(point.y==430) P1_img.setLocation((point.x+115),(point.y-360)); // 벨기에 위치일 때 앙카라로 옮겨주기 위해

						else if(point.y==310) P1_img.setLocation((point.x+230),(point.y-240)); // 오슬로 위치일 때 베른으로 옮겨주기 위해

						else if(point.y==190) P1_img.setLocation((point.x+345),(point.y-120)); // 발리 위치일 때 스톡홀름으로 옮겨주기 위해
					}

					if(point.y==670) {
						if(point.x==375) P1_img.setLocation((point.x-345),(point.y-120)); //하노이 위치일 때 웨링턴으로 옮겨주기 위해

						else if(point.x==260) P1_img.setLocation((point.x-230),(point.y-240)); //몰리브 위치일 때 벨기에로 옮겨주기 위해

						else if(point.x==145) P1_img.setLocation((point.x-115),(point.y-360)); //그리스 위치일 때 오슬로로 옮겨주기 위해
					}

				}


				if(Dice1==5) {
					D5.setVisible(true);
					P1_img.setLocation((point.x-575),(point.y));
					if(point.x==30) P1_img.setLocation((point.x),(point.y-600)); // 무인도에 도착했을 때 (오류나서 따로 빼줌)

					if(point.y==670) {
						if(point.x==490) P1_img.setLocation((point.x-460),(point.y-120)); // 베이징 위치일 때 웨링턴으로 옮겨주기 위해 

						else if(point.x==375) P1_img.setLocation((point.x-345),(point.y-240)); // 하노이 위치일 때 벨기에으로 옮겨주기 위해 

						else if(point.x==260) P1_img.setLocation((point.x-230),(point.y-360)); // 몰디브 위치일 때 오슬로로 옮겨주기 위해 

						else if(point.x==145) P1_img.setLocation((point.x-115),(point.y-480)); // 그리스 위치일 때 발리로 옮겨주기 위해 
					}

					if(point.x==30) {
						if(point.y==550) P1_img.setLocation((point.x+115),(point.y-480)); // 웨링턴 위치일 때 앙카라로 옮겨주기 위해 

						else if(point.y==430) P1_img.setLocation((point.x+230),(point.y-360)); // 벨기에 위치일 때 베른으로 옮겨주기 위해 

						else if(point.y==310) P1_img.setLocation((point.x+345),(point.y-240)); // 오슬로 위치일 때 스톡홀름으로 옮겨주기 위해 

						else if(point.y==190) P1_img.setLocation((point.x+460),(point.y-120)); // 발리 위치일 때 하와이로 옮겨주기 위해 
					}

					if(point.y==70) {
						P1_img.setLocation((point.x+575),(point.y)); // 카이로에 도착했을 때
						if(point.x==1180) P1_img.setLocation((point.x),(point.y+600)); // 비행기에 도착했을 때

						else if(point.x==720) P1_img.setLocation((point.x+460),(point.y+120)); // 로마 위치일 때 호주로 옮겨주기 위해 

						else if(point.x==835) P1_img.setLocation((point.x+345),(point.y+240)); // 런던 위치일 때 벤쿠버로 옮겨주기 위해

						else if(point.x==950) P1_img.setLocation((point.x+230),(point.y+360)); // 파리 위치일 때 서울로 옮겨주기 위해 

						else if(point.x==1065) P1_img.setLocation((point.x+115),(point.y+480)); // 베를린 위치일 때 뉴욕으로 옮겨주기 위해 
					}

					if(point.x==1180) {
						if(point.y==190) P1_img.setLocation((point.x-115),(point.y+480)); // 호주 위치일 때 멕시코로 옮겨주기 위해 

						else if(point.y==310) P1_img.setLocation((point.x-230),(point.y+360)); // 벤쿠버 위치일 때 독도로 옮겨주기 위해 

						else if(point.y==430) P1_img.setLocation((point.x-345),(point.y+240)); // 서울 위치일 때 싱가폴로 옮겨주기 위해 

						else if(point.y==550) P1_img.setLocation((point.x-460),(point.y+120)); // 뉴욕 위치일 때 싱가폴로 옮겨주기 위해 
					}
				}


				if(Dice1==6) {
					D6.setVisible(true);
					P1_img.setLocation((point.x-690),(point.y));

					if(point.y==670) {
						if(point.x==605) P1_img.setLocation((point.x-575),(point.y-120)); // 도쿄 위치일 때 웨링턴으로 옮겨주기 위해 

						else if(point.x==490) P1_img.setLocation((point.x-460),(point.y-240)); // 베이징 위치일 때 벨기에로 옮겨주기 위해 

						else if(point.x==375) P1_img.setLocation((point.x-345),(point.y-360)); // 하노이 위치일 때 오슬로로 옮겨주기 위해 

						else if(point.x==260) P1_img.setLocation((point.x-230),(point.y-480)); // 몰디브 위치일 때 발리로 옮겨주기 위해 

						else if(point.x==145) P1_img.setLocation((point.x-115),(point.y-600)); // 그리스 위치일 때 카이로로 옮겨주기 위해 
					}

					if(point.x==30) {
						if(point.y==670) P1_img.setLocation((point.x+115),(point.y-600)); // 무인도 위치일 때 앙카라로 옮겨주기 위해

						else if(point.y==550) P1_img.setLocation((point.x+230),(point.y-480)); // 웨링턴 위치일 때 베른으로 옮겨주기 위해

						else if(point.y==430) P1_img.setLocation((point.x+345),(point.y-360)); // 벨기에 위치일 때 스톡홀롬으로 옮겨주기 위해

						else if(point.y==310) P1_img.setLocation((point.x+460),(point.y-240)); // 오슬로 위치일 때 하와이로 옮겨주기 위해

						else if(point.y==190) P1_img.setLocation((point.x+575),(point.y-120)); // 발리 위치일 때 모스크바로 옮겨주기 위해
					}

					if(point.y==70) {
						P1_img.setLocation((point.x+690),(point.y)); // 카이로에 도착했을 때
						if(point.x==605) P1_img.setLocation((point.x+575),(point.y+120)); // 모스크바 위치일 때 호주로 옮겨주기 위해

						else if(point.x==720) P1_img.setLocation((point.x+460),(point.y+240)); // 로마 위치일 때 벤쿠버로 옮겨주기 위해

						else if(point.x==835) P1_img.setLocation((point.x+345),(point.y+360)); // 런던 위치일 때 서울로 옮겨주기 위해

						else if(point.x==950) P1_img.setLocation((point.x+230),(point.y+480)); // 파리 위치일 때 뉴욕로 옮겨주기 위해

						else if(point.x==1065) P1_img.setLocation((point.x+115),(point.y+600)); // 베를린 위치일 때 출발점으로 옮겨주기 위해

						else if(point.x==1180) P1_img.setLocation((point.x-115),(point.y+600)); // 비행기 위치일 때 멕시코로 옮겨주기 위해
					}

					if(point.x==1180) {
						if(point.y==190) P1_img.setLocation((point.x-230),(point.y+480)); // 호주 위치일 때 독도로 옮겨주기 위해 

						else if(point.y==310) P1_img.setLocation((point.x-345),(point.y+360)); // 벤쿠버 위치일 때 싱가폴로 옮겨주기 위해 

						else if(point.y==430) P1_img.setLocation((point.x-460),(point.y+240)); // 서울 위치일 때 타이베이로 옮겨주기 위해 

						else if(point.y==550) P1_img.setLocation((point.x-575),(point.y+120)); // 뉴욕 위치일 때 도쿄로 옮겨주기 위해 
					}


				}

			}
		});
	}

	public void Buy_button() { // 구매 버튼 마우스 이벤트 
		bt4.addMouseListener(new MouseAdapter() { // 마우스 이벤트
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				Buy_F.setVisible(true);
				Buy_F.setSize(500, 500);
				Buy_F.setLocation(650, 250);
				Buy_F.add(page3);
				page3.add(bt5);
				page3.add(bt6);
				page3.setVisible(true);

				Buy_F.addWindowListener(new WindowAdapter() { // X 버튼을 누르면 창이 꺼짐
					public void windowClosing (WindowEvent e) {
						Buy_F.setVisible(true);
						Buy_F.dispose();
					}
				});

			}
		});
	}

	public void X_button() { // 구매 취소 버튼 마우스 이벤트
		bt5.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				Buy_F.dispose(); // 취소 버튼 누르면 구매 프레임이 종료
			}
		});
	}
	
	public void Airplane() { // 비행기 이벤트
		bt1.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				Point point=P1_img.getLocation();
				if(point.x==1180&&point.y==70) { // 비행기 프레임
					Airplane.setVisible(true); // 비행기 선택창이 뜸
				}
			}
		});
	}
	
	public void Restart_button() { // 다시하기 버튼
		bt9.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때
				AI_cnt = 0; // 땅 개수 초기화
				P1_cnt = 0; // 땅 개수 초기화
				P1_img.setBounds(1180, 670, 50,50); // 플레이어 위치 초기화
				AI_img.setBounds(1210, 670, 50,50);  // AI 위치 초기화
				
				page1.setVisible(false); //창이 보이지 않게
				page6.setVisible(false); //창이 보이지 않게
				page7.setVisible(false); //창이 보이지 않게
				page2.setVisible(true); // 창이 보이게
				
				bt1.setVisible(true); // 주사위 굴리기 버튼 이미지 숨기기
				bt2.setVisible(false); // 시작 버튼 이미지 숨기기
				bt3.setVisible(false); // 종료 버튼 이미지 숨기기
				
				D1.setVisible(true);
				D2.setVisible(false); // 이미지 초기화
				D3.setVisible(false); // 이미지 초기화
				D4.setVisible(false); // 이미지 초기화
				D5.setVisible(false); // 이미지 초기화
				D6.setVisible(false); // 이미지 초기화
				
				P1_Land.setVisible(false); //이미지 초기화
				P1_Land2.setVisible(false); //이미지 초기화
				P1_Land3.setVisible(false); //이미지 초기화
				P1_Land4.setVisible(false); //이미지 초기화
				P1_Land5.setVisible(false); //이미지 초기화
				P1_Land6.setVisible(false); //이미지 초기화
				P1_Land7.setVisible(false); //이미지 초기화
				P1_Land8.setVisible(false); //이미지 초기화
				
				AI_Land.setVisible(false); //이미지 초기화
				AI_Land2.setVisible(false); //이미지 초기화
				AI_Land3.setVisible(false); //이미지 초기화
				AI_Land4.setVisible(false); //이미지 초기화
				AI_Land5.setVisible(false); //이미지 초기화
				AI_Land6.setVisible(false); //이미지 초기화
				AI_Land7.setVisible(false); //이미지 초기화
				AI_Land8.setVisible(false); //이미지 초기화
			}
		});
	}
	
	public void B_button() { // 구매하기에서 구매하기 버튼
		bt6.addMouseListener(new MouseAdapter() {
			@Override public void mousePressed(MouseEvent e) { // 클릭했을때			
				Random ran2 = new Random(); 
				Random ran3 = new Random(); 
				Timer timer2 = new Timer();
				int land1 = ran2.nextInt(2)+1;
				int land2 = ran3.nextInt(1)+1;
				
				Point point=P1_img.getLocation();			
				Point p =AI_img.getLocation();
				Point P1 = P1_Land.getLocation();
				Point AI = AI_Land.getLocation();
				
				if(land1==1) {}
				if(land1==2) {
					P1_cnt ++;
					switch(P1_cnt) {
						case 1 : P1_Land.setVisible(true);
					  				P1_Land.setLocation(point.x-18, point.y-60); break;
						case 2 : P1_Land2.setVisible(true);
									P1_Land2.setLocation(point.x-18, point.y-60); break;
						case 3 : P1_Land3.setVisible(true);
									P1_Land3.setLocation(point.x-18, point.y-60); break;
						case 4 : P1_Land4.setVisible(true);
	  								P1_Land4.setLocation(point.x-18, point.y-60); break;
						case 5 : P1_Land5.setVisible(true);
									P1_Land5.setLocation(point.x-18, point.y-60); break;
						case 6 : P1_Land6.setVisible(true);
									P1_Land6.setLocation(point.x-18, point.y-60); break;
						case 7 : P1_Land7.setVisible(true);
									P1_Land7.setLocation(point.x-18, point.y-60); break;
						case 8 : P1_Land8.setVisible(true);
									P1_Land8.setLocation(point.x-18, point.y-60); break;
						}
				}
				
				TimerTask task2 = new TimerTask() {
					@Override
					public void run() {
						if(land2==2) {}
						if(land2==1) {
							AI_cnt ++;
							switch(AI_cnt) {
									case 1 : AI_Land.setVisible(true);
										AI_Land.setLocation(p.x-45, p.y-60); break;
									case 2 : AI_Land2.setVisible(true);
										AI_Land2.setLocation(p.x-45, p.y-60); break;
									case 3 : AI_Land3.setVisible(true);
										AI_Land3.setLocation(p.x-45, p.y-60); break;
									case 4 : AI_Land4.setVisible(true);
		  								AI_Land4.setLocation(p.x-45, p.y-60); break;
									case 5 : AI_Land5.setVisible(true);
										AI_Land5.setLocation(p.x-45, p.y-60); break;
									case 6 : AI_Land6.setVisible(true);
										AI_Land6.setLocation(p.x-45, p.y-60); break;
									case 7 : AI_Land7.setVisible(true);
										AI_Land7.setLocation(p.x-45, p.y-60); break;
									case 8 : AI_Land8.setVisible(true);
										AI_Land8.setLocation(p.x-45, p.y-60); break;
							}
					
							timer2.cancel();
						}
					}
				};
				timer2.schedule(task2, 0); // 플레이어 땅 구매 시 동시에 뜸
				
				
				if(P1_cnt==8) {
					add(page6); //프레임에 패널 추가
					page6.setVisible(true);	 // 승리 화면 띄우기
					page6.add(bt9); // 다시하기 버튼 추가
					
					page1.setVisible(false); // 시작 화면 숨기기
					page2.setVisible(false); 
					
					bt1.setVisible(false); // 주사위 굴리기 버튼 이미지 숨기기
					bt2.setVisible(false); // 시작 버튼 이미지 숨기기
					bt3.setVisible(false); // 종료 버튼 이미지 숨기기
					
					D1.setVisible(false); // 주사위 1~6 이미지 숨기기
					D2.setVisible(false);
					D3.setVisible(false);
					D4.setVisible(false);
					D5.setVisible(false);
					D6.setVisible(false);
				}
				
				if(AI_cnt==8) {
					add(page7); //프레임에 패널 추가
					page7.setVisible(true);	 // AI 승리 패널
					page7.add(bt9); // 다시하기 버튼 추가
					
					page1.setVisible(false);
					page2.setVisible(false);
					
					bt1.setVisible(false); // 주사위 굴리기 버튼 이미지 숨기기
					bt2.setVisible(false); // 시작 버튼 이미지 숨기기
					bt3.setVisible(false); // 종료 버튼 이미지 숨기기
					
					D1.setVisible(false); // 주사위 1~6 이미지 숨기기
					D2.setVisible(false);
					D3.setVisible(false);
					D4.setVisible(false);
					D5.setVisible(false);
					D6.setVisible(false);
				}
				
				Buy_F.dispose(); // 구매 버튼 누르면 구매 프레임 종료
			}
		});	
	}


	/*메인함수*/
	public static void main(String[] args){

		new Program();
	}
}
