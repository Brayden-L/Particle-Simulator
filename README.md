# Particle-Simulator
A Java application which simulates the behaviors and interactions of elementary particles in a customizable, 3-dimensional environment. Made for a local technology competition, 2022.

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
Provide a single, elegant, and intuitive graphical user interface for the management and minipulation of a simulated environment. There will be several clearly labeled buttons and (hopefully) intuitive (all on the same page) menus. The main body of the window will consist of a 3D simulation of particles which can be made to interact, the sides and top of which will conists of menus for the maniuplation of said environment.

## Features for Alpha Release (TODO)
- [ ] Use TOML config file for default laws of physics.
- [ ] Create 3D rendered area within a window containing:
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
- [ ] 3D environment:
  - [ ] Spatial partitioning.
  - [ ] Coordinate system.
- [ ] Particles:
  - [ ] Attributes (see described above.)
  - [ ] Scripted behaviors:
    - [ ] Fields.
    - [ ] Collision.
    - [ ] Decay.
    - [ ] Fusion.
    - [ ] Fission.
    - [ ] Combination. 


## Reference Material
- https://en.wikipedia.org/wiki/Fundamental_interaction
- https://doc.qt.io/qt-6/qml-qtquick3d-view3d.html
- https://doc.qt.io/qt-6/qtquick3d-2d.html
- https://doc.qt.io/qt-5/qopenglwidget.html
- https://en.wikipedia.org/wiki/Space_partitioning#In_computer_graphics