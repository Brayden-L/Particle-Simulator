# Welcome to Particle Simulator
A piece of educational software by Brayden L, written in Java 8 with the LibGDX framework.
## Contents:
- [Specification](#Specification)
- [How to Use](#Instructions)
- [JavaDoc](javadoc/index.html)
- [Source code](https://github.com/Brayden-L/Particle-Simulator)
- [Resources Used](#Resources)

# Specification
[Particle Simulator](https://github.com/Brayden-L/Particle-Simulator) uses [TOML](https://toml.io/), 
parsed by [toml4j](https://github.com/mwanji/toml4j), to generate and render subatomic particles and their 
interactions, with [LibGDX](https://libgdx.com/). The configuration specification goes as follows:
```toml
[configuration]
width   = 1920
height  = 1080

[[particles]]
type = "electron"
pos  = [0, 0]
vel  = [3.14, 69.420, 8.00]

[[particles]]
type = "proton"
pos = [900, 500]
vel = [3.14, 69.420, 8.00]
```
- `[configuration]` parameters define the window size, the default values fit the average 1080p monitor.
- `[[particles]]` are a bit more complex. It is an array of tables, a list of lists, so to speak:
  - The `type` parameter defines a type of either proton, neutron, or electron. An error is thrown if an invalid type 
is supplied.
  - The `pos` parameter defines a position; use integers or an error is thrown.
  - The `vel` parameter is the most complex of the user-specified values. The first two values define direction, the 
other magnitude.
    - Value 1 is the "rise" component of slope (change in y).
    - Value 2 is the "run" component of slope (change in x). Do not worry about magnitude as a result of slope, 
Particle Simulator will normalize it to 1.
    - Value 3 is the magnitude component of the velocity vector.

# Instructions
1. Ensure that your machine has [Java installed](https://java.com/en/download/help/download_options.html).
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

