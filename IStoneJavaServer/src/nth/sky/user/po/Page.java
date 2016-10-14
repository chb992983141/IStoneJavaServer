package nth.sky.user.po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Page {
	@Id
	public String page;

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
}
