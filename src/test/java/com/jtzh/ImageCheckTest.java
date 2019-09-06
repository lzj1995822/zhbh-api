package com.jtzh;

import com.jtzh.common.ImageCheck;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;

public class ImageCheckTest {

    //@Test
    public void CheckPNGTestPass() throws Exception {
        ImageCheck check = new ImageCheck();
        boolean actual = check.checkPNG(new FileInputStream("D:\\JRPartyService2018-11-1\\JRParty\\JRadvance\\img\\camera\\50.png"));
        boolean expected = true;
        Assert.assertEquals(expected, actual);
    }
    //@Test
    public void CheckPNGTestFailed() throws Exception {
        ImageCheck check = new ImageCheck();
        boolean actual = check.checkPNG(new FileInputStream("C:\\Program Files\\NVIDIA Corporation\\Ansel\\ShaderMod\\chunkyGrain.bmp"));
        boolean expected = false;
        Assert.assertEquals(expected, actual);
    }
}
