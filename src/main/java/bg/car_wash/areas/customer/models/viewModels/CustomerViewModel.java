package bg.car_wash.areas.customer.models.viewModels;

import com.google.gson.annotations.Expose;

import java.util.Date;

public class CustomerViewModel {

	@Expose
	private Long id;

	@Expose
	private String name;

	@Expose
	private String phoneNumber;

	@Expose
	private Date date;

	@Expose
	private int discount;

	public CustomerViewModel() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDiscount() {
		return this.discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
}
