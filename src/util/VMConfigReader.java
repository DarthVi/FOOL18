package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class VMConfigReader
{
    private Properties prop;
    private InputStream input = null;

    public VMConfigReader(String path)
    {
        prop = new Properties();

        try
        {
            input = new FileInputStream(path);

            // load a properties file
            prop.load(input);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public int getMemorySize()
    {
        return Integer.parseInt(prop.getProperty("memorysize"));
    }

    public int getCodeSize()
    {
        return Integer.parseInt(prop.getProperty("codesize"));
    }

    public int getHeapStart()
    {
        return Integer.parseInt(prop.getProperty("heapstart"));
    }

    public void closePropFile()
    {
        if(input != null)
        {
            try
            {
                input.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
