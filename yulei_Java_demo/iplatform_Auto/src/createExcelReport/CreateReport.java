package createExcelReport;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.common.collect.Table.Cell;

import jxl.Hyperlink;
import jxl.SheetSettings;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class CreateReport {

	private OutputStream os = null;
	private static String subFix = "";
	public String testNgNm = "";

	public void excelWrite(List<ResultObject> list) {
		String backupFolder = testNgNm + getSubFix() + "_test-output";

		try {

			this.os = new FileOutputStream("./results/" + testNgNm + getSubFix() + ".xls");
			// Create Workbook
			WritableWorkbook wwb = Workbook.createWorkbook(os);

			// Create sheet
			WritableSheet sheet = wwb.createSheet("Report", 0);
			SheetSettings settings = sheet.getSettings();
			settings.setVerticalFreeze(1);

			sheet.setColumnView(0, 30);
			sheet.setColumnView(1, 8);
			sheet.setColumnView(2, 20);
			sheet.setColumnView(3, 40);
			sheet.setColumnView(4, 40);
			sheet.setColumnView(5, 8);
			sheet.setColumnView(6, 30);
			sheet.setColumnView(7, 10);

			// Header;
			WritableFont headerFont = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
			WritableCellFormat headerFormat = new WritableCellFormat(headerFont);

			// Result - Fail: Format RED;
			WritableFont cellFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.RED);
			WritableCellFormat cellFormat = new WritableCellFormat(cellFont);

			WritableCellFormat cellFormat1 = new WritableCellFormat();
			cellFormat1.setWrap(true);

			String[] title = { "Test Name", "Line #", "Gui", "Exp Value", "Act Value", "Result", "Comments", "ReviewBy",
					"Next To" };
			for (int i = 0; i < title.length; i++) {
				Label lable = new Label(i, 0, title[i], headerFormat);
				sheet.addCell(lable);

			}

			for (int i = 0; i < list.size(); i++) {
				ResultObject result = (ResultObject) list.get(i);

				// Input value to sheet cell.
				Label label1 = new Label(0, i + 1, result.getTestName(), cellFormat1);
				Label label2 = new Label(1, i + 1, result.getLineNum(), cellFormat1);
				Label label3 = new Label(2, i + 1, result.getTestPoint(), cellFormat1);
				Label label4 = new Label(3, i + 1, result.getExpValue(), cellFormat1);

				// For Fail and Skip, format Result.
				Label label6 = null;
				if (result.getResult().equals("FAIL") | result.getResult().equals("SKIP"))
					label6 = new Label(5, i + 1, result.getResult(), cellFormat);
				else
					label6 = new Label(5, i + 1, result.getResult(), cellFormat1);

				Label label7 = new Label(6, i + 1, result.getComments(), cellFormat1);

				// add label to cell
				sheet.addCell(label1);
				sheet.addCell(label2);
				sheet.addCell(label3);
				sheet.addCell(label4);

//				For image and Link
				if (result.getTestPoint().indexOf("CheckImg")!=-1) {
					String toPicFile = result.getActValue().replace("test-output", "results\\"+backupFolder);
					copyFile(result.getActValue().replace("\\", "/"), toPicFile.replace("\\", "/"));
					copyFile(result.getActValue().replace("\\", "/").replace("_diff", ""), toPicFile.replace("\\", "/").replace("_diff", ""));
					String diffImg = result.getActValue().replace(".\\test-output\\ActualImgs\\", "");
					String formu = "HYPERLINK(\"" + toPicFile.replace(".\\results\\", "") + "\",\"" + diffImg + "\")";
					Formula formula = new Formula(4, i + 1, formu);
					sheet.addCell(formula);
				} else {
					Label label5 = new Label(4, i + 1, result.getActValue(), cellFormat1);

					sheet.addCell(label5);
				}
				
				sheet.addCell(label6);
				sheet.addCell(label7);

			}
			wwb.write();
			wwb.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Copy Folder
	 * 
	 * @param oldPath
	 *            String /abc
	 * @param newPath
	 *            String /abc/ffe
	 * @return boolean
	 */
	public void copyFolder(String oldPath, String newPath) {

		try {
			(new File(newPath)).mkdirs(); // Create folder
											
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}

				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath + "/" + (temp.getName()).toString());

					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();

				}
				if (temp.isDirectory()) {//Folder: now only copy Actual Images, then later will copy the diff pic.
					if (file[i].equals("ActualImgs")) {
						(new File(newPath + "/" + file[i])).mkdirs();
					} else
						copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);

				}
			}
		} catch (Exception e) {
			System.out.println("Copy folder to failed");
			e.printStackTrace();

		}

	}

	// Copy File
	public void copyFile(String oldPath, String newPath) {

		try {
			File temp = null;
			temp = new File(oldPath);

			FileInputStream input = new FileInputStream(temp);
			FileOutputStream output = new FileOutputStream(newPath);

			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = input.read(b)) != -1) {
				output.write(b, 0, len);
			}
			output.flush();
			output.close();
			input.close();

		} catch (Exception e) {
			System.out.println("Copy file " + oldPath + " to failed!");
			e.printStackTrace();

		}

	}

	// Set subFix.
	public void setSubFix() {
		Date dt = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'_'HHmmss");
		CreateReport.subFix = "_" + simpleDateFormat.format(dt);

	}
	
	public static String getSubFix() {
		return subFix;
	}
	

	public static void main(String[] args) {

		CreateReport createReport = new CreateReport();
		createReport.setSubFix();
		ReadXML readXML = new ReadXML();
		createReport.testNgNm = readXML.ReadXML();
		createReport.copyFolder("./test-output", "./results/" + createReport.testNgNm + getSubFix() + "_test-output");
		createReport.excelWrite(readXML.getrList());
		try {
			File results = new File("./results");
			java.awt.Desktop.getDesktop().open(results);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}