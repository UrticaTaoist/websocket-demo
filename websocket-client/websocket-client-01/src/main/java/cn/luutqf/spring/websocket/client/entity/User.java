package cn.luutqf.spring.websocket.client.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhouwei
 * @Description: 学员信息表
 * @create 2018-01-05 下午4:24
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User implements Serializable {

    private long id;

    private long phpUserId;
    private String openId;
    private String name;
    private String phone;
    private String idCard;
    private String nation;

    private Integer sex;

    private Boolean pregnancy;
    private String keyContact;
    private Integer status;

    private Boolean agreement;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPhpUserId() {
        return phpUserId;
    }

    public void setPhpUserId(long phpUserId) {
        this.phpUserId = phpUserId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Boolean getPregnancy() {
        return pregnancy;
    }

    public void setPregnancy(Boolean pregnancy) {
        this.pregnancy = pregnancy;
    }

    public String getKeyContact() {
        return keyContact;
    }

    public void setKeyContact(String keyContact) {
        this.keyContact = keyContact;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getAgreement() {
        return agreement;
    }

    public void setAgreement(Boolean agreement) {
        this.agreement = agreement;
    }
}
