package ui.resource;

import java.util.EnumMap;

import util.ImageLoader;
import java.awt.Image;

public class ResourceManager {
    private final EnumMap<ImageAsset, Image> images;

    public static class InstanceHolder {
        private InstanceHolder() { }
        static final ResourceManager instance = new ResourceManager();
    }

    public ResourceManager() {
        images = new EnumMap<>(ImageAsset.class);
        loadImages();
    }

    private static ResourceManager getInstance() {
        return InstanceHolder.instance;
    }

    public void loadImages() {
        images.put(ImageAsset.GRASS, loadImage("grass.png"));
        images.put(ImageAsset.BLOCK, loadImage("Block.png"));
        images.put(ImageAsset.PLAYER_UP, loadImage("b1.png"));
        images.put(ImageAsset.PLAYER_RIGHT, loadImage("b2.png"));
        images.put(ImageAsset.PLAYER_DOWN, loadImage("b3.png"));
        images.put(ImageAsset.PLAYER_LEFT, loadImage("b4.png"));
        
        images.put(ImageAsset.ENEMY_UP, loadImage("r1.png"));
        images.put(ImageAsset.ENEMY_RIGHT, loadImage("r2.png"));
        images.put(ImageAsset.ENEMY_DOWN, loadImage("r3.png"));
        images.put(ImageAsset.ENEMY_LEFT, loadImage("r4.png"));
        
        images.put(ImageAsset.HEART_UI, loadImage("heart_ui.png"));
        images.put(ImageAsset.HEALTH, loadImage("heart.png"));
        
    }

    public Image loadImage(String path) {
        return new ImageLoader().load("assets/" + path);
    }

    public static Image getAsset(ImageAsset name) {
        return getInstance().images.get(name);
    }
}