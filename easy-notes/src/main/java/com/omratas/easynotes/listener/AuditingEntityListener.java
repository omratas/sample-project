package com.omratas.easynotes.listener;

import com.omratas.easynotes.model.BaseEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.ZonedDateTime;

@Component
public class AuditingEntityListener {

    @PrePersist
    @PreUpdate
    public void setLastModifiedDate(BaseEntity entity) {
        if (StringUtils.isBlank(entity.getIdentifier())) {
            entity.setCreatedDate(ZonedDateTime.now());
        }
        entity.setLastModifiedDate(ZonedDateTime.now());
    }
}
