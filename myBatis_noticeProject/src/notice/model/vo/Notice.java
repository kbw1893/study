package notice.model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Notice implements java.io.Serializable{
	private int noticeNo;
	private String noticeTitle;
	private String noticeWriter;
	private Date noticeDate;
	private String noticeContent;
	
	public Notice(){}

	public Notice(int noticeNo, String noticeTitle, String noticeWriter,
			Date noticeDate, String noticeContent) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.noticeDate = noticeDate;
		this.noticeContent = noticeContent;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	
	@Override
	public String toString(){
		return noticeNo + ", " + noticeTitle + ", " + 
		noticeWriter + ", " + 
		new SimpleDateFormat("YYYY-mm-dd hh24:MM:dd").format(noticeDate)
		+ noticeContent;
	}
}
