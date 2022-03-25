package createExcelReport;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.Font;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class CreateReport {

	private OutputStream os = null;
	public static String subFix = "";

	public void excelWrite(List<ResultObject> list) {

		try {
//			Date dt = new Date();
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'_'HHmmss");
//			subFix = "_" + simpleDateFormat.format(dt);

			this.os = new FileOutputStream("./test-output/result" + subFix + ".xls");
			// 创建一个可写的Workbook
			WritableWorkbook wwb = Workbook.createWorkbook(os);

			// 创建一个可写的sheet,第一个参数是名字,第二个参数是第几个sheet
			WritableSheet sheet = wwb.createSheet("Report", 0);

			sheet.setColumnView(0, 20);
			sheet.setColumnView(1, 40);
			sheet.setColumnView(2, 40);
			sheet.setColumnView(3, 10);
			sheet.setColumnView(4, 30);
			sheet.setColumnView(5, 10);
			sheet.setColumnView(6, 10);

			// 设置Header字体;
			WritableFont headerFont = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
			WritableCellFormat headerFormat = new WritableCellFormat(headerFont);

			// 设置Fail字体颜色;
			WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat cellFormat = new WritableCellFormat(cellFont);
			WritableCellFormat cellFormat1 = new WritableCellFormat();
			cellFormat1.setWrap(true);

			String[] title = { "Test Name", "Exp Value", "Act Value", "Result", "Comments", "ReviewBy", "Next To" };
			for (int i = 0; i < title.length; i++) {
				Label lable = new Label(i, 0, title[i], headerFormat);
				sheet.addCell(lable);

			}

			for (int i = 0; i < list.size(); i++) {
				ResultObject result = (ResultObject) list.get(i);

				// 创建一个Label,第一个参数是x轴,第二个参数是y轴,第三个参数是内容,第四个参数可选,指定类型
				Label label1 = new Label(0, i + 1, result.getTestName(), cellFormat1);
				Label label2 = new Label(1, i + 1, result.getExpValue(), cellFormat1);
				Label label3 = new Label(2, i + 1, result.getActValue(), cellFormat1);
				Label label4 = new Label(3, i + 1, result.getResult(), cellFormat1);
				Label label5 = new Label(4, i + 1, result.getComments(), cellFormat1);
				// 设置Fail Result 颜色
				if (result.getResult().equals("FAIL") | result.getResult().equals("SKIP"))
					label4 = new Label(3, i + 1, result.getResult(), cellFormat);

				// 把label加入sheet对象中
				sheet.addCell(label1);
				sheet.addCell(label2);
				sheet.addCell(label3);
				sheet.addCell(label4);
				sheet.addCell(label5);

			}
			// 保存到Workbook中
			wwb.write();
			// 只有执行close时才会写入到文件中,可能在close方法中执行了io操作
			wwb.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 实现文件复制的函数
	 * 
	 * 采用二进制流的形式来实现文件的读写
	 */
	public void fileCopy(File srcFile, File destFile) throws Exception {
		InputStream src = new BufferedInputStream(new FileInputStream(srcFile));
		OutputStream dest = new BufferedOutputStream(new FileOutputStream(destFile));

		byte[] trans = new byte[1024];

		int count = -1;

		while ((count = src.read(trans)) != -1) {
			dest.write(trans, 0, count);
		}

		dest.flush();
		src.close();
		dest.close();
	}

	/**
	 * 备份文件，在原文件目录下创建备份文件，命名为 原文件名.bak
	 * 
	 * @param templateFile
	 *            需要备份的函数
	 * @return true 成功，false 失败
	 */
	public boolean backupTemplateFile() {
		boolean flag = true;

		File srcFile = new File("./test-output");

		// 创建备份文件
		File backUpFile = new File("./test-output_" + subFix);
		try {
			if (backUpFile.createNewFile()) {
				// 创建备份文件成功，进行文件复制
				fileCopy(srcFile, backUpFile);
			}
		} catch (Exception e) {
			flag = false;
			System.out.println("备份文件失败");
		}

		return flag;
	}

	public static void main(String[] args) {
		CreateReport createReport = new CreateReport();
		ReadXML readXML = new ReadXML();
		createReport.excelWrite(readXML.getrList());
		// createReport.backupTemplateFile();

	}

}