package com.springstudy.shop.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

// 공통 속성 정의 (선언) 엔티티
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
abstract class BasicEntity {

    @CreatedBy
    @Column(name = "regdate",updatable = false)
    private LocalDateTime regDate;
    @LastModifiedDate
    @Column(name = "moddate")
    private LocalDateTime modDate;


}
