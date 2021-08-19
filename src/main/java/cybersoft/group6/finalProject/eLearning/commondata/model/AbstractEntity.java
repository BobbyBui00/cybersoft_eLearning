package cybersoft.group6.finalProject.eLearning.commondata.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import cybersoft.group6.finalProject.eLearning.util.DateUtils;
import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
public class AbstractEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	protected Long id;
	
	@Version
	protected int version;
	
	@CreatedBy
	protected String createdBy;
	
	@LastModifiedBy
	protected String updatedBy;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = DateUtils.DATE_FORMAT)
	@DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
	@CreatedDate
	@Column(name="created_at",nullable = false,updatable = false)
	protected LocalDateTime createdAt;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern = DateUtils.DATE_FORMAT)
	@LastModifiedDate
	@DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
	@Column(name="updated_at",nullable = false)
	protected LocalDateTime updatedAt;
}
