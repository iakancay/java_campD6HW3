package kodlamaio.hrms.entities.concretes;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "candidates")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "candidate_id", referencedColumnName = "id")
public class Candidate extends User {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "nationalty_id")
	private String nationaltyId;

	@Column(name = "birth_date")
	private Date birthDate;



	
}
