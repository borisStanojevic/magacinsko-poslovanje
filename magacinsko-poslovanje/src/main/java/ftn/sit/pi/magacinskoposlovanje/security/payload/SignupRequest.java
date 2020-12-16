package ftn.sit.pi.magacinskoposlovanje.security.payload;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SignupRequest {
	
	
	 	@NotBlank
	    @Size(min = 3, max = 20)
	    private String username;
	 
	    @NotBlank
	    @Size(max = 50)
	    private String imePrezime;
	    
	    private Set<String> role;
	    
	    @NotBlank
	    @Size(min = 6, max = 40)
	    private String password;

}
