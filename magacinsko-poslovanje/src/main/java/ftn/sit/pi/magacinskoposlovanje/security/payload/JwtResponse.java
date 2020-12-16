package ftn.sit.pi.magacinskoposlovanje.security.payload;

import java.util.List;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
public class JwtResponse {

	private String token;

	private Integer id;
	private String username;
	private List<String> roles;
	
	
	public JwtResponse(String token, Integer id, String username, List<String> roles) {
		super();
		this.token = token;
		this.id = id;
		this.username = username;
		this.roles = roles;
	}
	
	
	
}
