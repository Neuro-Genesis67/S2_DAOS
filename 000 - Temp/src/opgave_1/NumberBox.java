package opgave_1;

public class NumberBox {

	int id;
	int ticket = 0;

	public NumberBox(int id, int ticket) {
		this.id = id;
		this.ticket = ticket;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

}
