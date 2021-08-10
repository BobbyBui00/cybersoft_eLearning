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


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
