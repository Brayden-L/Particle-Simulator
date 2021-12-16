# Particle-Simulator
A Java application which simulates the behaviors and interactions of elementary particles in a customizable, 2-dimensional environment. Made for a local technology competition, 2022.

## Planned Features:

### 1. Environment:
- Constants, e.g. gravity, the speed of light.
    - Size (dimensions).
    - Rules:
        - Scripting API for adding custom behaviors, probably Lua or imported custom classes.
        - Particle behavior.
    - Starting values.

### 2. Rendering:
- Particle trails.
    - Framerate.
    - Colorscheme.
    - "Smart" rendering, such as rendering only what would be displayed to the camera and using cached results, etc.

### 3. Interface:
- Sliders to adjust environmental factors, such as:*
    - Time.
    - Gravity.
    - The speed of light.
    - Attributes of selected particles.
- Start/Pause/Stop simulation buttons.
- Custom particle creation GUI.
- In-built text editor for configuration.
- and TOML, e.g.,*

```toml
[environment.area]
x = 100
y = 100
z = 100
    
[environment.constants]
c = 500
g = 600
    
[particles]
electron    = {mass = 0.01, charge = -1}
proton      = {mass = 1,    charge = 1}
```

### Brief Summary of UI Design Goal:
Provide a single, elegant, and intuitive graphical user interface for the management and manipulation of a simulated environment. There will be several clearly labeled buttons and (hopefully) intuitive (all on the same page) menus. The main body of the window will consist of a 2D simulation of particles which can be made to interact, the sides and top of which will consist of menus for the manipulation of said environment.

## Features for Alpha Release (TODO)
- [ ] Use TOML config file for default laws of physics.
- [ ] Create 2D rendered area within a window containing:
    - [ ] Buttons for:
      - [ ] Start/Pause/Stop.
      - [ ] Menu invocation.**
    - [ ] Sliders for:
        - [ ] Scale.
        - [ ] Time.
        - [ ] Speed.
    - [ ] Text boxes for:
        - Slider values, accept double precision floating point numbers.
    - [ ] Menus for:**
        - [ ] Particle management:
            - [ ] Creation. (At Position, Attributes, etc).
            - [ ] Destruction.
            - [ ] Attribute modification:
                - [ ] Charge.
                - [ ] Mass.
                - [ ] Replace with other type.
- [ ] 2D environment:
  - [ ] Spatial partitioning.
  - [ ] Coordinate system.
- [ ] Particles:
  - [ ] Attributes (see described above.)
    - [x] Charge.
    - [x] Mass.
    - [x] Type.
    - [ ] Position.
    - [ ] ID.
    - [ ] Velocity.
  - [ ] Scripted behaviors:
    - [ ] Fields.
    - [ ] Collision.
    - [ ] Decay.
    - [ ] Fusion.
    - [ ] Fission.
    - [ ] Formation of molecules:
      - [ ] 


## Reference Material
- https://en.wikipedia.org/wiki/Fundamental_interaction
- https://en.wikipedia.org/wiki/Space_partitioning#In_computer_graphics
- https://toml.io/en/v1.0.0
- https://docs.oracle.com/javase/8/javafx/graphics-tutorial/title.htm#top
- https://www.geeksforgeeks.org/java-util-vector-class-java/
- https://www.guru99.com/multithreading-java.html
- https://docs.oracle.com/javase/specs/jls/se7/html/jls-17.html
- https://www.realtimerendering.com/resources/GraphicsGems/
- https://libgdx.com/
- https://github.com/libgdx/libgdx/wiki
- https://libgdx.com/dev/simple-game/
- https://stackoverflow.com/questions/11513344/how-to-implement-the-fast-inverse-square-root-in-java
- https://libgdx.badlogicgames.com/ci/nightlies/docs/api/com/badlogic/gdx/math/Vector2.html
- 

- https://luau-lang.org/
- https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started.html
- https://www.jetbrains.com/help/idea/spring-boot.html
- https://d3js.org/

- http://hyperphysics.phy-astr.gsu.edu/hbase/electric/maxeq.html
- https://www.britannica.com/science/Lorentz-force
- https://www.britannica.com/science/electromagnetism
- https://www.britannica.com/science/electric-charge
- https://www.britannica.com/science/Coulomb-force
- https://www.britannica.com/science/magnetic-field
- https://www.britannica.com/science/electric-field
- https://www.britannica.com/science/physical-constant
- https://www.mathsisfun.com/algebra/vectors-cross-product.html
- https://www.brightstorm.com/science/physics/magnetism/lorentz-force/
- https://www.britannica.com/science/gravitational-constant
- https://www.mathsisfun.com/algebra/vectors-dot-product.html
- https://www.quora.com/What-is-the-mass-of-an-electron-in-AMU
- https://en.wikipedia.org/wiki/List_of_chemical_elements
- https://www.physics.princeton.edu/~mcdonald/examples/2dem.pdf
- https://www.sciencedirect.com/topics/earth-and-planetary-sciences/atomic-collision
- https://www.sciencedirect.com/topics/engineering/coulomb-repulsion
- https://en.wikipedia.org/wiki/Orthogonal_complement
- https://stackoverflow.com/questions/243945/calculating-a-2d-vectors-cross-product
- https://www.realtimerendering.com/resources/GraphicsGems/
- https://mathworld.wolfram.com/PerpDotProduct.html
- https://www.youtube.com/watch?v=eu6i7WJeinw

### VECTOR RESOURCES:
- https://www.gamedev.net/forums/topic/289972-cross-product-of-2d-vectors/
- https://gamedev.stackexchange.com/questions/70075/how-can-i-find-the-perpendicular-to-a-2d-vector
- https://www.ucl.ac.uk/~ucahmdl/LessonPlans/Lesson10.pdf
- https://www.mathsisfun.com/algebra/vectors-cross-product.html
- https://www.mathsisfun.com/algebra/vectors-dot-product.html
- https://stackoverflow.com/questions/243945/calculating-a-2d-vectors-cross-product
- https://www.nagwa.com/en/explainers/175169159270/
- https://www.gamedev.net/articles/programming/math-and-physics/practical-use-of-vector-math-in-games-r2968/

