package myUtil;

public class RandomCode {
	private String password;

		public StringBuilder getAuthCode() {
			StringBuilder randomWord = new StringBuilder();
			// 先把所有可能的值存在二維陣列裡
			char mix[][] = { { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' },
					{ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
							'u', 'v', 'w', 'x', 'y', 'z' },
					{ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
							'U', 'V', 'W', 'X', 'Y', 'Z' } };
			// 三列的資料數不同,用迴圈取想要的數值
			int count = 0;
			// 次數暫存變數
			for (int i = 0; i < mix.length; i++) {
				for (int j = 0; j < mix[i].length; j++) {
					while (count < 6) {
						// 取6個亂數
						i = (int) (Math.random() * 3); // 亂數取綜的位置
						j = (int) (Math.random() * mix[i].length); // 亂數取列的位置
						randomWord.append(mix[i][j]);
						count++;
					}
				}
			}
			return randomWord;

		}
		
		public  String getpassword(StringBuilder randomWord) {
			this.password = randomWord.append("li").toString();
			return password;
		}
		
	}


