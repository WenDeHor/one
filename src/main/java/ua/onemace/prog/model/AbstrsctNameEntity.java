package ua.onemace.prog.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class AbstrsctNameEntity extends AbstractBaseEntity {
    @NotBlank
    @Size(min = 2, max = 10)
    @Column(name = "name", nullable = false)
    protected String name;
}
