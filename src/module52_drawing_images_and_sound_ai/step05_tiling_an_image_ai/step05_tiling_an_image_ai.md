> [!info] AI-Generated

# Tiling an image

Wrapping paper, wallpaper and tiled floors repeat one small picture over and over. Each copy is a **tile**, and putting them side by side is **tiling**.

## Repeating with the remainder

An image of 4 tiles across and 3 down is 4 times as wide as the tile and 3 times as high. Which pixel of the tile does pixel (x, y) of the big image show? With a tile `w` pixels wide, x from 0 to w - 1 is in the first tile, at the same place in it; x from w to 2w - 1 is in the second tile, which starts over from 0; and so on. That's the remainder of a division (module 6): the place in the tile is `x % w`. For a tile 8 pixels wide:

| x in the big image | 0 | 1 | ... | 7 | 8 | 9 | ... | 15 | 16 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `x % 8`, in the tile | 0 | 1 | ... | 7 | 0 | 1 | ... | 7 | 0 |

Down, it's `y % h` for a tile `h` pixels high. Wrapping paper with the 8 x 8 heart of `icon.png`, whose corners are transparent:

**The image icon.png**

![icon.png](icon.png)

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Image heart = new Image("file:icon.png");
        PixelReader reader = heart.getPixelReader();
        int w = (int) heart.getWidth();
        int h = (int) heart.getHeight();

        WritableImage paper = new WritableImage(4 * w, 3 * h);
        PixelWriter writer = paper.getPixelWriter();
        for (int y = 0; y < 3 * h; y++) {
            for (int x = 0; x < 4 * w; x++) {
                writer.setColor(x, y, reader.getColor(x % w, y % h));
            }
        }

        stage.setScene(new Scene(new Pane(new ImageView(paper))));
        stage.setTitle("Wrapping paper");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

The transparent corners of the heart stay transparent in the copies: `getColor` reads them as a color whose opacity is 0, and `setColor` writes that.

## Tile by tile

The same image can be made the other way round: go through the tiles, and copy the whole small image into each one, shifted, as step 4 put a picture on a mat. The tile in column `tx` and row `ty` starts at (tx * w, ty * h):

```java
for (int ty = 0; ty < 3; ty++) {
    for (int tx = 0; tx < 4; tx++) {
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                writer.setColor(tx * w + x, ty * h + y, reader.getColor(x, y));
            }
        }
    }
}
```

Both ways give exactly the same pixels. The one with `%` needs only two loops instead of four. The one tile by tile always knows which tile it is writing, `tx` and `ty`. The next part works that out in the two-loop version too, with a division.

## Mirrored tiles

Tiles that are all the same make a plain pattern. Mirror every other tile, and each edge meets its own mirror image, which gives the symmetry of a tiled floor or a quilt. Which tile a pixel is in is a whole-number division: across, `x / w` is 0 in the first tile, 1 in the second, and so on. In the tiles with an odd number, the pixel reads from the other side of the tile: column `w - 1 - x % w` instead of `x % w`, so the tile's column 0 shows its last column, and its last column shows column 0. The same down the image, with rows, turns tiles upside down. The landscape, 2 x 2, mirrored both ways:

**The image landscape.png**

![landscape.png](landscape.png)

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Image tile = new Image("file:landscape.png");
        PixelReader reader = tile.getPixelReader();
        int w = (int) tile.getWidth();
        int h = (int) tile.getHeight();

        WritableImage pattern = new WritableImage(2 * w, 2 * h);
        PixelWriter writer = pattern.getPixelWriter();
        for (int y = 0; y < 2 * h; y++) {
            for (int x = 0; x < 2 * w; x++) {
                int fromX = x % w;
                if (x / w % 2 == 1) {
                    fromX = w - 1 - fromX;
                }
                int fromY = y % h;
                if (y / h % 2 == 1) {
                    fromY = h - 1 - fromY;
                }
                writer.setColor(x, y, reader.getColor(fromX, fromY));
            }
        }

        stage.setScene(new Scene(new Pane(new ImageView(pattern))));
        stage.setTitle("Mirrored");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

`x / w % 2` is worked out from left to right, `(x / w) % 2`: the tile's number, then whether it's odd. The top right tile is the landscape mirrored left to right, the bottom left one is upside down, like a reflection in the lake, and the bottom right one is both.

---

Source: [Tiling an image](https://javaarena.com/learn/drawing-and-images/tiling/) in the module [Drawing, images and sound](https://javaarena.com/learn/drawing-and-images/) on Java Arena.

This module follows section [14.2 Multimedia in programs](https://java-programming.mooc.fi/part-14/2-multimedia-in-programs) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
