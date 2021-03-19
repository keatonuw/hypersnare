# hypersnare
Generates snares inspired by the genre of 'hyperpop,' drawing specifically from
a technique umru has described, where a snare sound is ran through a series
of flangers, resonators, delays, and distortions.

### Synthesis
As briefly described above, the snares are created by manipulation of several
effects. First, a snare is generated with simple subtractive synthesis. It is
made of a tone and noise, which are filtered. The resulting sound is then ran
through a (yet-to-be) randomized chain of effects, currently limited to a
karplus-strong style delay line. This creates the alien metallic sound so
prevalent in the hyperpop genre!

### Software Design
The program is made of two parts, client and implementation. The audio IO
implementation is handled by StdAudio, a class written by Robert Sedgewick
and Kevin Wayne for Princeton (huge thanks, it makes working with Java's
cryptic AudioSystem so much easier!). I also implemented a simple set of audio
synthesis classes to handle the creation of sound.

I define a hierarchy of interfaces that describe the intended functionality of
the separate sound classes I wrote.  
*TODO: add picture of class hierarchy*

Finally, the main client class allows for the user to randomize, hear, and save
different snare sounds!

### To-Do:
- Add additional audio effects (filter bank, saturator, delay)
- Create class to manage and randomize effect chain
- Create class to represent a "HyperSnare" (a snare and an effect chain)
- Add saving functionality to main
- Improve quality of README
- Add UI?
