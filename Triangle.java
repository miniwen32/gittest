
public class Triangle
{
	public static String determineTriangleV1 (int a, int b, int c)
	{
		if ((a <= 0) || (b <= 0) || (c <= 0))
		{
			return "Not a triangle";
		}
		else
		{
			if ((a + b <= c) || (a + c <= b) || (b + c <= a))
			{
				return "Not a triangle";
			}
			else
			{
				if ((a == b) && (b == c))
				{
					return "Regular triangle";
				}
				if ((a == b) || (b == c) || (c == a))
				{
					return "Isosceles triangle";
				}
				if ((a * a + b * b == c * c) || (b * b + c * c == a * a) || (c * c + a * a == b * b))
				{
					return "Right triangle";
				}
			}
		}
		return "Be a triangle";
	}

	public static String determineTriangleV2 (int a, int b, int c)
	{
		String result = "";
		if ((a <= 0) || (b <= 0) || (c <= 0))
		{
			result = "Not a triangle";
		}
		else
		{
			result = "Be a triangle";
			if ((a + b <= c) || (a + c <= b) || (b + c <= a))
			{
				result = "Not a triangle";
			}
			else
			{
				if ((a == b) || (b == c) || (c == a))
				{
					result = "Isosceles triangle";
				}
				if ((a == b) && (b == c))
				{
					result = "Regular triangle";
				}
				if ((a * a + b * b == c * c) || (b * b + c * c == a * a)
						|| (c * c + a * a == b * b))
				{
					result = "Right triangle";
				}
			}
		}
		return result;
	}
}
