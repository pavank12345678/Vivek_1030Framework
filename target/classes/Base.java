package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver driver;
	public Properties prop;

	public void driverint() throws IOException {
		properties_load();
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}
	}

	public void properties_load() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

	}

	public List<String> ExcelDataImport(String Modules) throws IOException {
		List<String> a = new ArrayList<String>();
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\App_data.xlsx";
		FileInputStream Fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(Fis);
		int getnoofsheets = workbook.getNumberOfSheets();
		System.out.println("Number of sheets is " + getnoofsheets);
		for (int i = 0; i < getnoofsheets; i++) {
			XSSFSheet sheet = workbook.getSheetAt(i);
			String sheetname = sheet.getSheetName();
			System.out.println("Sheet name is " + sheetname);
			if (sheetname.equalsIgnoreCase("system1")) {
				System.out.println("your Sheet is present at " + i + "th index");
				Iterator<Row> rows = sheet.iterator();
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();
				int k = 0;
				int coloumn = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					System.out.println(value.getStringCellValue());
					if (value.getStringCellValue().equalsIgnoreCase("Modules")) {
						coloumn = k;
						System.out.println("i found the modules" + coloumn + "th column in the first row");

					}
					k++;

				}
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(coloumn).getStringCellValue().trim().equalsIgnoreCase(Modules)) {
						System.out.println("Inside login");
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next();
							CellType type = c.getCellType();

							switch (type) {
							case NUMERIC:
								a.add(Double.toString(c.getNumericCellValue()));
								System.out.println(Double.toString(c.getNumericCellValue()));
								break;

							case STRING:
								a.add(c.getStringCellValue());
								System.out.println(c.getStringCellValue());
								break;
							default:
								throw new RuntimeException("There is not this type of value");

							}
						}
					}
				}
			}
		}
		System.out.println("First value of list" + a.get(2));
		return a;
	}
	
	public void getscreenshot(String tcname) throws IOException
	{
		TakesScreenshot ts=((TakesScreenshot)driver);
		File Source=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File("E:\\"+tcname+".png");
		FileUtils.copyFile(Source, destFile);
	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
	}
}