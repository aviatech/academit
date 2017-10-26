/**
 * Created by Александр on 30.09.2017.
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Александр on 27.07.2017.
 */
public class Blur {
    public static void main(String[] args) throws IOException {
        // читаем картинку из файлу image.jpg в объект класса BufferedImage
        BufferedImage image = ImageIO.read(new File("image1.jpg"));
        WritableRaster raster = image.getRaster();

        // получаем ширину и высоту картинки
        int width = raster.getWidth();
        int height = raster.getHeight();

        BufferedImage imageOut = new BufferedImage(width, height, image.getType());
        WritableRaster rasterOut = imageOut.getRaster();

        final int COLORS_COUNT_IN_RGB = 3;
        final double PIXEL_COUNT = 9.0;

        int[] pixel = new int[COLORS_COUNT_IN_RGB];
        int[] pixelTopLeft = new int[COLORS_COUNT_IN_RGB];
        int[] pixelTopCenter = new int[COLORS_COUNT_IN_RGB];
        int[] pixelTopRight = new int[COLORS_COUNT_IN_RGB];
        int[] pixelLeft = new int[COLORS_COUNT_IN_RGB];
        int[] pixelBottomLeft = new int[COLORS_COUNT_IN_RGB];
        int[] pixelRight = new int[COLORS_COUNT_IN_RGB];
        int[] pixelBottomCenter = new int[COLORS_COUNT_IN_RGB];
        int[] pixelBottomRight = new int[COLORS_COUNT_IN_RGB];
        // цикл по строкам картинки
        for (int j = 1; j < height - 1; ++j) {
            for (int i = 1; i < width - 1; ++i) {

                raster.getPixel(i, j, pixel);

                raster.getPixel(i - 1, j - 1, pixelTopLeft);
                raster.getPixel(i - 1, j, pixelLeft);
                raster.getPixel(i - 1, j + 1, pixelBottomLeft);

                raster.getPixel(i, j - 1, pixelTopCenter);
                raster.getPixel(i, j + 1, pixelBottomCenter);

                raster.getPixel(i + 1, j - 1, pixelTopRight);
                raster.getPixel(i + 1, j, pixelRight);
                raster.getPixel(i + 1, j + 1, pixelBottomRight);

                for (int k = 0; k < COLORS_COUNT_IN_RGB; ++k) {
                    pixel[k] = (int) ((pixel[k] + pixelBottomCenter[k] + pixelBottomRight[k] + pixelLeft[k] + pixelBottomLeft[k] +
                            pixelRight[k] + pixelTopCenter[k] + pixelTopLeft[k] + pixelTopRight[k]) / PIXEL_COUNT);
                }
                rasterOut.setPixel(i, j, pixel);
            }
        }
        ImageIO.write(image, "png", new File("out.png"));
    }
}

