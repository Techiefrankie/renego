# renego
Renmoney Backend Algorithm test

Write a console application that accepts two numeric parameters and works according to this
description below:
The application uses two number generators (A and B) that work according to the following principles:
Initial numbers of the generators are application parameters (generator A starts with the first
parameter; generator B starts with the second);
The number is multiplied by a factor;
(Generator A factor = 16807, generator B factor = 48271);
This result of multiplication is divided by 2147483647;
Result of division is a remainder.
This remainder becomes the starting number of the next iteration.
Resulting numbers are checked according to the following principles:
- Take one number from each generator and compare whether their last 8 bits match.
