package org.review.base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author lijichen
 * @date 2020/10/13 - 14:47
 */
public class Base64 {
    public static void main(String[] args) throws IOException {
        String content = "这时base64编码内容";

        //获取编码器
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //编码
        String encode = base64Encoder.encode(content.getBytes("UTF-8"));
        System.out.println(encode);

        //获取解码器
        BASE64Decoder base64Decoder = new BASE64Decoder();
        //解码操作
        byte[] bytes = base64Decoder.decodeBuffer(encode);
        System.out.println(new String(bytes, "UTF-8"));

    }
}
