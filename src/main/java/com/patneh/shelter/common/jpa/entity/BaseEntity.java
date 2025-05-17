package com.patneh.shelter.common.jpa.entity;

import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class BaseEntity implements LongId {

  @Column(name = "uuid", updatable = false)
  private UUID uuid = UUID.randomUUID();

  public int hashCode() {
    return Objects.hash(uuid);
  }

  public boolean equals(Object that) {
    return this == that
        || that instanceof BaseEntity && Objects.equals(uuid, ((BaseEntity) that).uuid);
  }

}
