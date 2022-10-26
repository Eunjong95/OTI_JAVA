package eunjong_qnas;

import java.util.Date;

import lombok.Data;

@Data
public class QcreateDTO {
	private int qna_no;
	private String qna_category;
	private String user_id;
	private String qna_title;
	private String qna_content;
	private Date qna_date;
	private int qna_view;
}
