package myUtil;

public class RandomCode {
	private String password;

		public StringBuilder getAuthCode() {
			StringBuilder randomWord = new StringBuilder();
			// ����Ҧ��i�઺�Ȧs�b�G���}�C��
			char mix[][] = { { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' },
					{ 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
							'u', 'v', 'w', 'x', 'y', 'z' },
					{ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
							'U', 'V', 'W', 'X', 'Y', 'Z' } };
			// �T�C����ƼƤ��P,�ΰj����Q�n���ƭ�
			int count = 0;
			// ���ƼȦs�ܼ�
			for (int i = 0; i < mix.length; i++) {
				for (int j = 0; j < mix[i].length; j++) {
					while (count < 6) {
						// ��6�Ӷü�
						i = (int) (Math.random() * 3); // �üƨ����m
						j = (int) (Math.random() * mix[i].length); // �üƨ��C����m
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


