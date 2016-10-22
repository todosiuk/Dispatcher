package dispatcher.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.stereotype.Component;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 */
@Entity
@Table(name = "provider")
public class Provider implements Serializable {

	public Provider() {
	}

	public Provider(String providerName) {
	}

	public Provider(String providerName, List<Supply> supplyList) {
		this.providerName = providerName;
		this.supplyList = supplyList;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idprovider")
	private Integer idProvider;

	@Column(name = "name")
	private String providerName;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "provider")
	private List<Supply> supplyList = new ArrayList<Supply>();

	public Integer getIdProvider() {
		return idProvider;
	}

	public void setIdProvider(Integer idProvider) {
		this.idProvider = idProvider;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public List<Supply> getSupplyList() {
		return supplyList;
	}

	public void setSupplyList(List<Supply> supplyList) {
		this.supplyList = supplyList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProvider == null) ? 0 : idProvider.hashCode());
		result = prime * result + ((providerName == null) ? 0 : providerName.hashCode());
		result = prime * result + ((supplyList == null) ? 0 : supplyList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Provider)) {
			return false;
		}
		Provider other = (Provider) obj;
		if (idProvider == null) {
			if (other.idProvider != null) {
				return false;
			}
		} else if (!idProvider.equals(other.idProvider)) {
			return false;
		}
		if (providerName == null) {
			if (other.providerName != null) {
				return false;
			}
		} else if (!providerName.equals(other.providerName)) {
			return false;
		}
		if (supplyList == null) {
			if (other.supplyList != null) {
				return false;
			}
		} else if (!supplyList.equals(other.supplyList)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Provider " + this.idProvider + ", " + this.providerName + "," + this.supplyList;

	}

}
