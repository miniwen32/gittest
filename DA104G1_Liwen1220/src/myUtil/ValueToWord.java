package myUtil;

public class ValueToWord {

	/************ �k�k **************/
	public static final String turnGender(String gender) {
		String result = null;

		if ("0".equals(gender)) {
			result = "�k��";
		} else {
			result = "�k��";
		}
		return result;
	}

	/************ �|�� **************/
	public static final String turnMemberStatus(String status) {
		String result = null;

		switch (status) {
		case "0":
			result = "������";
			break;
		case "1":
			result = "�w���� ";
			break;
		case "2":
			result = "���v";
			break;
		}
		return result;
	}
	
	/************�޲z�� **************/
	public static final String turnAdministrator(String administrator) {
		String result = null;

		switch (administrator) {
		case "0":
			result = "��¾";
			break;
		case "1":
			result = "�b¾";
			break;
		}
		return result;
	}
	
	/************ ���� **************/
	public static final String turnTeam(String team) {
		String result = null;

		switch (team) {
		case "0":
			result = "������";
			break;
		case "1":
			result = "�w����";
			break;
		case "2":
			result = "����";
			break;
		}
		return result;
	}

	/*********** �ѹΤH�� **************/
	public static final String turnTeam_List(String team_list) {
		String result = null;

		switch (team_list) {
		case "0":
			result = "���f��";
			break;
		case "1":
			result = "�q�L";
			break;
		case "2":
			result = "���q�L";
			break;
		case "3":
			result = "�ۦ����";
			break;
		}
		return result;
	}

	/*********** �������| **************/
	public static final String turnTeam_RE(String team_re) {
		String result = null;

		switch (team_re) {
		case "0":
			result = "���f��";
			break;
		case "1":
			result = "�w�f��";
			break;
		case "2":
			result = "�f�֥��\�L";
			break;
		}
		return result;
	}

	/*********** �p�v **************/
	public static final String turnChef(String chef) {
		String result = null;

		switch (chef) {
		case "0":
			result = "�L�p�v����";
			break;
		case "1":
			result = "���p�v����";
			break;
		}
		return result;
	}

	/*********** �ҵ{ **************/
	public static final String turnCourse(String course) {
		String result = null;

		switch (course) {
		case "0":
			result = "�W�[";
			break;
		case "1":
			result = "�U�[";
			break;
		}
		return result;
	}

	/*********** �p�v���| **************/
	public static final String turnChef_re(String chef_re) {
		String result = null;

		switch (chef_re) {
		case "0":
			result = "���f��";
			break;
		case "1":
			result = "�f�ֳq�L";
			break;
		case "2":
			result = "�f�֥��q�L";
			break;
		}
		return result;
	}

	/*********** �ҵ{�q��(�q�檬�A) **************/
	public static final String turnCourse_order(String course_order) {
		String result = null;

		switch (course_order) {
		case "0":
			result = "���f��";
			break;
		case "1":
			result = "����";
			break;
		case "2":
			result = "������q��";
			break;
		case "3":
			result = "�w����q��";
			break;
		}
		return result;
	}

	/*********** �ҵ{�q��(ú�O���A) **************/
	public static final String turnCoursePayment(String payment) {
		String result = null;

		switch (payment) {
		case "0":
			result = "��ú�O";
			break;
		case "1":
			result = "�wú�O";
			break;
		}
		return result;
	}

	/*********** �ҵ{�q��(�ҵ{�ɶ�) **************/
	public static final String turnCourse_time(String course_time) {
		String result = null;

		switch (course_time) {
		case "0":
			result = "����";
			break;
		case "1":
			result = "�ߤW";
			break;
		}
		return result;
	}

	/*********** �ӫ~ **************/
	public static final String turnProduct(String product) {
		String result = null;

		switch (product) {
		case "0":
			result = "�U�[";
			break;
		case "1":
			result = "�W�[";
			break;
		}
		return result;
	}

	/*********** �ӫ~�q�� **************/
	public static final String turnPro_order(String pro_order) {
		String result = null;

		switch (pro_order) {
		case "0":
			result = "���X�f";
			break;
		case "1":
			result = "�w�X�f";
			break;
		case "2":
			result = "����";
			break;
		}
		return result;
	}

	/*********** �������| **************/
	public static final String turnFood_re(String food_re) {
		String result = null;

		switch (food_re) {
		case "0":
			result = "���f��";
			break;
		case "1":
			result = "�w�f��";
			break;
		}
		return result;
	}

	/*********** ���� **************/
	public static final String turnLive(String live) {
		String result = null;

		switch (live) {
		case "0":
			result = "���}�l";
			break;
		case "1":
			result = "���}�l";
			break;
		case "2":
			result = "�w����";
			break;
		case "3":
			result = "�H�W";
			break;
		}
		return result;
	}

}
