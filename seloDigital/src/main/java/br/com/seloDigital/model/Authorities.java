package br.com.seloDigital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "authorities", uniqueConstraints = @UniqueConstraint(name="username_authority_unique" ,columnNames = { "username", "authority" }))
public class Authorities {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "username", foreignKey = @ForeignKey(name = "user_username_fk"))
	private User username;

	@NotNull
	@Column(name = "authority")
	private String authority;

	public User getUsername() {
		return username;
	}

	public void setUsername(User username) {
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
