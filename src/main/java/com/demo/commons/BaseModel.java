package com.demo.commons;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseModel {

    @Column(name = "created_on", updatable = false)
    @CreationTimestamp
    private Instant createdOn;

    @Column(name = "updated_on")
    @UpdateTimestamp
    private Instant updatedOn;

}
