package myUtil;

import java.io.*;
import javax.servlet.http.Part;

public class Upload {
	//¼g¶i¸ê®Æ®w
	public final static byte[] toPic(Part part) {
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		try {
			InputStream in = part.getInputStream();
			byte[] buffer = new byte[2048];
			int i;
			while ((i = in.read(buffer)) != -1) {
				bao.write(buffer, 0, i);
			}
			bao.close();
			in.close();
		} catch (IOException se) {
			se.printStackTrace();
		}
		return bao.toByteArray();
	}

}
