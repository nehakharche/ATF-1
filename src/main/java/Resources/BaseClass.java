package Resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;


public class BaseClass {
	public WebDriver driver;
	FileInputStream io;
	public Properties prop;
	
	public void initializeDriver() throws IOException
	{
		io=new FileInputStream("C:\\Users\\Neha Kolte\\eclipse-workspace\\ATF\\src\\main\\java\\Resources\\data.properties");
		prop=new Properties();
		prop.load(io);
		String strBrowserName=prop.getProperty("browser");
		if(strBrowserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(strBrowserName.equalsIgnoreCase("firefox"))
			
		{
			driver=new FirefoxDriver();
		}else if(strBrowserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
	}
    @BeforeClass
    public void launchBrowser() throws IOException
    {
    	initializeDriver();
    	String URL=prop.getProperty("BaseURL");
    	driver.get(URL);
    }
    public void setProperty(String Key,String Value) throws IOException
    {
    	System.out.println("Set Property Value"+ Key +""+Value);
        // 4. Save properties to the same file (use FileOutputStream!)
        FileOutputStream out = new FileOutputStream("C:\\Users\\Neha Kolte\\eclipse-workspace\\ATF\\src\\main\\java\\Resources\\data.properties");
      
    	prop.setProperty(Key, Value);
    	prop.store(out, "Write data");
    	out.close();
    }
    public String getProperty(String Key)
    {
    	return prop.getProperty(Key);
    }
}
