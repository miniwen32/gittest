package myUtil;

public class ValueToWord {

	/************ 男女 **************/
	public static final String turnGender(String gender) {
		String result = null;

		if ("0".equals(gender)) {
			result = "男生";
		} else {
			result = "女生";
		}
		return result;
	}

	/************ 會員 **************/
	public static final String turnMemberStatus(String status) {
		String result = null;

		switch (status) {
		case "0":
			result = "未驗證";
			break;
		case "1":
			result = "已驗證 ";
			break;
		case "2":
			result = "停權";
			break;
		}
		return result;
	}
	
	/************管理員 **************/
	public static final String turnAdministrator(String administrator) {
		String result = null;

		switch (administrator) {
		case "0":
			result = "離職";
			break;
		case "1":
			result = "在職";
			break;
		}
		return result;
	}
	
	/************ 揪團 **************/
	public static final String turnTeam(String team) {
		String result = null;

		switch (team) {
		case "0":
			result = "未成團";
			break;
		case "1":
			result = "已成團";
			break;
		case "2":
			result = "取消";
			break;
		}
		return result;
	}

	/*********** 參團人員 **************/
	public static final String turnTeam_List(String team_list) {
		String result = null;

		switch (team_list) {
		case "0":
			result = "未審核";
			break;
		case "1":
			result = "通過";
			break;
		case "2":
			result = "未通過";
			break;
		case "3":
			result = "自行取消";
			break;
		}
		return result;
	}

	/*********** 揪團檢舉 **************/
	public static final String turnTeam_RE(String team_re) {
		String result = null;

		switch (team_re) {
		case "0":
			result = "未審核";
			break;
		case "1":
			result = "已審核";
			break;
		case "2":
			result = "審核未功過";
			break;
		}
		return result;
	}

	/*********** 廚師 **************/
	public static final String turnChef(String chef) {
		String result = null;

		switch (chef) {
		case "0":
			result = "無廚師身分";
			break;
		case "1":
			result = "有廚師身分";
			break;
		}
		return result;
	}

	/*********** 課程 **************/
	public static final String turnCourse(String course) {
		String result = null;

		switch (course) {
		case "0":
			result = "上架";
			break;
		case "1":
			result = "下架";
			break;
		}
		return result;
	}

	/*********** 廚師檢舉 **************/
	public static final String turnChef_re(String chef_re) {
		String result = null;

		switch (chef_re) {
		case "0":
			result = "未審核";
			break;
		case "1":
			result = "審核通過";
			break;
		case "2":
			result = "審核未通過";
			break;
		}
		return result;
	}

	/*********** 課程訂單(訂單狀態) **************/
	public static final String turnCourse_order(String course_order) {
		String result = null;

		switch (course_order) {
		case "0":
			result = "未審核";
			break;
		case "1":
			result = "接單";
			break;
		case "2":
			result = "未執行訂單";
			break;
		case "3":
			result = "已執行訂單";
			break;
		}
		return result;
	}

	/*********** 課程訂單(繳費狀態) **************/
	public static final String turnCoursePayment(String payment) {
		String result = null;

		switch (payment) {
		case "0":
			result = "未繳費";
			break;
		case "1":
			result = "已繳費";
			break;
		}
		return result;
	}

	/*********** 課程訂單(課程時間) **************/
	public static final String turnCourse_time(String course_time) {
		String result = null;

		switch (course_time) {
		case "0":
			result = "中午";
			break;
		case "1":
			result = "晚上";
			break;
		}
		return result;
	}

	/*********** 商品 **************/
	public static final String turnProduct(String product) {
		String result = null;

		switch (product) {
		case "0":
			result = "下架";
			break;
		case "1":
			result = "上架";
			break;
		}
		return result;
	}

	/*********** 商品訂單 **************/
	public static final String turnPro_order(String pro_order) {
		String result = null;

		switch (pro_order) {
		case "0":
			result = "未出貨";
			break;
		case "1":
			result = "已出貨";
			break;
		case "2":
			result = "取消";
			break;
		}
		return result;
	}

	/*********** 食譜檢舉 **************/
	public static final String turnFood_re(String food_re) {
		String result = null;

		switch (food_re) {
		case "0":
			result = "未審核";
			break;
		case "1":
			result = "已審核";
			break;
		}
		return result;
	}

	/*********** 直播 **************/
	public static final String turnLive(String live) {
		String result = null;

		switch (live) {
		case "0":
			result = "未開始";
			break;
		case "1":
			result = "正開始";
			break;
		case "2":
			result = "已結束";
			break;
		case "3":
			result = "違規";
			break;
		}
		return result;
	}

}
