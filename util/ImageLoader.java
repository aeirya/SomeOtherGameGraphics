package util;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
    
    public Image load(String path) {
        final File file = new File(path);
        return loadImage(file);
    }

    private Image loadImage(File file) {
        Image image;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            image = null;
        }
        return image;
    }

}