package project.last;

public class InfoNote {
    private Integer id;
    private String info;
    private String photo;
    private String name;
    private Double price;

    public InfoNote(String info, String photo, String name) {
        this.info = info;
        this.photo = photo;
        this.name = name;
    }

    public InfoNote() {
    }

    public InfoNote(Integer id, String info, String photo, String name, Double price) {
        this.id = id;
        this.info = info;
        this.photo = photo;
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
