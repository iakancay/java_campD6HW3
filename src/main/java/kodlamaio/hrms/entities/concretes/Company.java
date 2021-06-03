package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","advertisements"})
public class Company extends User {

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "company_url")
	private String companyUrl;

	@Column(name = "phone")
	private String phone;
	
	
	  @OneToMany(mappedBy="company") 
	  private List<JobAdvertisement> advertisements;
	 

	

	

}
