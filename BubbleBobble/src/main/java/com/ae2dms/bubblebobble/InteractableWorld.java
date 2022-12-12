package com.ae2dms.bubblebobble;

import com.ae2dms.bubblebobble.factory.*;
import com.ae2dms.bubblebobble.marks.Marks;
import com.ae2dms.bubblebobble.model.*;
import com.ae2dms.bubblebobble.model.removable.hostile.Boss;
import com.ae2dms.bubblebobble.model.removable.hero.Hero;
import com.ae2dms.bubblebobble.model.removable.hostile.Monster;
import com.ae2dms.bubblebobble.model.unremovable.environment.Background;
import com.ae2dms.bubblebobble.model.unremovable.environment.CeilingUnit;
import com.ae2dms.bubblebobble.model.unremovable.environment.FloorUnit;
import com.ae2dms.bubblebobble.model.unremovable.environment.WallUnit;
import com.ae2dms.bubblebobble.model.removable.fruit.Fruit;
import com.ae2dms.bubblebobble.model.removable.projectile.EnemyProjectile;
import com.ae2dms.bubblebobble.model.removable.projectile.HeroProjectile;
import com.ae2dms.bubblebobble.sound.SoundEffect;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * InteractableWorld handles all of the game's operations:
 * updating positions, checking for collisions, and removing objects.
 */
public class InteractableWorld {
    public int level = 1;
    public Fruit fruit;
    private ArrayList<CeilingUnit> ceilingUnits;
    private ArrayList<FloorUnit> floorUnits;
    private ArrayList<WallUnit> wallUnits;
    public ArrayList<Hero> heroes;
    public ArrayList<Monster> monsters;
    private ArrayList<HeroProjectile> heroProjectiles;
    private ArrayList<EnemyProjectile> enemyProjectiles;
    public ArrayList<Fruit> fruits;
    private ArrayList<GameObject> toBeRemoved;
    public ArrayList<Boss> bosses;
    private Image life = new Image(String.valueOf(Main.class.getResource("image/heart.gif")));
    private static int Width;
    private static int Height;
    public boolean win = false;
    Stage stage = null;
    InputStream input = null;
    private boolean readyToReset;
    Background background = Background.getInstance();

    public InteractableWorld(int width, int height) {
        //initializes interactableworld
        Width = width;
        Height = height;
        ceilingUnits = new ArrayList<CeilingUnit>();
        floorUnits = new ArrayList<FloorUnit>();
        wallUnits = new ArrayList<WallUnit>();
        heroes = new ArrayList<Hero>();
        monsters = new ArrayList<Monster>();
        heroProjectiles = new ArrayList<HeroProjectile>();
        enemyProjectiles = new ArrayList<EnemyProjectile>();
        fruits = new ArrayList<Fruit>();
        toBeRemoved = new ArrayList<GameObject>();
        bosses = new ArrayList<Boss>();
        readyToReset = false;
    }

    protected void paintComponent(GraphicsContext g) {
        g.drawImage(background.getBackground(), 0, 0, Main.WIDTH * Main.getUnitSize(), Main.HEIGHT * Main.getUnitSize());
        g.drawImage(life, 60, 20, 50, 50);
        g.setFill(Color.RED);
        g.fillText("  × " + GamePanel.self.heroLife, 100, 60);
        g.setFill(Color.BLACK);
        g.setFont(new Font(35));
        g.fillText("Score: " + fruit.score, 320, 50);
        for (CeilingUnit ceilingUnit : ceilingUnits) {
            ceilingUnit.drawOn(g);
        }
        for (FloorUnit floorUnit : floorUnits) {
            floorUnit.drawOn(g);
        }
        for (WallUnit wallUnit : wallUnits) {
            wallUnit.drawOn(g);
        }
        for (Hero hero : heroes) {
            hero.drawOn(g);
        }
        for (Monster monster : monsters) {
            monster.drawOn(g);
        }
        for (Boss boss : bosses) {
            boss.drawOn(g);
        }
        for (EnemyProjectile enemyProjectile : enemyProjectiles) {
            enemyProjectile.drawOn(g);
        }
        for (HeroProjectile heroProjectile : heroProjectiles) {
            heroProjectile.drawOn(g);
        }
        for (Fruit fruit : fruits) {
            fruit.drawOn(g);
        }
    }

