package com.jtzh.common;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

public class ImageCheck {

    public boolean checkPNG(InputStream stream) throws Exception {
        byte[] sign = new byte[8];
        if (stream == null) throw new Exception("文件流为空，检查失败");
        int read = stream.read(sign, 0, 8);
        if (read == 0) throw new Exception("文件流为空，检查失败");
        int[] trueSign = new int[]{0x89, 0x50, 0x4E, 0x47, 0x0D, 0x0A, 0x1A, 0x0A};
        for (int i = 0; i < trueSign.length; ++i) {
            if (((byte) trueSign[i]) != sign[i]) return false;
        }
        return true;
    }
}
