package cybersoft.group6.finalProject.eLearning.role.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import cybersoft.group6.finalProject.eLearning.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role extends AbstractEntity{

	private String roleId;
	private String roleName;
	
	public Role roleId(String roleId) {
		this.roleId=roleId;
		return this;
	}
	
	public Role roleName(String roleName)
	{
		this.roleName=roleName;
		return this;
	}
}
