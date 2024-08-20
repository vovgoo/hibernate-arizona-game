package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
public abstract class EditableEntity <T extends Serializable> implements BaseEntity<T> {

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