    void updatePosition() throws IOException {
        //updates positions of everything on screen
        for (Hero hero : heroes) {
            hero.update();
        }
        for (Monster monster : monsters) {
            monster.update();
            if (monster.isCanRemove()) {
                toBeRemoved.add(monster);
            }
        }
        for (Boss boss : bosses) {
            boss.update();
            if (boss.isCanRemove()) {
                toBeRemoved.add(boss);
            }
        }

        for (EnemyProjectile enemyProjectile : enemyProjectiles) {
            enemyProjectile.update();
            if (enemyProjectile.isCanRemove()) {
                toBeRemoved.add(enemyProjectile);
            }
        }
        for (HeroProjectile heroProjectile : heroProjectiles) {
            heroProjectile.update();
            if (heroProjectile.isCanRemove()) {
                toBeRemoved.add(heroProjectile);
            }
        }
        for (Fruit fruit : fruits) {
            fruit.update();
            if (fruit.isCanRemove()) {
                toBeRemoved.add(fruit);
            }
        }

        // Units initiate collisions with Heroes, Enemies, and Fruits
        for (CeilingUnit ceilingUnit : ceilingUnits) {
            for (Hero hero : heroes) {
                ceilingUnit.collideWith(hero);
            }
            for (Monster monster : monsters) {
                ceilingUnit.collideWith(monster);
                monster.collideWith(ceilingUnit);
            }
            for (Boss boss : bosses) {
                ceilingUnit.collideWith(boss);
                boss.collideWith(ceilingUnit);
            }
            for (Fruit fruit : fruits) {
                ceilingUnit.collideWith(fruit);
            }
            for (EnemyProjectile enemyProjectile : enemyProjectiles) {
                ceilingUnit.collideWith(enemyProjectile);
            }
            for (HeroProjectile heroProjectile : heroProjectiles) {
                ceilingUnit.collideWith(heroProjectile);
            }
        }
        for (FloorUnit floorUnit : floorUnits) {
            for (Hero hero : heroes) {
                floorUnit.collideWith(hero);
            }
            for (Monster monster : monsters) {
                floorUnit.collideWith(monster);
                monster.collideWith(floorUnit);
            }
            for (Boss boss : bosses) {
                floorUnit.collideWith(boss);
                boss.collideWith(floorUnit);
            }
            for (Fruit fruit : fruits) {
                floorUnit.collideWith(fruit);
            }
            for (EnemyProjectile enemyProjectile : enemyProjectiles) {
                floorUnit.collideWith(enemyProjectile);
            }
            for (HeroProjectile heroProjectile : heroProjectiles) {
                floorUnit.collideWith(heroProjectile);
            }
        }
        for (WallUnit wallUnit : wallUnits) {
            for (Hero hero : heroes) {
                wallUnit.collideWith(hero);
            }
            for (Monster monster : monsters) {
                wallUnit.collideWith(monster);
                monster.collideWith(wallUnit);
            }
            for (Boss boss : bosses) {
                wallUnit.collideWith(boss);
                boss.collideWith(wallUnit);
            }
            for (Fruit fruit : fruits) {
                wallUnit.collideWith(fruit);
            }
            for (EnemyProjectile enemyProjectile : enemyProjectiles) {
                wallUnit.collideWith(enemyProjectile);
            }
            for (HeroProjectile heroProjectile : heroProjectiles) {
                wallUnit.collideWith(heroProjectile);
            }
        }
        // Enemies initiate collisions with Heroes
        for (Monster monster : monsters) {
            for (Hero hero : heroes) {
                monster.collideWith(hero);
            }
        }

        for (Boss boss : bosses) {
            for (Hero hero : heroes) {
                boss.collideWith(hero);
            }
        }
        // HeroProjectiles initiate collisions with Heroes and Enemies
        for (HeroProjectile heroProjectile : heroProjectiles) {
            for (Hero hero : heroes) {
                heroProjectile.collideWith(hero);
            }
            for (Monster monster : monsters) {
                heroProjectile.collideWith(monster);
            }
            for (Boss boss : bosses) {
                heroProjectile.collideWith(boss);
            }
            for (EnemyProjectile enemyProjectile : enemyProjectiles) {
                heroProjectile.collideWith(enemyProjectile);
            }
            for (FloorUnit floorUnit : floorUnits) {
                heroProjectile.collideWith(floorUnit);
            }

        }
        for (EnemyProjectile enemyProjectile : enemyProjectiles) {
            for (Hero hero : heroes) {
                enemyProjectile.collideWith(hero);
            }
            for (HeroProjectile heroProjectile : heroProjectiles) {
                enemyProjectile.collideWith(heroProjectile);
            }
        }
        // Fruits intiate collisions with Heroes
        for (Fruit fruit : fruits) {
            for (Hero hero : heroes) {
                fruit.collideWith(hero);
            }
        }

        // Removing...
        for (GameObject obj : toBeRemoved) {
            remove(obj);
        }
        toBeRemoved.removeAll(toBeRemoved);
        if (readyToReset)
            startGame();
    }

