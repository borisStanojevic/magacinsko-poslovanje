package ftn.sit.pi.magacinskoposlovanje.domain;

import javax.persistence.*;

import ftn.sit.pi.magacinskoposlovanje.domain.enums.ERole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	private ERole name;
	
	

}
