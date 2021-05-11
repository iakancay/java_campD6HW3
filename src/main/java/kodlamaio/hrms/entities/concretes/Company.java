package kodlamaio.hrms.entities.concretes;

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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "companies")
@PrimaryKeyJoinColumn(name = "company_id", referencedColumnName = "id")
public class Company extends User {

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "company_url")
	private String companyUrl;

	@Column(name = "phone")
	private String phone;

	

	

}
