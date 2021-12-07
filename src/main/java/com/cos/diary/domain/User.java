package com.cos.diary.domain;

import java.util.Date;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import com.cos.diary.config.type.RoleType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // User 클래가 자동으로 MySql에 테이블 생성
@Data
@NoArgsConstructor // bean 생성자
@AllArgsConstructor
@Builder // 빌더 패턴
@Table(name = "User")
@DynamicInsert // null 것(role)은 제외하고 insert 그래야 role의 default값(user)이 들어감
public class User{
	
	@Id
    @GeneratedValue
    private Long admin_no;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleType role = RoleType.USER;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date create_date;
    @Temporal(TemporalType.DATE)
    @UpdateTimestamp
    private Date update_date;
    
    
}