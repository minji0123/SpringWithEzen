/*
 * EbookVO : Value Object
 * TABLE : EBOOK
 */
package ebooks;

public class EBookVO {
	private Integer serial;
	private String title;
	private String author;
	private Integer price;
	private Integer qty;
	
	EBookVO() {}
	
	public EBookVO(Integer serial, String title, String author, Integer price, Integer qty) {
		super();
		this.serial = serial;
		this.title = title;
		this.author = author;
		this.price = price;
		this.qty = qty;
	}
	
	public EBookVO(String serial, String title, String author, String price, String qty) {
		if(serial != null) {
			this.serial = Integer.parseInt(serial);
		}
		this.title = title;
		this.author = author;
		this.price = Integer.parseInt(price);
		this.qty = Integer.parseInt(qty);
	}

	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}


}
