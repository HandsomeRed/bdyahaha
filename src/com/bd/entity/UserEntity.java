package com.bd.entity;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

public class UserEntity {
    private int id;
    private String account;
    private String password;
    private String name;
    private String realName;
    private String sex;
    private Date birth;
    private String address;
    private String trade;
    private String position;
    private String introduction;
    private Date registDate;
    private String email;
    private String phone;
    private String userPic;
    private Integer fans;
    private String status;
//    private Set<AttentionFansEntity> attentionFansById;
//    private Set<AttentionFansEntity> attentionFansById_0;
//    private BlogMngEntity blogMng;
//    private Set<DetailEntity> detailsById;
//    private Set<FavoriteAttentionEntity> favoriteAttentionsById;
//    private Set<FavoriteListEntity> favoriteListsById;
//    private Set<InformationEntity> informationById;
//    private Set<InformationEntity> informationById_0;
//    private Set<ResourceMngEntity> resourceMngsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                Objects.equals(account, that.account) &&
                Objects.equals(password, that.password) &&
                Objects.equals(name, that.name) &&
                Objects.equals(realName, that.realName) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(birth, that.birth) &&
                Objects.equals(address, that.address) &&
                Objects.equals(trade, that.trade) &&
                Objects.equals(position, that.position) &&
                Objects.equals(introduction, that.introduction) &&
                Objects.equals(registDate, that.registDate) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(userPic, that.userPic) &&
                Objects.equals(fans, that.fans) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, password, name, realName, sex, birth, address, trade, position, introduction, registDate, email, phone, userPic, fans, status);
    }

//    public Set<AttentionFansEntity> getAttentionFansById() {
//        return attentionFansById;
//    }
//
//    public void setAttentionFansById(Set<AttentionFansEntity> attentionFansById) {
//        this.attentionFansById = attentionFansById;
//    }
//
//    public Set<AttentionFansEntity> getAttentionFansById_0() {
//        return attentionFansById_0;
//    }
//
//    public void setAttentionFansById_0(Set<AttentionFansEntity> attentionFansById_0) {
//        this.attentionFansById_0 = attentionFansById_0;
//    }
//
//    public BlogMngEntity getBlogMng() {
//        return blogMng;
//    }
//
//    public void setBlogMng(BlogMngEntity blogMngsById) {
//        this.blogMng = blogMngsById;
//    }
//
//    public Set<DetailEntity> getDetailsById() {
//        return detailsById;
//    }
//
//    public void setDetailsById(Set<DetailEntity> detailsById) {
//        this.detailsById = detailsById;
//    }
//
//    public Set<FavoriteAttentionEntity> getFavoriteAttentionsById() {
//        return favoriteAttentionsById;
//    }
//
//    public void setFavoriteAttentionsById(Set<FavoriteAttentionEntity> favoriteAttentionsById) {
//        this.favoriteAttentionsById = favoriteAttentionsById;
//    }
//
//    public Set<FavoriteListEntity> getFavoriteListsById() {
//        return favoriteListsById;
//    }
//
//    public void setFavoriteListsById(Set<FavoriteListEntity> favoriteListsById) {
//        this.favoriteListsById = favoriteListsById;
//    }
//
//    public Set<InformationEntity> getInformationById() {
//        return informationById;
//    }
//
//    public void setInformationById(Set<InformationEntity> informationById) {
//        this.informationById = informationById;
//    }
//
//    public Set<InformationEntity> getInformationById_0() {
//        return informationById_0;
//    }
//
//    public void setInformationById_0(Set<InformationEntity> informationById_0) {
//        this.informationById_0 = informationById_0;
//    }
//
//    public Set<ResourceMngEntity> getResourceMngsById() {
//        return resourceMngsById;
//    }
//
//    public void setResourceMngsById(Set<ResourceMngEntity> resourceMngsById) {
//        this.resourceMngsById = resourceMngsById;
//    }
}
