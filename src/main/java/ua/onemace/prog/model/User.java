package ua.onemace.prog.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Range;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id"}, name = "unique_user")})
public class User extends AbstrsctNameEntity {

    @Column(name = "soname", nullable = false)
    @NotBlank
    @Size(min = 2, max = 50)
    private String soname;

    @Column(name = "soname", nullable = false, unique = true)
    @NotBlank
    @Email
    @Size(min = 2, max = 50)
    private String emale;

    @Column(name = "fone_namber", nullable = false)
    @Range(min = 6, max = 10, message = "format 068 123 45 67")
    private Integer fone;

    @Column(name = "adres", nullable = false)
    @Range(min = 2, max = 30, message = "address of residence")
    private Integer adres;

    @Column(name = "age", nullable = false)
    @Range(min = 1, max = 30, message = "the owner's age")
    private Integer age;

    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    @BatchSize(size = 200)
    private Set<Role> roles;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @OrderBy("name DESC")
    protected List<Dogs> dogsList;

       public User() {
    }

    public User(Integer id, String name, String soname, String emale, Integer fone, Integer adres, Integer age, Collection<Role> roles) {
        super(id, name);
        this.soname=soname;
        this.emale=emale;
        this.fone=fone;
        this.adres=adres;
        this.age=age;
        setRoles(roles);
    }

    private void setRoles(Collection<Role> roles) {
           this.roles= CollectionUtils.isEmpty(roles)? EnumSet.noneOf(Role.class):EnumSet.copyOf(roles);
    }

    public String getSoname() {
        return soname;
    }

    public void setSoname(String soname) {
        this.soname = soname;
    }

    public String getEmale() {
        return emale;
    }

    public void setEmale(String emale) {
        this.emale = emale;
    }

    public Integer getFone() {
        return fone;
    }

    public void setFone(Integer fone) {
        this.fone = fone;
    }

    public Integer getAdres() {
        return adres;
    }

    public void setAdres(Integer adres) {
        this.adres = adres;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Dogs> getDogsList() {
        return dogsList;
    }

    public void setDogsList(List<Dogs> dogsList) {
        this.dogsList = dogsList;
    }

    @Override
    public String toString() {
        return "User{" +
                "soname='" + soname + '\'' +
                ", emale='" + emale + '\'' +
                ", fone=" + fone +
                ", adres=" + adres +
                ", age=" + age +
                ", roles=" + roles +
                ", dogsList=" + dogsList +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return soname.equals(user.soname) &&
                emale.equals(user.emale) &&
                fone.equals(user.fone) &&
                adres.equals(user.adres) &&
                age.equals(user.age) &&
                roles.equals(user.roles) &&
                dogsList.equals(user.dogsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), soname, emale, fone, adres, age, roles, dogsList);
    }
}
