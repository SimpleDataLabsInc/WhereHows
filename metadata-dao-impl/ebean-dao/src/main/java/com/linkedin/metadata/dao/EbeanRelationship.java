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
@Table(name = "relationship")
public class EbeanRelationship extends Model {

    public static final String RELATION_COLUMN = "relation";
    public static final String SOURCEURN_COLUMN = "sourceurn";
    public static final String DESTURN_COLUMN = "desturn";
    public static final String CREATED_ON_COLUMN = "createdOn";

    @Embeddable
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class PrimaryKey {
        @NonNull
        @Index
        @Column(name = RELATION_COLUMN, length = 200, nullable = false)
        private String relation;

        @NonNull
        @Index
        @Column(name = SOURCEURN_COLUMN, length = 500, nullable = false)
        private String sourceurn;

        @NonNull
        @Index
        @Column(name = DESTURN_COLUMN, length = 500, nullable = false)
        private String desturn;
    }

    @NonNull
    @EmbeddedId
    @Index
    protected PrimaryKey key;

    @NonNull
    @Column(name = CREATED_ON_COLUMN, nullable = false)
    private Timestamp createdOn;
}
