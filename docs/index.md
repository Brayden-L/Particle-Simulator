# Welcome to Particle Simulator
A piece of educational software by Brayden L, written in Java 8 with the LibGDX framework.
## Contents:
- [Specification](#specification)
- [How to Use](#instructions)
- [JavaDoc](javadoc/index.html)
- [Source code](https://github.com/Brayden-L/Particle-Simulator)
- [Resources Used](#resources)

# Specification
[Particle Simulator](https://github.com/Brayden-L/Particle-Simulator) uses [TOML](https://toml.io/), 
parsed by [toml4j](https://github.com/mwanji/toml4j), to generate and render subatomic particles and their 
interactions, with [LibGDX](https://libgdx.com/). The configuration specification goes as follows:
```toml
[configuration]
width   = 1920
height  = 1080
rgb     = [0, 0, 0]
delay   = 0

[CONSTANTS]
GRAVITYCONSTANT = 6.67408e-11
AMUKGC          = 1.6605E-27
FARADAY         = 96485
COULOMB         = 8.99e9
ELECTRIC        = 1.1510444E-10
PI              = 3.14

[[particles]]
type = "electron"
pos  = [0, 0]
vel  = [1, 1]

[[particles]]
type = "proton"
pos = [10, 200]
vel = [3, 2]
```
- `[configuration]` parameters define certain program attributes:
  - The `width` parameter defines window width.
  - The `height` parameter defines window height. Both `width` and `height` are configured, by default, 
to fit a normal 1080p monitor.
  - The `rgb` parameter defines the background color in accordance with an [RGB]() color value.
  - The `delay` parameter defines a delay, in milliseconds, between the rendering of frames. This is used to more 
closely observe the changes in particle position.
- `[CONSTANTS]` parameters are [various physical constants](https://www.britannica.com/science/physical-constant) used 
in the simulator. Some are currently unused, but will be used in future versions. Their default values are "close" 
approximations to those found in nature. It is recommended to decrease the value of `COLOUMB` or increase the `delay` 
parameter of `[CONFIGURATION]` in order to slow down the simulation to easily viewable levels, as the 
electrostatic/electromagnetic force is one of the strongest in nature, and therefore has a seemingly disproportionate 
effect on the simulation in its small space.
- `[[particles]]` are a bit more complex. It is an array of tables, a list of lists, so to speak:
  - The `type` parameter defines a type of either proton, neutron, or electron. An error is thrown if an invalid type 
is supplied.
  - The `pos` parameter defines a position; use integers or an error is thrown.
  - The `vel` parameter is the most complex of the user-specified values.
    - Value 1 is the "rise" component of slope (change in y).
    - Value 2 is the "run" component of slope (change in x).
    
# Instructions
1. Ensure that your machine has [Java 8 installed](https://www.java.com/en/download/manual.jsp).
2. Download the [most recent release](https://github.com/Brayden-L/Particle-Simulator/releases).
3. Adjust the `simulator.toml` file to your liking, in your preferred text editor.
4. Double-click the jar or run via line, via: `java -jar Particle-Simulator.jar`

# Resources
- [LibGDX Documentation](https://libgdx.com/wiki/)
- [TOML Spec](https://toml.io/en/)
- [toml4j](https://github.com/mwanji/toml4j)
- [Java Documentation](https://docs.oracle.com/en/java/)
- [Decimal to Fraction Algorithm](https://stackoverflow.com/questions/5124743/algorithm-for-simplifying-decimal-to-fractions)
- [Fundamental Interaction](https://en.wikipedia.org/wiki/Fundamental_interaction)
- [Lorentz Force](https://www.britannica.com/science/Lorentz-force)
- [Electromagnetism](https://www.britannica.com/science/electromagnetism)
- [Electric Charge](https://www.britannica.com/science/electric-charge)
- [Coulomb Force](https://www.britannica.com/science/Coulomb-force)
- [Magnetic Fields](https://www.britannica.com/science/magnetic-field)
- [Electric Field](https://www.britannica.com/science/electric-field)
- [Physical Constants](https://www.britannica.com/science/physical-constant)

# Credits
Thank you for using or showing an interest in my project. \
I thank my family and friends, both personal and online, for their continued support and interest in this project and my 
development as a programmer and a person.