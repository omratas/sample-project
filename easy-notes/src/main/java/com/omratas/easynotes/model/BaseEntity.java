package com.omratas.easynotes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.omratas.easynotes.listener.AuditingEntityListener;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.ZonedDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity extends IdEntity {
    @Version
    @Column(name = "row_version")
    protected Long rowVersion;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    protected ZonedDateTime createdDate = ZonedDateTime.now();

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    protected ZonedDateTime lastModifiedDate = ZonedDateTime.now();

    public Long getRowVersion() {
        return rowVersion;
    }

    public void setRowVersion(Long rowVersion) {
        this.rowVersion = rowVersion;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public ZonedDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equal(rowVersion, that.rowVersion) &&
                Objects.equal(createdDate, that.createdDate) &&
                Objects.equal(lastModifiedDate, that.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), rowVersion, createdDate, lastModifiedDate);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("rowVersion", rowVersion)
                .add("identifier", identifier)
                .toString();
    }
}
