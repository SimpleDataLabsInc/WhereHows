package com.linkedin.metadata.dao;

import io.ebean.Model;
import io.ebean.annotation.Index;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "entity_attribute")
public class EbeanEntityAttribute extends Model {

    public static final String URN_COLUMN = "urn";
    public static final String ATTRIBUTE_COLUMN = "attribute";
    public static final String VALUE_COLUMN = "value";
    public static final String CREATED_ON_COLUMN = "createdOn";

    @Embeddable
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class PrimaryKey {
        @NonNull
        @Index
        @Column(name = URN_COLUMN, length = 500, nullable = false)
        private String urn;

        @NonNull
        @Index
        @Column(name = ATTRIBUTE_COLUMN, length = 200, nullable = false)
        private String attribute;
    }

    @NonNull
    @EmbeddedId
    @Index
    protected PrimaryKey key;

    @NonNull
    @Column(name = VALUE_COLUMN, length = 200, nullable = false)
    private long value;

    @NonNull
    @Column(name = CREATED_ON_COLUMN, nullable = false)
    private Timestamp createdOn;
}
