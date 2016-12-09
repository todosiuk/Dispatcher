package dispatcher.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "supply")
public class Supply implements Serializable {

	public Supply(String carNumber, String driverName, String phone, String product, String vendorDocument,
			String documentReceiving, String department, LocalDate arrivalDate, String storekeeper, String dispatcher,
			Provider provider) {
		this.carNumber = carNumber;
		this.driverName = driverName;
		this.phone = phone;
		this.product = product;
		this.vendorDocument = vendorDocument;
		this.documentReceiving = documentReceiving;
		this.department = department;
		this.arrivalDate = arrivalDate;
		this.storekeeper = storekeeper;
		this.dispatcher = dispatcher;
		this.provider = provider;
	}

	public Supply() {
	}

	public Supply(String string, String string2, String string3, String string4, String string5, String string6,
			LocalDate now, String string7, String string8, Provider p) {
	}

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idsupply")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSupply;

	@Column(name = "carNumber")
	private String carNumber;

	@Column(name = "driverName")
	private String driverName;

	@Column(name = "phone")
	private String phone;

	@Column(name = "product")
	private String product;

	@Column(name = "vendorDocument")
	private String vendorDocument;

	@Column(name = "documentReceiving")
	private String documentReceiving;

	@Column(name = "department")
	private String department;

	@Column(name = "arrivalDate", columnDefinition = "TIMESTAMP")
	private LocalDate arrivalDate;

	@Column(name = "storekeeper")
	private String storekeeper;

	@Column(name = "dispatcher")
	private String dispatcher;

	@ManyToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "provider_idprovider")
	private Provider provider;

	public Integer getIdSupply() {
		return idSupply;
	}

	public void setIdSupply(Integer idSupply) {
		this.idSupply = idSupply;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getVendorDocument() {
		return vendorDocument;
	}

	public void setVendorDocument(String vendorDocument) {
		this.vendorDocument = vendorDocument;
	}

	public String getDocumentReceiving() {
		return documentReceiving;
	}

	public void setDocumentReceiving(String documentReceiving) {
		this.documentReceiving = documentReceiving;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getStorekeeper() {
		return storekeeper;
	}

	public void setStorekeeper(String storekeeper) {
		this.storekeeper = storekeeper;
	}

	public String getDispatcher() {
		return dispatcher;
	}

	public void setDispatcher(String dispatcher) {
		this.dispatcher = dispatcher;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
		result = prime * result + ((carNumber == null) ? 0 : carNumber.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((dispatcher == null) ? 0 : dispatcher.hashCode());
		result = prime * result + ((documentReceiving == null) ? 0 : documentReceiving.hashCode());
		result = prime * result + ((driverName == null) ? 0 : driverName.hashCode());
		result = prime * result + ((idSupply == null) ? 0 : idSupply.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((provider == null) ? 0 : provider.hashCode());
		result = prime * result + ((storekeeper == null) ? 0 : storekeeper.hashCode());
		result = prime * result + ((vendorDocument == null) ? 0 : vendorDocument.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supply other = (Supply) obj;
		if (arrivalDate == null) {
			if (other.arrivalDate != null)
				return false;
		} else if (!arrivalDate.equals(other.arrivalDate))
			return false;
		if (carNumber == null) {
			if (other.carNumber != null)
				return false;
		} else if (!carNumber.equals(other.carNumber))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (dispatcher == null) {
			if (other.dispatcher != null)
				return false;
		} else if (!dispatcher.equals(other.dispatcher))
			return false;
		if (documentReceiving == null) {
			if (other.documentReceiving != null)
				return false;
		} else if (!documentReceiving.equals(other.documentReceiving))
			return false;
		if (driverName == null) {
			if (other.driverName != null)
				return false;
		} else if (!driverName.equals(other.driverName))
			return false;
		if (idSupply == null) {
			if (other.idSupply != null)
				return false;
		} else if (!idSupply.equals(other.idSupply))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (provider == null) {
			if (other.provider != null)
				return false;
		} else if (!provider.equals(other.provider))
			return false;
		if (storekeeper == null) {
			if (other.storekeeper != null)
				return false;
		} else if (!storekeeper.equals(other.storekeeper))
			return false;
		if (vendorDocument == null) {
			if (other.vendorDocument != null)
				return false;
		} else if (!vendorDocument.equals(other.vendorDocument))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Supply [idSupply=" + idSupply + ", carNumber=" + carNumber + ", driverName=" + driverName + ", phone="
				+ phone + ", product=" + product + ", vendorDocument=" + vendorDocument + ", documentReceiving="
				+ documentReceiving + ", department=" + department + ", arrivalDate=" + arrivalDate + ", storekeeper="
				+ storekeeper + ", dispatcher=" + dispatcher + ", provider=" + provider + "]";
	}
}
