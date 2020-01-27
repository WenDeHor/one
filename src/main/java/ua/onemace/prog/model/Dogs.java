package ua.onemace.prog.model;

import org.ehcache.shadow.org.terracotta.context.annotations.ContextAttribute;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "dogs", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id"}, name = "dogs_unique_user_datetime_idx")})
public class Dogs extends AbstrsctNameEntity {

    @Column(name = "discription", nullable = false)
    @NotBlank(message = "General characteristics of the animal")
    @Size(min = 2, max = 50)
    private String discription;

    @Column(name = "age", nullable = false)
    @Range(min = 2, max = 30)
    private Integer age;

    @Column(name = "color", nullable = false)
    @NotBlank(message = "The color of the animal")
    @Size(min = 2, max = 50)
    private String color;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    public Dogs() {
    }

    public Dogs(Integer id, String name, String discription, Integer age, String color) {
        super(id, name);
        this.discription = discription;
        this.age = age;
        this.color = color;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Dogs{" +
                "discription='" + discription + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dogs dogs = (Dogs) o;
        return discription.equals(dogs.discription) &&
                age.equals(dogs.age) &&
                color.equals(dogs.color) &&
                user.equals(dogs.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discription, age, color, user);
    }
}
