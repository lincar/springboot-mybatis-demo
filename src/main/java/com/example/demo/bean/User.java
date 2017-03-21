package com.example.demo.bean;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

/**
 * Created by rico on 2016/2/19.
 * 账户信息表
 */
public class User extends BaseBean {

    private static final int ENCODE_SHA1 = 40;
    private static final int ENCODE_SHA512 = 128;

    private static Log log = LogFactory.getLog(User.class);

    private String nickName;

    @JSONField(serialize = false)
    private String password;

    private String gobalKey;

    private Short status;

    private Short role;

    private String email;

    private Timestamp created_at;

    private Timestamp updated_at;

    private Timestamp last_logined_at;

    public User() {
        created_at = new Timestamp(System.currentTimeMillis());
        updated_at = new Timestamp(System.currentTimeMillis());
        last_logined_at = new Timestamp(System.currentTimeMillis());
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGobalKey() {
        return gobalKey;
    }

    public void setGobalKey(String gobalKey) {
        this.gobalKey = gobalKey;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getRole() {
        return role;
    }

    public void setRole(Short role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Timestamp getLast_logined_at() {
        return last_logined_at;
    }

    public void setLast_logined_at(Timestamp last_logined_at) {
        this.last_logined_at = last_logined_at;
    }

    public void setSha512EncodedPassword(String password) {
        this.password = sha512EncodePassword(password);
    }

    /**
     * 校验密码，入参已经过最终加密
     */
    public boolean checkSha512Password(String plainPassword) {
        return password.equals(sha512EncodePassword(plainPassword));
    }

    /**
     * 将sha1方式加密后的密文拼接21次之后再用sha512加密
     */
    public static String sha512EncodePassword(String password) {
        StringBuilder hexString = new StringBuilder();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            StringBuilder appendedString = new StringBuilder();
            //将sha1加密后的字段拼接21次，相当于加盐
            for (int i = 1; i <= 21; i++) {
                appendedString.append(password);
            }
            digest.update(appendedString.toString().getBytes());
            byte messageDigest[] = digest.digest();
            for (byte aMessageDigest : messageDigest)
                hexString.append(String.format("%02x", 0xFF & aMessageDigest));
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            log.info(e.getMessage());
        }
        return "";
    }

//    public static void main(String args[]) {
//        String passworld = sha512EncodePassword("llh");
//        System.out.print("秘密是:" + passworld);
//    }

}
