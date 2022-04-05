package com.example.project.entities;
import javax.persistence.*;

@Entity
@Table(name = "vital_signs")
public class VitalSign {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;

	    @Column(name = "vital_sign")
	    private String vitalSignName;

	    @Column(name = "value")
	    private double value;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "patientId")
	    private Patient patient;
	    
	    public VitalSign() {
	    	
	    }

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getVitalSignName() {
			return vitalSignName;
		}

		public void setVitalSignName(String vitalSignName) {
			this.vitalSignName = vitalSignName;
		}

		public double getValue() {
			return value;
		}

		public void setValue(double value) {
			this.value = value;
		}

		public Patient getPatient() {
			return patient;
		}

		public void setPatient(Patient patient) {
			this.patient = patient;
		}
	    
	

}
