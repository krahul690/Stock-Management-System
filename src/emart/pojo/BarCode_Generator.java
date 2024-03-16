/**
 * BarCode_Generator class generates Code128 barcodes using the Barcode4J library.
 * It provides a method, createImage, to create a Code128 barcode image and save it to a specified directory.
 * The generated barcode is saved in PNG format with user-specified image name and barcode data.
 *
 * Usage Example:
 * BarCode_Generator.createImage("MyBarcode", "123456789");
 *
 * Dependencies:
 * This class requires the Barcode4J library for Code128 barcode generation.
 * Make sure to include the necessary Barcode4J JAR files in your project.
 *
 * @author Rahul
 * @version 1.0
 */
 
package emart.pojo;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

public class BarCode_Generator {
    public static void createImage(String image_name,String myString){
        try{
            Code128Bean code128 = new Code128Bean();
            code128.setHeight(15f); //15 pixel height
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos,"image/x-png",300,BufferedImage.TYPE_BYTE_BINARY,false,0);
            
            //instance method to generate barcode
            code128.generateBarcode(canvas,myString);
            canvas.finish();
            
            String userdir  =System.getProperty("user.dir");
            System.out.println("user dir is: "+userdir);
            FileOutputStream fos = new FileOutputStream(userdir+"\\Barcode\\"+image_name);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
                 
            
        }
        catch(IOException e){
            System.out.println("Exception in Barcode gen:"+e.getMessage());
        }
    }
}
