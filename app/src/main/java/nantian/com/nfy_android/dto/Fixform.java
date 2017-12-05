package nantian.com.nfy_android.dto;

/**
 * Created by xiaochunyuan on 17/12/4.
 */

public abstract class Fixform {

      private String location ;
      private String phone;

    public Fixform(String location, String phone, String name) {
        this.location = location;
        this.phone = phone;
        this.name = name;
    }

    private String name;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public abstract void action();


    @Override
    public String toString() {


        return  name+"|"+location+"|"+phone;
    }
}
