package br.nemo.ufes.scap.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Permission")
public class Permission {

	@Id
	@Column(name = "PermissionName")
	private String PermissionName;

	public String getPermissionName() {
		return PermissionName;
	}

	public void setPermissionName(String permissionName) {
		PermissionName = permissionName;
	}

}