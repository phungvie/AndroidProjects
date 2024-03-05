package com.example.lap2_end.model;

public class Contact {
    /*
-	Id: Kiểu int
-	Name: Kiểu String
-	PhoneNumber: Kiểu String
-	Status: Kiểu boolean (true nếu phần tử dược chọn, false nếu ngược lại)
*/
    public static final String imgViet = "https://i.pinimg.com/564x/94/9b/8d/949b8d8d9229693ba9d53b054b738e2a.jpg";
    Integer Id;
    String Name;
    String PhoneNumber;
    Boolean Status;
    String img;

    public Contact() {
    }

    public Contact(Integer id, String name, String phoneNumber, Boolean status, String img) {
        Id = id;
        Name = name;
        PhoneNumber = phoneNumber;
        Status = status;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Status=" + Status +
                '}';
    }
}
