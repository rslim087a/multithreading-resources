import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;

public class ImageToGrayscale {

    public static void main(String[] args) throws Exception {
        File inputFile = new File("beach.png"); // Input file
        File outputFile = new File("beach_grayscale.png"); // Output file

        try {
            BufferedImage image = ImageIO.read(inputFile);
            convertToGrayscale(image);

            ImageIO.write(image, "png", outputFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    // private static void convertToGrayscaleConcurrently(BufferedImage image, int numberOfThreads) throws InterruptedException {


        
    // }


    private static void convertToGrayscale(BufferedImage image) {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                Color color = new Color(rgb, true);
    
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                
                // Compute the average of red, green, and blue (simple grayscale)
                int gray = (red + green + blue) / 3;
                
                // Create new grayscale color
                Color grayColor = new Color(gray, gray, gray, color.getAlpha());
                image.setRGB(x, y, grayColor.getRGB());
            }
        }
    }
}
