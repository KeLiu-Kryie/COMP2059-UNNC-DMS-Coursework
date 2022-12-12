# AE2DMS-CW-20217275
## Maintenance
### Design Patterns
1. Factory Method Pattern
    - Package *com.ae2dms.bubblebobble.factory*, there is **an abstract factory providing an interface** for creating products and **specific factories** to initialize objects. And all **concrete instance objects inherits** from **the same abstract class**.<br>
    - Only need to add a factory when adding a specific object. The original factory doesn't need to be modified, which conforms to the "open-close" principle.
2. Strategy Pattern
    - Package *com.ae2dms.bubblebobble.model.removable.hostile.strategy*, a ShootBehavior **interface** with **two concrete strategy classes** implementing the interface are encapsulated. Class **Monster and Boss** will **use the ShootBehavior strategy** to decide can shoot or not. **The behavior of Monster and boss or their algorithm can be changed at run time**
    - Strategy pattern improves confidentiality and security of algorithm and avoid multiple conditional transition statements. Strategy pattern conforms to "open-close" principle.
3. State Pattern
    - Package *com.ae2dms.bubblebobble.model.removable.hostile.state*, there is a **State interface** and **instance State classes implementing the State interface**. **Class Monster and Boss are the class with the state**. These **classes will make changes on behavio**r when **state changes**.
    - Convenience on adding new state. Reducing dependence on conditional statements. This pattern encapsulates the transformation rules.
4. Singleton Pattern
    - Class *Background* in package *com.ae2dms.bubblebobble.model.unremovable.environment* from **line 12 to 20**. It makes sure the class only has one instance, and provides a public access method. Class **InteractableWorld line 54** gets the unique object from Background class.
    - Controls the number of instance and saves the systematic resources.
5. MVC Pattern
    - M is application's dynamic data structure. V is interface. C is control center. C accepts the users input and give it to M to deals with and back to C then shows it in V.  This three closely connected, but independent.
### Inherit(In package model)
1. Divide **GameObject** into **MovableObject and UnmovableObject**.
2. Divide **enemy** into **monster and boss**.
3. Divide **projectie** into **EnemyProjectile and HeroProjectile**.

### Encapsulation in variables.
### Break long methods.
### Good naming.

## Extension
### 1. Theme Selection
Players can choose **eight different themes** to switch background, ceiling, wall and floor in one time.
### 2. Score System
Score is stored and players can see **permanent high score list**. Players get notified if break records.
### 3. Level
Players **enter next level automatically** if destroy all current enemies and pick all fruits. The difficulty of level increases gradually.
### 4. Boss
Boss is a fierce enemy with larger size, stronger defenses and faster speed that has **ability to shoot**. Boss shows up in the last level.
### 5. Projectile
1. Extension:
    - Hero can **stand on its projectile** and float with it.
    - Hero's projectile and boss's projectile will **counteract** if combined.
2. Modification:
    - Projectile can't across the floor.
    - Projectile only react with the first object it meets.
### 6. Hero
Hero has **3 lives**. Hero **rebirths at birthplace** in a few seconds **invincibility state** if loses a life. Hero can use shilled and **special attack**.
### 7. Fruits
Different fruits have different scores with **corresponding probability**.
### 8. Guide
Players can read **guide**.
### 9. Aesthetics
**Nice interface and images**.
