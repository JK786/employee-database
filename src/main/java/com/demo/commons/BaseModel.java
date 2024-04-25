package com.demo.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Getter
@SuperBuilder(toBuilder = true)
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseModel {

    @Column(name = "created_on")
//    @CreationTimestamp
    private Instant createdOn;

    @Column(name = "updated_on")
//    @UpdateTimestamp
    private Instant updatedOn;

}
