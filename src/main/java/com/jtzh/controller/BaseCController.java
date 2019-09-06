package com.jtzh.controller;

import com.jtzh.pojo.DefaultResponse;
import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BaseCController {

    private static Key getKey(String keySeed) {
        if (keySeed == null) {
            keySeed = System.getenv("AES_SYS_KEY");
        }
        if (keySeed == null) {
            keySeed = System.getProperty("AES_SYS_KEY");
        }
        if (keySeed == null || keySeed.trim().length() == 0) {
            keySeed = "abcd1234!@#$";// 默认种子
        }
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(keySeed.getBytes());
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            generator.init(secureRandom);
            return generator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 根据密钥对指定的密文cipherText进行解密.
     *
     * @param cipherText 密文
     * @return 解密后的明文.
     */
    protected static final String decrypt(String cipherText) {
        if(StringUtils.isBlank(cipherText)) return null;
        Key secretKey = getKey("fendo888");
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] c = decoder.decodeBuffer(cipherText);
            byte[] result = cipher.doFinal(c);
            String plainText = new String(result, "UTF-8");
            return plainText;
        } catch (Exception e) {
//            throw new RuntimeException(e);
            return null;
        }
    }

    /**
     * 根据密钥对指定的明文plainText进行加密.
     *
     * @param plainText 明文
     * @return 加密后的密文.
     */
    protected static final String encrypt(String plainText) {
        Key secretKey = getKey("fendo888");
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] p = plainText.getBytes("UTF-8");
            byte[] result = cipher.doFinal(p);
            BASE64Encoder encoder = new BASE64Encoder();
            String encoded = encoder.encode(result);
            return encoded;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 错误返回
     * @param message 返回提示
     * @return 返回对象
     */
    protected DefaultResponse error(String message) {
        DefaultResponse response = new DefaultResponse();
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }

    /**
     * 成功返回
     * @param message 成功消息
     * @return 返回对象
     */
    protected DefaultResponse success(String message) {
        DefaultResponse response = new DefaultResponse();
        response.setSuccess(true);
        response.setMessage(message);
        return response;
    }

    /**
     * 列表页返回
     * @param total 总条数
     * @param rows 行数
     * @return 返回实体
     */
    protected DefaultResponse list(int total, Collection rows) {
        DefaultResponse response = new DefaultResponse();
        response.setSuccess(true);
        response.setMessage("查询成功");
        response.setRows(rows);
        return response;
    }
}