    public void addCeilingUnit(CeilingUnit ceilingUnit) {
        ceilingUnits.add(ceilingUnit);
    }

    public void addFloorUnit(FloorUnit floorUnit) {
        floorUnits.add(floorUnit);
    }

    public void addWallUnit(WallUnit wallUnit) {
        wallUnits.add(wallUnit);
    }

    void addHero(Hero hero) {
        //adds a hero to the map
        heroes.add(hero);
    }

    void addEnemy(Monster monster) {
        //adds a mook to the map
        monsters.add(monster);
    }

    void addBoss(Boss boss) {
        //adds a boss to the map
        bosses.add(boss);
    }

    public void addHeroProjectile(HeroProjectile heroProjectile) {
        //adds a projectile to where necessary
        heroProjectiles.add(heroProjectile);
    }

    public void addEnenmyProjectile(EnemyProjectile enemyProjectile) {
        enemyProjectiles.add(enemyProjectile);
    }

    public void addFruit(Fruit fruit) {
        //adds fruit on bubble pop
        fruits.add(fruit);
    }

    public void addBubble() {//Bubble bubble) {
        for (Monster monster : monsters) {
            monster.collideWithProjectile();
        }
        SoundEffect.play("/com/ae2dms/bubblebobble/sfx/explode.wav");

    }

    void clearContents() {
        //clears everything from the screen
        ceilingUnits.removeAll(ceilingUnits);
        floorUnits.removeAll(floorUnits);
        wallUnits.removeAll(wallUnits);
        heroes.removeAll(heroes);
        monsters.removeAll(monsters);
        enemyProjectiles.removeAll(enemyProjectiles);
        heroProjectiles.removeAll(heroProjectiles);
        fruits.removeAll(fruits);
        bosses.removeAll(bosses);
    }

    public void remove(GameObject obj) {
        //removes a single object from the screen
        ceilingUnits.remove(obj);
        floorUnits.remove(obj);
        wallUnits.remove(obj);
        heroes.remove(obj);
        monsters.remove(obj);
        enemyProjectiles.remove(obj);
        heroProjectiles.remove(obj);
        fruits.remove(obj);
        bosses.remove(obj);
    }

    public void markToReset() {
        //sets boolean to make sure the world is ready to be reset
        readyToReset = true;
    }

    void startGame() throws IOException {
        if (level <= 3) {
            //"World" + level + ".txt"
            //input = this.getClass().getClassLoader().getResourceAsStream("world/World1.txt");
            File input = new File ("bubblebobble/src/main/resources/com/ae2dms/bubblebobble/world/World" + level + ".txt");
            Scanner scanner = new Scanner(input);
            clearContents();
            for (int row = 0; row < Main.HEIGHT; row++) {
                String currentLine = scanner.next();
                for (int col = 0; col < Main.WIDTH; col++) {
                    if (currentLine.charAt(col) == '*') {
                        addFloorUnit(new FloorUnitProducer().produce(this, col, row, 0));
                    } else if (currentLine.charAt(col) == 'H') {
                        addHero(new HeroProducer().produce(this, col, row, 0));
                    } else if (currentLine.charAt(col) == '|') {
                        addWallUnit(new WallUnitProducer().produce(this, col, row, 0));
                    } else if (currentLine.charAt(col) == '_') {
                        addCeilingUnit(new CeilingUnitProducer().produce(this, col, row, 0));
                    } else if (currentLine.charAt(col) == 'M') {
                        addEnemy(new MonsterProducer().produce(this, col, row, 0));
                    } else if (currentLine.charAt(col) == 'B') {
                        addBoss(new BossProducer().produce(this, col, row, 0));
                    }
                }
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }
            scanner.close();
            readyToReset = false;
        }
        if (level == 4) {
            if (monsters.isEmpty() && fruits.isEmpty() && bosses.isEmpty()) {
                win = true;
                new Marks(fruit.score);
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/win.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load(), Main.getSCENE_WIDTH(), Main.getSCENE_HEIGHT());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage = Main.stage;
                stage.setTitle("BubbleBobble Success");
                stage.setScene(scene);
                stage.show();
                fruit.score = 0;
                return;
            }
        }
    }

    public static int getWidth() {
        return Width;
    }

    public static int getHeight() {
        return Height;
    }

}
