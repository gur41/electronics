package project.clasess;

import javax.persistence.*;

//@Entity
//@Table(name = "property", schema = "logistics", catalog = "")
public class Property {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Basic
    @Column(name = "height", nullable = false, length = 255)
    private String height;

    @Basic
    @Column(name = "composition", nullable = false, length = 255)
    private String composition;



    @Basic
    @Column(name = "heights", nullable = false, length = 255)
    private String heights;

    @Basic
    @Column(name = "compositions", nullable = false, length = 255)
    private String compositions;

    public Property() {
    }

    public Property(String name, String height, String composition, String heights, String compositions) {
        this.name = name;
        this.height = height;
        this.composition = composition;
        this.heights = heights;
        this.compositions = compositions;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", composition='" + composition + '\'' +
                ", heights='" + heights + '\'' +
                ", compositions='" + compositions + '\'' +
                '}';
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getHeights() {
        return heights;
    }

    public void setHeights(String heights) {
        this.heights = heights;
    }

    public String getCompositions() {
        return compositions;
    }

    public void setCompositions(String compositions) {
        this.compositions = compositions;
    }
}